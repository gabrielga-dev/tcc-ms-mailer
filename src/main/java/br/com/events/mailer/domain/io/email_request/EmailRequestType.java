package br.com.events.mailer.domain.io.email_request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailRequestType {

    TEST(1L, "Testando"),
    PERSON_CREATION(2L, "Bem vindo ao MyEvents!"),
    EMAIL_CHANGED(5L, "Email alterado com sucesso!"),
    PASSWORD_CHANGE_EMAIL_VALIDATION(3L, "Solicitação de alteração de senha"),
    EMAIL_CHANGE_EMAIL_VALIDATION(4L, "Solicitação de alteração de email");

    private final Long templateId;
    private final String subject;
}
