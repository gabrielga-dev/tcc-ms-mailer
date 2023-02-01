package br.com.events.mailer.infrastructure.service;

import br.com.events.mailer.domain.message.EmailRequestMessage;

/**
 * This interface dictates every needed method to work with emails
 *
 * @author Gabriel Guimarães de Almeida
 */
public interface EmailService {

    /**
     * This method receives an email which template the email will have and to who it will be and the data that need to
     * be on it, and then it process and populate the template and send the email
     *
     * @param emailRequestMessage {@link EmailRequestMessage} kafka message data that contains the template's id and to
     * whom the email will be going
     * @param jsonBody {@link String} string that contains the data to populate the email
     */
    void sendEmail(EmailRequestMessage emailRequestMessage, String jsonBody);
}
