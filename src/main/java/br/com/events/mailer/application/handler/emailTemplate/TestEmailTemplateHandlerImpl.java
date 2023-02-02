package br.com.events.mailer.application.handler.emailTemplate;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.events.mailer.domain.entity.EmailTemplate;
import br.com.events.mailer.domain.repository.EmailTemplateRepository;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * This class handle emails with id equals to 1. Test emails
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
public class TestEmailTemplateHandlerImpl extends EmailTemplateHandler<Void> {

    public TestEmailTemplateHandlerImpl(final EmailTemplateRepository repository) {
        super(repository);
    }

    public Long getHandledTemplateId() {
        return 1L;
    }

    @Override
    public String getSubject(Void data) {
        return "TEST!";
    }

    @Override
    public Void parseData(final String jsonData) throws JsonProcessingException {
        return null;
    }

    @Override
    public Map<String, Object> generateMapValues(final Void values) {
        return null;
    }

    @Override
    protected String applyDataToTemplate(final Void jsonBody, final EmailTemplate template) {
        return template.getContent();
    }
}
