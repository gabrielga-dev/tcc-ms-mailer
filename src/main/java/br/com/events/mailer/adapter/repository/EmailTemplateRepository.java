package br.com.events.mailer.adapter.repository;

import br.com.events.mailer.domain.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface make every needed operation to the {@link EmailTemplate}'s table
 *
 * @author Gabriel Guimarães de Almeida
 */
@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {

}
