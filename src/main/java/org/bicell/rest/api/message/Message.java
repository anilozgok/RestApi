package org.bicell.rest.api.message;

public interface Message {

    void sendMessage(String toEmail, String subject, String body);
}
