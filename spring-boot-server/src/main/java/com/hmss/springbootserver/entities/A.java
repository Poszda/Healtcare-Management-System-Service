package com.hmss.springbootserver.entities;

import jakarta.persistence.*;

@Entity

public class A {
    @Id
    private Long id;

    private String address;

    private String phoneNumber;

 //   @OneToOne(mappedBy = "a")
  //  private B b;

    public A() {
    }

    public A(Long id, String address, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
