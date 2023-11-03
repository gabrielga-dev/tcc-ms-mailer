package br.com.events.mailer.bussiness.use_case.email;

import br.com.events.mailer.domain.io.email.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendEmailUseCase {

    private final JavaMailSender mailSender;

    public void execute(EmailDTO emailDTO) {
        log.info("[START] SendEmailUseCase: Trying to send email");
        try {
            var emailToSend = this.toEmailMessage(emailDTO);
            mailSender.send(emailToSend);
            log.info("[END] SUCCESS - SendEmailUseCase: Email sent with success!");
        } catch (MessagingException e) {
            log.info("[END] ERROR - SendEmailUseCase: Email not sent: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public MimeMessage toEmailMessage(EmailDTO emailDTO) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        helper.setTo(emailDTO.getTo());
        helper.setSubject(emailDTO.getSubject());
        helper.setText(emailDTO.getContent(), true);

        return mimeMessage;
    }
}
