package com.bookcloudpub.adminrestserver.domain.enumSet;

public enum PaymentType {
    RECEIPT("영수", 1), CHARGE("청구", 2);
    private String name;
    private int typeNumber;
    PaymentType(String name, int typeNumber) {
        this.name = name;
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
