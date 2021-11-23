package com.urise.webapp.model;

public enum SectionType {

    PERSONAL("Personality"),
    OBJECTIVE("Position"),
    ACHIEVEMENT("Achievement"),
    QUALIFICATIONS("Qualifications"),
    EXPERIENCE("Experience"),
    EDUCATION("Education");

    private final String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}