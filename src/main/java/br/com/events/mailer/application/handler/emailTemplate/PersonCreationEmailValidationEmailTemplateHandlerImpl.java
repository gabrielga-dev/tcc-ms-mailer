package br.com.events.mailer.application.handler.emailTemplate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

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
public class PersonCreationEmailValidationEmailTemplateHandlerImpl extends EmailTemplateHandler {

    private final ObjectMapper objectMapper;

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
    protected String applyDataToTemplate(final String jsonBody, final EmailTemplate template) {
        try {
            var data = objectMapper.readValue(
                jsonBody, PersonCreationEmailValidationEmailMessage.class
            );
            return template.getContent();
        } catch (Exception e) {
            log.error(
                "Error trying to parse the following body to PersonCreationEmailValidationEmailMessage: {}",
                jsonBody
            );
            throw new ErrorAtParsingJsonBodyException();
        }
    }
}
