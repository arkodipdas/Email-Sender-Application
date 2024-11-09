package com.example.EmailSendingApplication.model;

public class EmailRequest {
    private String title;

    private String subject;

    private String body;

    private String recipient;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getRecipient() {
        return recipient;
    }


    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }


    }







