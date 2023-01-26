package br.com.events.mailer.infrastructure.service;

import br.com.events.mailer.domain.message.EmailRequestMessage;

/**
 * This interface dictates every needed method to work with emails
 *
 * @author Gabriel Guimarães de Almeida
 */
public interface EmailService {

    void sendEmail(EmailRequestMessage emailRequestMessage, String jsonBody);
}
