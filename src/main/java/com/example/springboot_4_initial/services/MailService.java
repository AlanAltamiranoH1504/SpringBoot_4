package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.services.interfaces.IMailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService implements IMailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${url.front}")
    String url_front;

    @Override
    public void send_mail_confirm_account_reclutador(String to, String subject, String name_user, String url, int randome_number) {
        Context context = new Context();
        context.setVariable("user_name", name_user);
        context.setVariable("url", (url_front + "/" + url));
        context.setVariable("randome_number", randome_number);

        String html_content = templateEngine.process("confirm_account_reclutador", context);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html_content, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
