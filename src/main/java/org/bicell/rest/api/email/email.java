package org.bicell.rest.api.email;

public class email implements Message{

    @Override
    public void sendMessage() {
        sendEmail();
    }

    public void sendEmail(){
        //logic
    }
}
