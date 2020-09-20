package com.example.ecom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.example.ecom.config.Constant.User.*;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@Entity
@Table(name = TABLE)
public class User {

    @Id
    @Column(name = LOGIN_NAME)
    private String loginName;

    @Column(name = EMAIL)
    private String email;

    @Column(name = CONTACT_NUMBER)
    private String contactNumber;

    @Column(name = NAME)
    private String name;

    @Column(name = ADDRESS)
    private String address;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
