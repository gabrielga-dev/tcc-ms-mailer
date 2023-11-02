package br.com.events.mailer.adapter.sqs;

import br.com.events.mailer.bussiness.service.email_request.EmailRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailRequestSqsListener {

    private final EmailRequestService emailRequestService;

    @SqsListener("${cloud.aws.endpoint.uri}")
    public void receiveEmailRequestMessage(String message) {
        try {
            log.info("[START] Received email request!: {}", message);

            emailRequestService.sendEmail(message);

            log.info("[END] Email request handled!");
        } catch (Exception ex) {
            log.info("[END] ERROR! Email request not handled! {}", ex.getMessage());
        }
    }
}
