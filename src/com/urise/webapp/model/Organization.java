package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Experience> experienceArrayList;

    public Organization(String name, String url, Experience... additionalInformationList) {
        this(new Link(name, url), Arrays.asList(additionalInformationList));
    }

    public Organization(Link homePage, List<Experience> experienceArrayList) {
        this.homePage = homePage;
        this.experienceArrayList = experienceArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(experienceArrayList, that.experienceArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, experienceArrayList);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", additionalInformationArrayList=" + experienceArrayList +
                '}';
    }
}