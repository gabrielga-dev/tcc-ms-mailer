package br.com.events.mailer.domain.message;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to receive an email changing email request
 *
 * @author Gabriel Guimarães de Almeida
 */
@Getter
@Setter
public class EmailChangeEmailValidationEmailMessage extends EmailRequestMessage {

    private String personFirstName;
    private String personLastName;
    private String emailValidationUuid;
}
