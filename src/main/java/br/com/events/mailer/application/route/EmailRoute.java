package br.com.events.mailer.application.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.events.mailer.application.processor.EmailProcessor;
import lombok.RequiredArgsConstructor;

/**
 * This class will process every email message that comes through kafka
 *
 * @author Gabriel Guimarães de Almeida
 */
@Component
@RequiredArgsConstructor
public class EmailRoute extends RouteBuilder {

    @Value("${kafka.email.endpoint}")
    private String kafkaEmailTopicEndpoint;

    private final EmailProcessor emailProcessor;

    @Override
    public void configure() {
        from(kafkaEmailTopicEndpoint)
            .process(emailProcessor)
            .end();
    }
}
