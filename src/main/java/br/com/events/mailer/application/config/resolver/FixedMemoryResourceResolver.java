package br.com.events.mailer.application.config.resolver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.util.Validate;

/**
 * This resolver is needed to manage the thymeleaf fixed memory
 *
 * @author Gabriel Guimarães de Almeida
 */
public class FixedMemoryResourceResolver implements IResourceResolver {

    private static final String NAME = "FixedMemoryResourceResolver";

    private final String templateContent;

    public FixedMemoryResourceResolver(final String templateContent) {
        Validate.notNull(templateContent, "Template content must be non-null");
        this.templateContent = templateContent;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public InputStream getResourceAsStream(final TemplateProcessingParameters tpp, final String templateName) {
        return new ByteArrayInputStream(templateContent.getBytes());
    }

}
