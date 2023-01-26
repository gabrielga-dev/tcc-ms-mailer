package br.com.events.mailer.application.handler.emailTemplate;

import org.springframework.stereotype.Component;

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
public class TestEmailTemplateHandlerImpl extends EmailTemplateHandler {

    public TestEmailTemplateHandlerImpl(final EmailTemplateRepository repository) {
        super(repository);
    }

    public Long getHandledTemplateId() {
        return 1L;
    }

    @Override
    protected String applyDataToTemplate(final String jsonBody, final EmailTemplate template) {
        return template.getContent();
    }
}
