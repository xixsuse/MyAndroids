package com.j.intent;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/6/28.
 */
public class Person implements Serializable {
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
