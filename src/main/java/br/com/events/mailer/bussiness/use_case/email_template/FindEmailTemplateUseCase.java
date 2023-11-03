package br.com.events.mailer.bussiness.use_case.email_template;

import br.com.events.mailer.domain.entity.EmailTemplate;
import br.com.events.mailer.adapter.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindEmailTemplateUseCase {

    private final EmailTemplateRepository emailTemplateRepository;

    public Optional<EmailTemplate> byId(Long wantedId) {
        return emailTemplateRepository.findById(wantedId);
    }
}
