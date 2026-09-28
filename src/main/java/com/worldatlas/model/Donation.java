package com.worldatlas.model;

public class Donation {

    private final String donorName;
    private final String donorEmail;
    private final String cardNumber;
    private final String cvv;
    private final String expiry;
    private final long amountCents;

    public Donation(String donorName, String donorEmail, String cardNumber, String cvv, String expiry, long amountCents) {
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
        this.amountCents = amountCents;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public long getAmountCents() {
        return amountCents;
    }
}
