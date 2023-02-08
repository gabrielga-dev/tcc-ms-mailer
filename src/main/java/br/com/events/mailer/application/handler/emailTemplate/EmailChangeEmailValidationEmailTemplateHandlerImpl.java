package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.events.mailer.domain.message.EmailChangeEmailValidationEmailMessage;
import br.com.events.mailer.domain.message.PasswordChangeEmailValidationEmailMessage;
import br.com.events.mailer.domain.repository.EmailTemplateRepository;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * This class handle emails with id equals to 2. Emails validation at person creation.
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
public class EmailChangeEmailValidationEmailTemplateHandlerImpl
    extends EmailTemplateHandler<EmailChangeEmailValidationEmailMessage> {

    private final ObjectMapper objectMapper;

    @Value("${password.change.url}")
    private String passwordChangeUrl;

    public EmailChangeEmailValidationEmailTemplateHandlerImpl(
        final EmailTemplateRepository repository,
        final ObjectMapper objectMapper
    ) {
        super(repository);
        this.objectMapper = objectMapper;
    }

    public Long getHandledTemplateId() {
        return 4L;
    }

    @Override
    public String getSubject(EmailChangeEmailValidationEmailMessage data) {
        return "Troca de email no MyEvents!";
    }

    @Override
    public EmailChangeEmailValidationEmailMessage parseData(final String jsonData) throws JsonProcessingException {
        return objectMapper.readValue(
            jsonData, EmailChangeEmailValidationEmailMessage.class
        );
    }

    @Override
    public Map<String, Object> generateMapValues(EmailChangeEmailValidationEmailMessage values) {
        return Map.of(
            "personFirstName", values.getPersonFirstName(),
            "personLastName", values.getPersonLastName(),
            "validationLink", passwordChangeUrl + values.getEmailValidationUuid()
        );
    }
}
