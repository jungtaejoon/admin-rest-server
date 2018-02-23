package com.bookcloudpub.adminrestserver.domain.enumSet;

public enum PaymentType {
    RECEIPT("영수"), CHARGE("청구");
    private String name;
    private final int typeNumber;
    PaymentType(String name) {
        this.name = name;
        this.typeNumber = this.ordinal() + 1;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
