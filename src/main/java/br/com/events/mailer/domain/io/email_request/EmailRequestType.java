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
    EMAIL_CHANGE_EMAIL_VALIDATION(4L, "Solicitação de alteração de email"),
    NEW_BAND_QUOTE_REQUEST(6L, "Criação de um novo pedido de orçamento para uma banda"),
    BAND_QUOTE_REQUEST_DELETED(7L, "Pedido de orçamento para banda deletado!"),
    QUOTE_REQUEST_DECLINED(8L, "Pedido de orçamento negado!");

    private final Long templateId;
    private final String subject;
}
