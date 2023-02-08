package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.events.mailer.domain.message.EmailChangedEmailMessage;
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
public class EmailChangedEmailTemplateHandlerImpl
    extends EmailTemplateHandler<EmailChangedEmailMessage> {

    private final ObjectMapper objectMapper;

    @Value("${password.change.url}")
    private String passwordChangeUrl;

    public EmailChangedEmailTemplateHandlerImpl(
        final EmailTemplateRepository repository,
        final ObjectMapper objectMapper
    ) {
        super(repository);
        this.objectMapper = objectMapper;
    }

    public Long getHandledTemplateId() {
        return 5L;
    }

    @Override
    public String getSubject(EmailChangedEmailMessage data) {
        return "Troca de email no MyEvents foi um sucesso!";
    }

    @Override
    public EmailChangedEmailMessage parseData(final String jsonData) throws JsonProcessingException {
        return objectMapper.readValue(
            jsonData, EmailChangedEmailMessage.class
        );
    }

    @Override
    public Map<String, Object> generateMapValues(EmailChangedEmailMessage values) {
        return Map.of(
            "personFirstName", values.getPersonFirstName(),
            "personLastName", values.getPersonLastName()
        );
    }
}
