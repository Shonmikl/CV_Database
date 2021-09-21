package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Personality"),
    OBJECTIVE ( "Position"),
    ACHIEVEMENT ( "Achievement"),
    QUALIFICATIONS ( "Qualifications"),
    EXPERIENCE ("Experience"),
    EDUCATION ("Education");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
