package br.com.events.mailer.infrastructure.handler.emailTemplate;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.events.mailer.domain.dto.EmailPresentationDTO;
import br.com.events.mailer.domain.entity.EmailTemplate;
import br.com.events.mailer.domain.repository.EmailTemplateRepository;
import br.com.events.mailer.infrastructure.exception.EmailTemplateNotFoundException;
import br.com.events.mailer.infrastructure.exception.ErrorAtParsingJsonBodyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This abstract class will be implemented by classes those put the needed data to the specific email template
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@RequiredArgsConstructor
public abstract class EmailTemplateHandler<T> {

    protected final EmailTemplateRepository repository;

    /**
     * This method will return the template id that the handler handle
     *
     * @return {@link Long} email template's id
     */
    public abstract Long getHandledTemplateId();

    /**
     * This method will parse the incoming {@link String} json data into a {@link T} object
     *
     * @param jsonData {@link String} needed data to build the email and that will be parsed to {@link T} object
     * @return {@link T} object with the mapped data
     */
    public abstract T parseData(String jsonData) throws JsonProcessingException;

    /**
     * This method will return email's subject
     *
     * @return {@link String} email's subject
     */
    public abstract String getSubject(T data);

    /**
     * This method generate a {@link Map}<{@link String}, {@link Object}> that contains all thymeleaf variables and its
     * values
     *
     * @param values {@link T} object that contains the needed and parsed data
     * @return {@link Map}<{@link String}, {@link Object}> that contains all thymeleaf variables and its values
     */
    public abstract Map<String, Object> generateMapValues(T values);

    /**
     * This method will apply all variables to the email template
     *
     * @param data {@link T} object that contains the needed and parsed data
     * @param template {@link EmailTemplate} email template
     * @return {@link String} string that contains the populated email template
     */
    abstract protected String applyDataToTemplate(T data, EmailTemplate template);

    /**
     * This method builds the needed {@link EmailPresentationDTO} object to send an email
     *
     * @param jsonBody {@link String} json body that contains all needed data to the email
     * @return {@link EmailPresentationDTO} object that contains all processed data to send an email
     */
    public EmailPresentationDTO applyData(String jsonBody) {
        var templateOpt = repository.findById(getHandledTemplateId());
        if (templateOpt.isEmpty()) {
            log.error("Not found email template with id: {}", getHandledTemplateId());
            throw new EmailTemplateNotFoundException();
        }
        var template = templateOpt.get();

        try {
            var parsedData = parseData(jsonBody);
            return EmailPresentationDTO
                .builder()
                .processedTemplate(applyDataToTemplate(parsedData, template))
                .subject(getSubject(parsedData))
                .build();

        } catch (Exception ex) {
            log.error(
                "Error trying to parse the following body to {}: {}",
                template.getName(),
                jsonBody
            );
            throw new ErrorAtParsingJsonBodyException();
        }
    }
}
