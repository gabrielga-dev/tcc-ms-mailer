package br.com.events.mailer.bussiness.factory.email_template_handler.handler;

import br.com.events.mailer.bussiness.use_case.email_template.FindEmailTemplateUseCase;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import br.com.events.mailer.domain.io.email_request.EmailRequestType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BandQuoteRequestDeletedTemplateHandler extends EmailTemplateHandler {

    @Value("${band.quote.requests.url}")
    private String bandQuoteRequestsLink;

    public BandQuoteRequestDeletedTemplateHandler(final FindEmailTemplateUseCase findEmailTemplateUseCase) {
        super(findEmailTemplateUseCase);
    }

    @Override
    public Long getHandledTemplateId() {
        return EmailRequestType.BAND_QUOTE_REQUEST_DELETED.getTemplateId();
    }

    @Override
    protected Map<String, String> generateTemplateParameters(EmailRequestDTO emailRequest) {
        var values = emailRequest.getKeyAndValues();

        var bandQuoteRequestsLinkWithUuid = String.format(bandQuoteRequestsLink, values.get("bandUuid"));
        values.remove("bandUuid");

        values.put("quoteRequestsSiteLink", bandQuoteRequestsLinkWithUuid);
        return values;
    }
}
