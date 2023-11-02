package br.com.events.mailer.domain.io.email;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class EmailDTO {

    private final String to;
    private final String subject;
    private final String content;
}
