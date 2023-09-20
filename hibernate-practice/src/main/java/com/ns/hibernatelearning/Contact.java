package com.ns.hibernatelearning;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;
    @Column
    private int member_id;
    @Column
    private String name;
    @Column
    private String mobile;
    @Column
    private String email;

    public Contact(int contact_id, int member_id, String name, String mobile, String email) {
        this.contact_id = contact_id;
        this.member_id = member_id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public Contact() {

    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" + "contact_id=" + contact_id + ", member_id=" + member_id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + '}';
    }

}
