package com.csw.zwitsal;

/**
 * Created by MajidRazmjoo on 7/19/14.
 */
public class Registrant {
    private String name;
    private String dob;
    private String sex;
    private String motherName;
    private String email;
    private String phone;
    private String address;


    public Registrant(String name, String dob, String sex, String motherName, String email, String phone, String address) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.motherName = motherName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
