package br.com.events.mailer.bussiness.factory.email_template_handler.handler;

import br.com.events.mailer.bussiness.use_case.email_template.FindEmailTemplateUseCase;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import br.com.events.mailer.domain.io.email_request.EmailRequestType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailChangedEmailTemplateHandler extends EmailTemplateHandler {

    public EmailChangedEmailTemplateHandler(final FindEmailTemplateUseCase findEmailTemplateUseCase) {
        super(findEmailTemplateUseCase);
    }

    @Override
    public Long getHandledTemplateId() {
        return EmailRequestType.EMAIL_CHANGED.getTemplateId();
    }

    @Override
    protected Map<String, String> generateTemplateParameters(EmailRequestDTO emailRequest) {
        return Map.of(
                "personFirstName", emailRequest.getKeyAndValues().get("personFirstName"),
                "personLastName", emailRequest.getKeyAndValues().get("personLastName")
        );
    }
}
