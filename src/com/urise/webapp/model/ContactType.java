package com.urise.webapp.model;

public enum ContactType {

    MOBILE("PHONE_NUMBER"),
    MAIL("E-MAIL"),
    FACEBOOK("SOCIAL_NETWORKS"),
    GITHUB ("GIT HUB"),
    SKYPE ("SKYPE"),
    LINKEDIN ("LINKED IN");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}