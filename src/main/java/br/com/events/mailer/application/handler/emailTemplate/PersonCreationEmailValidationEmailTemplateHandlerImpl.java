package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.events.mailer.domain.message.PersonCreationEmailValidationEmailMessage;
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
    public String getSubject(PersonCreationEmailValidationEmailMessage data) {
        return "Bem-vindo(a) ao MyEvents!";
    }

    @Override
    public PersonCreationEmailValidationEmailMessage parseData(final String jsonData) throws JsonProcessingException {
        return objectMapper.readValue(
            jsonData, PersonCreationEmailValidationEmailMessage.class
        );
    }

    @Override
    public Map<String, Object> generateMapValues(PersonCreationEmailValidationEmailMessage values) {
        return Map.of(
            "personFirstName", values.getPersonFirstName(),
            "personLastName", values.getPersonLastName(),
            "validationLink", emailValidationUrl + values.getEmailValidationUuid()
        );
    }
}
