package br.com.events.mailer.bussiness.service.email_request;

import br.com.events.mailer.bussiness.factory.email_template_handler.EmailTemplateHandlerFactory;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailRequestServiceImpl implements EmailRequestService {

    @Getter
    private final Gson gson;
    private final EmailTemplateHandlerFactory emailTemplateHandlerFactory;

    @Override
    public void sendEmail(EmailRequestDTO emailRequest) {
        log.info("[START] EmailRequestServiceImpl: finding email template handler");
        var templateHandler = emailTemplateHandlerFactory.findHandler(emailRequest.getType().getTemplateId()).orElseThrow();

        log.info("[...] EmailRequestServiceImpl: email template handler found!");

        var email = templateHandler.generateEmail(emailRequest);

        log.info("[...] EmailRequestServiceImpl: email generated: {}", email);
    }
}
