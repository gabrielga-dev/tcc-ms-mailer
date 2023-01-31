package br.com.events.mailer.application.config.resolver;

import org.thymeleaf.context.IContext;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.util.Validate;

/**
 * This executor is needed to execute the data to a given template
 *
 * @author Gabriel Guimarães de Almeida
 */
public class StaticTemplateExecutor {

    private static final String TEMPLATE_NAME = "custom";

    private final String templateMode;

    private final IContext context;

    private final IMessageResolver messageResolver;

    public StaticTemplateExecutor(final IContext context, final IMessageResolver messageResolver, final String templateMode) {
        Validate.notNull(context, "Context must be non-null");
        Validate.notNull(templateMode, "Template mode must be non-null");
        Validate.notNull(messageResolver, "MessageResolver must be non-null");
        this.context = context;
        this.templateMode = templateMode;
        this.messageResolver = messageResolver;
    }

    public String processTemplateCode(final String code) {
        Validate.notNull(code, "Code must be non-null");
        var templateResolver = new MemoryTemplateResolver(code, templateMode);
        var templateEngine = new SpringTemplateEngine();
        templateEngine.setMessageResolver(messageResolver);
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.initialize();
        return templateEngine.process(TEMPLATE_NAME, context);
    }
}
