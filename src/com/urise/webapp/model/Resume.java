package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Map;

public class Resume implements Comparable<Resume> {
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    // Unique identifier
    private String uuid;
    private final String fullName;

    public void setContacts(Map<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public void setSections(Map<SectionType, Section> sections) {
        this.sections = sections;
    }

    public String getContacts(ContactType contactType) {
        return contacts.get(contactType);
    }

    public Section getSections(SectionType sectionType) {
        return sections.get(sectionType);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(Map<ContactType, String> contacts, Map<SectionType, Section> sections, String uuid, String fullName) {
        this.contacts = contacts;
        this.sections = sections;
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        int compareResult = fullName.compareTo(o.fullName);
        return compareResult != 0 ? compareResult : uuid.compareTo(o.uuid);
    }
}