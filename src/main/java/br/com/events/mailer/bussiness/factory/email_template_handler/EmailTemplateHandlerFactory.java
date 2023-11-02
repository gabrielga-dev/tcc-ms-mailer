package br.com.events.mailer.bussiness.factory.email_template_handler;

import br.com.events.mailer.bussiness.factory.email_template_handler.handler.EmailTemplateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class EmailTemplateHandlerFactory {

    private final Map<Long, EmailTemplateHandler> handlerMap;

    public EmailTemplateHandlerFactory(List<EmailTemplateHandler> handlers) {
        this.handlerMap = handlers.stream()
                .collect(
                        Collectors.toMap(
                                EmailTemplateHandler::getHandledTemplateId,
                                hander -> hander
                        )
                );
    }

    public Optional<EmailTemplateHandler> findHandler(Long wantedTemplateId){
        return Optional.ofNullable(handlerMap.get(wantedTemplateId));
    }
}
