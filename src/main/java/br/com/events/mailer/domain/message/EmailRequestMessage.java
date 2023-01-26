package br.com.events.mailer.domain.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class holds every needed information that comes from kafka queue
 *
 * @author Gabriel Guimarães de Almeida
 */
@Getter
@Setter
@Builder
public class EmailRequestMessage {

    private String to;
    private Long templateId;
}
