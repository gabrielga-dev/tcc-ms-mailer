package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.events.mailer.application.config.resolver.StaticTemplateExecutor;
import br.com.events.mailer.domain.entity.EmailTemplate;
import br.com.events.mailer.domain.message.PersonCreationEmailValidationEmailMessage;
import br.com.events.mailer.domain.repository.EmailTemplateRepository;
import br.com.events.mailer.infrastructure.exception.ErrorAtParsingJsonBodyException;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * This class handle emails with id equals to 2. Emails validation at person creation.
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
public class PersonCreationEmailValidationEmailTemplateHandlerImpl
    extends EmailTemplateHandler<PersonCreationEmailValidationEmailMessage> {

    private final ObjectMapper objectMapper;

    @Value("${email.verification.url}")
    private String emailValidationUrl;

    public PersonCreationEmailValidationEmailTemplateHandlerImpl(
        final EmailTemplateRepository repository,
        final ObjectMapper objectMapper
    ) {
        super(repository);
        this.objectMapper = objectMapper;
    }

    public Long getHandledTemplateId() {
        return 2L;
    }

    @Override
    public Map<String, Object> generateMapValues(PersonCreationEmailValidationEmailMessage values) {
        return Map.of(
            "personFirstName", values.getPersonFirstName(),
            "personLastName", values.getPersonLastName(),
            "validationLink", emailValidationUrl + values.getEmailValidationUuid()
        );
    }

    @Override
    protected String applyDataToTemplate(final String jsonBody, final EmailTemplate template) {
        try {
            var data = objectMapper.readValue(
                jsonBody, PersonCreationEmailValidationEmailMessage.class
            );

            var params = generateMapValues(data);
            var context = new Context();
            params.forEach(context::setVariable);

            var messageResolver = new StandardMessageResolver();
            var executor = new StaticTemplateExecutor(
                context, messageResolver, StandardTemplateModeHandlers.HTML5.getTemplateModeName()
            );

            return executor.processTemplateCode(template.getContent());
        } catch (Exception e) {
            log.error(
                "Error trying to parse the following body to PersonCreationEmailValidationEmailMessage: {}",
                jsonBody
            );
            throw new ErrorAtParsingJsonBodyException();
        }
    }
}
