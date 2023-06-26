package com.codurance.dip.Entities.EmailSender;

import com.codurance.dip.Entities.Email.Email;

public class EmailSender implements EmailSenderInterface {

    @Override
    public void send(Email email) {
        System.out.print("To:"+email.getTo()+", Subject: "+email.getSubject()+", Message: "+email.getMessage());
    }

}
