package com.naijatravelshop.service.email.impl;

import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.service.impl.FlightServiceImpl;
import com.sendgrid.SendGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final static String EMAIL_TEMPLATE_BASE_DIR = "mail/";

    private JavaMailSender mailSender;

    private SendGrid sendGridClient;

    @Autowired
    public void setMailSender(JavaMailSender mailSender)
    {
        this.mailSender = mailSender;
    }

    private TemplateEngine templateEngine;

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendPlainEmail(String to, String subject, String text) {
        String[] recipients = {to};
        sendPlainEmail(recipients, subject, text);
    }

    @Override
    public void sendPlainEmail(String[] recipients, String subject, String text) {
        sendEmail(recipients, subject, text, false, "");
    }

    @Override
    @Async
    public void sendHtmlEmail(String to, String subject, String templateFileName, Map<String, Object> emailVariables, String emailSender) {
        String[] recipients = {to};
        sendHtmlEmail(recipients, subject, templateFileName, emailVariables, emailSender);
    }

    @Override
    public void sendHtmlEmail(String[] recipients, String subject, String templateFileName, Map<String, Object> emailVariables, String emailSender) {
        Context context = new Context();
        emailVariables.forEach(context::setVariable);
        String emailBody = templateEngine.process(EMAIL_TEMPLATE_BASE_DIR + templateFileName, context);
        sendEmail(recipients, subject, emailBody, true, emailSender);
    }

    @Override
    public void sendEmail(String[] recipients, String subject, String content, boolean isHTML, String emailSender) {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(recipients);
            helper.setSubject(subject);
            helper.setFrom(new InternetAddress(emailSender));
            helper.setText(content, isHTML);
            mailSender.send(mailMessage);
            log.info("Email sent>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Email sent>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } catch (MessagingException | MailException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void sendHTMLSendGrid(String from, String to, String subject, String body) {

    }
}
