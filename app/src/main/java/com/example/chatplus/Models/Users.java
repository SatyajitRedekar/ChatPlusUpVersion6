package com.example.chatplus.Models;

public class Users {

    String userName, userNumber, userDob, userEmail, userPassword, profileEpic, userId, lastMassage;

    public Users(String userName, String userNumber, String userDob, String userEmail, String userPassword, String profileEpic, String userId, String lastMassage) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userDob = userDob;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.profileEpic = profileEpic;
        this.userId = userId;
        this.lastMassage = lastMassage;
    }

    public Users() {
    }

//    login const

    public Users(String userName, String userNumber, String userDob, String userEmail, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userDob = userDob;
        this.userEmail = userEmail;
        this.userPassword = userPassword;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProfileEpic() {
        return profileEpic;
    }

    public void setProfileEpic(String profileEpic) {
        this.profileEpic = profileEpic;
    }


    public String getLastMassage() {
        return lastMassage;
    }

    public void setLastMassage(String lastMassage) {
        this.lastMassage = lastMassage;
    }


}
