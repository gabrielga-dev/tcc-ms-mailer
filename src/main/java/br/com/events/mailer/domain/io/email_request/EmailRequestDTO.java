package br.com.events.mailer.domain.io.email_request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class EmailRequestDTO implements Serializable {

    private final EmailRequestType type;
    private final Map<String, String> keyAndValues;

    public String toString(){
        var strBuilder = new StringBuilder("EmailRequestDTO(");

        strBuilder.append("type=").append(type.name());

        var stringKeysAndValues = keyAndValues.entrySet().stream().map(
                entry -> entry.getKey() + "=>" + entry.getValue()
        ).collect(Collectors.joining(", "));

        strBuilder.append("keyAndValues=[")
                .append(stringKeysAndValues)
                .append("]");

        return strBuilder.append(")").toString();
    }

    public String getReceiverEmail(){
        return keyAndValues.get("email");
    }

    public String getSubject(){
        return type.getSubject();
    }
}
