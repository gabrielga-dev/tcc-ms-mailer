package br.com.events.mailer.application.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.events.mailer.domain.message.EmailRequestMessage;
import br.com.events.mailer.infrastructure.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class holds the process method for every message from email topic
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailProcessor implements Processor {

    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    @Override
    public void process(final Exchange exchange) {
        log.info("Email message received: {}", exchange.getMessage().getBody());
        try {
            var jsonBody = (String) exchange.getMessage().getBody();

            var emailRequestMessage = objectMapper.readValue(
                jsonBody, EmailRequestMessage.class
            );

            emailService.sendEmail(emailRequestMessage, jsonBody);
        } catch (JsonProcessingException e) {
            log.error("Can't parse the object into json: {}", exchange.getMessage().getBody());
        }
    }
}
