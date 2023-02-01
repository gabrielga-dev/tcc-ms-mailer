package br.com.events.mailer.infrastructure.handler.emailTemplate;

import br.com.events.mailer.domain.dto.EmailPresentationDTO;
import br.com.events.mailer.domain.message.EmailRequestMessage;

/**
 * This interface dictates which methods are needed to find a template and apply data to then
 *
 * @author Gabriel Guimarães de Almeida
 */
public interface EmailTemplateFactory {

    EmailPresentationDTO findTemplateHandlerAndApplyData(EmailRequestMessage emailRequestMessage, String jsonBody);
}
