package br.com.events.mailer.bussiness.factory.email_template_handler.handler;

import br.com.events.mailer.bussiness.use_case.email_template.FindEmailTemplateUseCase;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import br.com.events.mailer.domain.io.email_request.EmailRequestType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class QuoteRequestAnsweredTemplateHandler extends EmailTemplateHandler {

    public QuoteRequestAnsweredTemplateHandler(final FindEmailTemplateUseCase findEmailTemplateUseCase) {
        super(findEmailTemplateUseCase);
    }

    @Override
    public Long getHandledTemplateId() {
        return EmailRequestType.QUOTE_REQUEST_ANSWERED.getTemplateId();
    }

    @Override
    protected Map<String, String> generateTemplateParameters(EmailRequestDTO emailRequest) {
        var businessTypeName = emailRequest.getKeyAndValues().get("businessTypeName");
        businessTypeName = businessTypeName.toLowerCase();

        emailRequest.getKeyAndValues().remove("businessTypeName");
        emailRequest.getKeyAndValues().put("businessTypeName", businessTypeName);

        Optional.ofNullable(emailRequest.getKeyAndValues().get("observation"))
                .ifPresent(
                        observation -> {
                            emailRequest.getKeyAndValues().remove("observation");
                            emailRequest.getKeyAndValues().put("observation", "Obs.: " + observation);
                        }
                );
        return emailRequest.getKeyAndValues();
    }
}
