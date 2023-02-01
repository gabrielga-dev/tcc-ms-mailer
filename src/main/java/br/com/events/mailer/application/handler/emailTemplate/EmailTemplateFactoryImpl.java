package br.com.events.mailer.application.handler.emailTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.events.mailer.domain.dto.EmailPresentationDTO;
import br.com.events.mailer.domain.message.EmailRequestMessage;
import br.com.events.mailer.infrastructure.exception.EmailTemplateHandlerNotFoundException;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateFactory;
import br.com.events.mailer.infrastructure.handler.emailTemplate.EmailTemplateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * This class implements the selection of which handler will handle the email request.
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
public class EmailTemplateFactoryImpl implements EmailTemplateFactory {

    private final Map<Long, EmailTemplateHandler> handlerMap;

    public EmailTemplateFactoryImpl(List<EmailTemplateHandler> emailTemplateHandlers) {
        this.handlerMap = emailTemplateHandlers.stream().collect(Collectors.toMap(
            EmailTemplateHandler::getHandledTemplateId,
            handler -> handler
        ));
    }

    @Override
    public EmailPresentationDTO findTemplateHandlerAndApplyData(final EmailRequestMessage emailRequestMessage,
        final String jsonBody) {
        var handlerOpt = Optional.ofNullable(
            handlerMap.get(emailRequestMessage.getTemplateId())
        );

        if (handlerOpt.isPresent()) {
            return handlerOpt.get().applyData(jsonBody);
        }

        log.error("Not found handler for email template with id equals to: {}", emailRequestMessage.getTemplateId());
        throw new EmailTemplateHandlerNotFoundException();
    }
}
