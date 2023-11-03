package br.com.events.mailer.bussiness.factory.email_template_handler.handler;

import br.com.events.mailer.bussiness.config.resolver.StaticTemplateExecutor;
import br.com.events.mailer.bussiness.use_case.email_template.FindEmailTemplateUseCase;
import br.com.events.mailer.domain.io.email.EmailDTO;
import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.thymeleaf.context.Context;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;

import java.util.Map;


@RequiredArgsConstructor
public abstract class EmailTemplateHandler {

    @Value("${mail.username}")
    private String mailUsername;

    protected final FindEmailTemplateUseCase findEmailTemplateUseCase;

    abstract public Long getHandledTemplateId();

    abstract protected Map<String, String> generateTemplateParameters(EmailRequestDTO emailRequest);

    public EmailDTO generateEmail(EmailRequestDTO emailRequest) {
        var template = findEmailTemplateUseCase.byId(this.getHandledTemplateId()).orElseThrow();

        var params = this.generateTemplateParameters(emailRequest);
        var context = new Context();
        params.forEach(context::setVariable);

        var messageResolver = new StandardMessageResolver();
        var executor = new StaticTemplateExecutor(
                context, messageResolver, StandardTemplateModeHandlers.HTML5.getTemplateModeName()
        );

        var emailContent = executor.processTemplateCode(template.getContent());

        return new EmailDTO(
                mailUsername,
                emailRequest.getReceiverEmail(),
                emailRequest.getSubject(),
                emailContent
        );
    }
}
