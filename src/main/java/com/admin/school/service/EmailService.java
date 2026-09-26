package com.admin.school.service;


public interface EmailService {
    void sendWelcomeEmail(String toEmail, String studentName, String tempPassword, String loginUrl, String schoolName);
}
