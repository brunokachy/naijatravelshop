package com.naijatravelshop.persistence.model.enums;

public enum RoleType {
    PORTAL_USER("PORTAL USER"),
    ADMINISTRATOR("ADMINISTRATOR"),
    FINANCE_OFFICER("FINANCE OFFICER"),
    VISA_DEPARTMENT("VISA DEPARTMENT"),
    SUPER_ADMIN("SUPER ADMIN"),
    PRICING_OFFICER("PRICING OFFICER"),
    TRAVEL_CONSULTANT_SUPERVISOR("TRAVEL CONSULTANT SUPERVISOR"),
    ONLINE_REQUEST_TRAVEL_CONSULTANT("ONLINE REQUEST TRAVEL CONSULTANT"),
    CUSTOMER_SUPPORT("CUSTOMER SUPPORT"),
    TICKETING_OFFICER ("TICKETING OFFICER");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
