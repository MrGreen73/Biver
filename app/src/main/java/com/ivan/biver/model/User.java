package com.ivan.biver.model;

public class User {

    public String mName;
    public String mPhone;
    public String mCard;
    public String mAdress;

    public User(){}

    public User(String mName, String mPhone, String mCard, String mAdress) {

        this.mName = mName;
        this.mPhone = mPhone;
        this.mCard = mCard;
        this.mAdress = mAdress;

    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setCard(String mCard) {
        this.mCard = mCard;
    }

    public String getCard() {
        return mCard;
    }

    public void setAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public String getAdress() {
        return mAdress;
    }
}
