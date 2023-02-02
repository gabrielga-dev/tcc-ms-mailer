package br.com.events.mailer.domain.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordChangeEmailValidationEmailMessage extends EmailRequestMessage {

    private String personFirstName;
    private String personLastName;
    private String emailValidationUuid;
}
