package com.admin.school.service.imlementation;

import com.admin.school.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class EmailServiceImp implements EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    @SneakyThrows
    public void sendWelcomeEmail(String toEmail, String studentName, String tempPassword, String loginUrl, String schoolName) {
        Context context = new Context();

        // These variables now exactly match the ${...} tags in your HTML template
        context.setVariable("schoolName", schoolName);
        context.setVariable("studentName", studentName);
        context.setVariable("email", toEmail);
        context.setVariable("tempPassword", tempPassword);
        context.setVariable("loginUrl", loginUrl);

        String htmlContent = templateEngine.process("welcome", context);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("your-email@gmail.com"); // Khasso ikon b7al li f application.yml
        helper.setTo(toEmail);
        helper.setSubject("Mrehba bik m3ana! Welcome to " + schoolName);
        helper.setText(htmlContent, true); // true = had string rah HTML

        // 4. Sift zmlboh
        mailSender.send(message);
    }
}
