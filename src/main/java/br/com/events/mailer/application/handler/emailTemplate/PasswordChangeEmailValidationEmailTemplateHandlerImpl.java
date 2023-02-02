package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class PasswordChangeEmailValidationEmailTemplateHandlerImpl
    extends EmailTemplateHandler<PasswordChangeEmailValidationEmailMessage> {

    private final ObjectMapper objectMapper;

    @Value("${password.change.url}")
    private String passwordChangeUrl;

    public PasswordChangeEmailValidationEmailTemplateHandlerImpl(
        final EmailTemplateRepository repository,
        final ObjectMapper objectMapper
    ) {
        super(repository);
        this.objectMapper = objectMapper;
    }

    public Long getHandledTemplateId() {
        return 3L;
    }

    @Override
    public String getSubject(PasswordChangeEmailValidationEmailMessage data) {
        return "Troca de senha no MyEvents!";
    }

    @Override
    public PasswordChangeEmailValidationEmailMessage parseData(final String jsonData) throws JsonProcessingException {
        return objectMapper.readValue(
            jsonData, PasswordChangeEmailValidationEmailMessage.class
        );
    }

    @Override
    public Map<String, Object> generateMapValues(PasswordChangeEmailValidationEmailMessage values) {
        return Map.of(
            "personFirstName", values.getPersonFirstName(),
            "personLastName", values.getPersonLastName(),
            "validationLink", passwordChangeUrl + values.getEmailValidationUuid()
        );
    }
}
