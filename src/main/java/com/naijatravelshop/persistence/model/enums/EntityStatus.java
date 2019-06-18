package com.naijatravelshop.persistence.model.enums;

public enum EntityStatus {

    ACTIVE("ACTIVE"),
    DELETED("DELETED"),
    INACTIVE("INACTIVE"),
    PENDING("PENDING"),
    DEACTIVATED("DEACTIVATED");

    private final String value;

    private EntityStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

