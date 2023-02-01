package br.com.events.mailer.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailPresentationDTO {

    private String processedTemplate;
    private String subject;
}
