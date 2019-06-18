package com.naijatravelshop.persistence.model.enums;

public enum SupplierGroupType {
    AMADEUS("AMADEUS"),
    JACTRAVEL("JACTRAVEL");

    private final String value;

    SupplierGroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
