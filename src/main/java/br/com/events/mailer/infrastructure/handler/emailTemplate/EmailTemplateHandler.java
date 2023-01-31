package br.com.events.mailer.infrastructure.handler.emailTemplate;

import java.util.Map;

import br.com.events.mailer.domain.entity.EmailTemplate;
import br.com.events.mailer.domain.repository.EmailTemplateRepository;
import br.com.events.mailer.infrastructure.exception.EmailTemplateNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This abstract class will be implemented by classes those put the needed data to the specific email template
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@RequiredArgsConstructor
public abstract class EmailTemplateHandler <T> {

    protected final EmailTemplateRepository repository;

    public abstract Long getHandledTemplateId();

    public abstract Map<String, Object> generateMapValues(T values);

    abstract protected String applyDataToTemplate(String jsonBody, EmailTemplate template);

    public String applyData(String jsonBody) {
        var templateOpt = repository.findById(getHandledTemplateId());

        if (templateOpt.isPresent()) {
            return applyDataToTemplate(jsonBody, templateOpt.get());
        }
        log.error("Not found email template with id: {}", getHandledTemplateId());
        throw new EmailTemplateNotFoundException();
    }
}
