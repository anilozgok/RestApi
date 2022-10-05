package org.bicell.rest.api.entity;

public class Login {
    private String msisdn;
    private String password;


    public Login(String MSISDN, String password) {
        this.msisdn = MSISDN;
        this.password = password;
    }

    public Login() {
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
