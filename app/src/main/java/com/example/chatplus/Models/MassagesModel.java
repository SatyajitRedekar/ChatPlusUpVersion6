package com.example.chatplus.Models;

public class MassagesModel {

    String uId, massage;
    Long timestamp;

    public MassagesModel(String massage, Long timestamp, String uId) {
        this.massage = massage;
        this.timestamp = timestamp;
        this.uId = uId;
    }

    public MassagesModel(String uId, String massage) {
        this.uId = uId;
        this.massage = massage;
    }

    public MassagesModel() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
