package com.example.EmailSendingApplication.service;

import com.example.EmailSendingApplication.model.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

public interface EmailService {
    public Boolean send(EmailRequest req) throws MessagingException, UnsupportedEncodingException;

    public void sendEmailAndAttachment(String email, MultipartFile file) throws Exception;
}
