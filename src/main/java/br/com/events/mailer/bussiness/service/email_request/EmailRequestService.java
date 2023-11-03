package br.com.events.mailer.bussiness.service.email_request;

import br.com.events.mailer.domain.io.email_request.EmailRequestDTO;
import com.google.gson.Gson;

public interface EmailRequestService {

    void sendEmail(EmailRequestDTO message);

    Gson getGson();

    default void sendEmail(String messageJson) {
        var message = getGson().fromJson(messageJson, EmailRequestDTO.class);
        this.sendEmail(message);
    }
}
