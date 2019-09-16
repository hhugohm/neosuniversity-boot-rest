package com.neos.university.neosuniversitybootrest.domain;

public class Information {

    private String message;

    public Information(){}

    public Information(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
