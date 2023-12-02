package br.com.events.mailer.bussiness.factory.email_template_handler.handler;

import br.com.events.mailer.bussiness.use_case.email_template.FindEmailTemplateUseCase;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import br.com.events.mailer.domain.io.email_request.EmailRequestType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PasswordChangeRequestEmailTemplateHandler extends EmailTemplateHandler {


    @Value("${password.change.url}")
    private String passwordChangeUrl;

    public PasswordChangeRequestEmailTemplateHandler(final FindEmailTemplateUseCase findEmailTemplateUseCase) {
        super(findEmailTemplateUseCase);
    }

    @Override
    public Long getHandledTemplateId() {
        return EmailRequestType.PASSWORD_CHANGE_EMAIL_VALIDATION.getTemplateId();
    }

    @Override
    protected Map<String, String> generateTemplateParameters(EmailRequestDTO emailRequest) {
        var validationLink = passwordChangeUrl + emailRequest.getEmailValidationUuid();
        return Map.of(
                "personFirstName", emailRequest.getKeyAndValues().get("personFirstName"),
                "personLastName", emailRequest.getKeyAndValues().get("personLastName"),
                "validationLink", validationLink
        );
    }
}
