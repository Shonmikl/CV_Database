package com.urise.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Link homePage;
    private final List<Experience> experienceList;

    public Organization(String name, String url, Experience... experienceList) {
        this(new Link(name, url), Arrays.asList(experienceList));
    }

    public Organization(Link homePage, List<Experience> experienceList) {
        this.homePage = homePage;
        this.experienceList = experienceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(experienceList, that.experienceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, experienceList);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", additionalInformationArrayList=" + experienceList +
                '}';
    }
}