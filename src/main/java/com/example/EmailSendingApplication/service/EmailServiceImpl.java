package com.example.EmailSendingApplication.service;

import com.example.EmailSendingApplication.model.EmailRequest;
import com.example.EmailSendingApplication.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
private JavaMailSender mailSender;

    @Override
    public Boolean send(EmailRequest req) throws MessagingException, UnsupportedEncodingException {
        MimeMessage createMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(createMessage);

        helper.setFrom("arkodipdas007@gmail.com","Email sending app");
        helper.setTo(req.getRecipient());
        helper.setSubject(req.getSubject());
        helper.setText(req.getBody(),true);
        mailSender.send(createMessage);

        return true;

    }


    public void sendEmailAndAttachment(String email, MultipartFile file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        EmailRequest req = mapper.readValue(email, EmailRequest.class);

        MimeMessage createMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(createMessage, true);

        helper.setFrom("arkodipdas007@gmail.com", "Email sending app");
        helper.setTo(req.getRecipient());
        helper.setSubject(req.getSubject());
        helper.setText(req.getBody(), true);

        // Attach file if it's provided
        if (file != null && !file.isEmpty()) {
            helper.addAttachment(file.getOriginalFilename(), new ByteArrayResource(file.getBytes()));
        }

        mailSender.send(createMessage);
    }



}
