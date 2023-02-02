package br.com.events.mailer.application.service;

import org.springframework.stereotype.Service;

import br.com.events.mailer.domain.message.EmailRequestMessage;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateFactory;
import br.com.events.mailer.infrastructure.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class holds the implementation of every method from {@link EmailService}
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailTemplateFactory emailTemplateFactory;

    @Override
    public void sendEmail(EmailRequestMessage emailRequestMessage, String jsonBody) {
        var emailContent = emailTemplateFactory.findTemplateHandlerAndApplyData(emailRequestMessage, jsonBody);

        log.warn(emailContent.getProcessedTemplate());
    }
}
