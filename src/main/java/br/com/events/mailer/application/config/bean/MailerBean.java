package br.com.events.mailer.application.config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * Configuration to generate a Bean of JavaMailSender to be used to send emails
 *
 * @author Gabriel Guimarães de Almeida
 */
@Configuration
public class MailerBean {

    @Value("${mail.username}")
    private String mailUsername;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.host}")
    private String mailHost;

    @Value("${mail.port}")
    private Integer mailPort;

    @Bean
    public JavaMailSender getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);

        mailSender.setUsername(mailUsername);
        mailSender.setPassword(password);

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
