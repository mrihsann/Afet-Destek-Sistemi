package com.boyslab.ads.dtos.response.request;

import lombok.*;


public class RequestDetailDto {
public  RequestDetailDto(){

}

    public RequestDetailDto(String name, String surname, String phoneNumber, String categoryName, String categoryDescription) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    private String name;
    private String surname;
    private String phoneNumber;
    private String categoryName;
    private String categoryDescription;

}
