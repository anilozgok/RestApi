package org.bicell.rest.api.entity;

import java.sql.Date;

public class Subscriber {
    private int subsc_id;
    private String msisdn;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date sdate;
    private Boolean status;

    public Subscriber() {
    }

    public Subscriber(String msisdn, String name, String surname, String email, String password, Date sdate, Boolean status) {
        this.msisdn = msisdn;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.sdate = sdate;
        this.status = status;
    }

    public int getSubsc_id() {
        return subsc_id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
