package com.urise.webapp.model;

public enum ContactType {

    PHONE_NUMBER("PHONE_NUMBER"),
    MAIL("E-MAIL"),
    SOCIAL_NETWORKS("SOCIAL_NETWORKS"),
    ;

    String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
