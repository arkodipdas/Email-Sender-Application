package com.example.EmailSendingApplication.controller;

import com.example.EmailSendingApplication.model.EmailRequest;
import com.example.EmailSendingApplication.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    private ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest)
    {
        try {
            emailService.send(emailRequest);
            return new ResponseEntity("Email send success", HttpStatus.OK);
        } catch (MessagingException e)
        {
            e.printStackTrace();
            return new ResponseEntity("Email send failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return new ResponseEntity("Email send failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sendattachment")
    public ResponseEntity sendEmailwithAttachment(@RequestParam String email, @RequestParam MultipartFile file)
    {

        try {
            emailService.sendEmailAndAttachment(email,file);
            return new ResponseEntity("Email send success", HttpStatus.OK);
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity("Email send failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
