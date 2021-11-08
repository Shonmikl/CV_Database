package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Experience> list_of_experience;

    public Organization(String name, String url, Experience... list_of_experience) {
        this(new Link(name, url), Arrays.asList(list_of_experience));
    }

    public Organization(Link homePage, List<Experience> list_of_experience) {
        this.homePage = homePage;
        this.list_of_experience = list_of_experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(list_of_experience, that.list_of_experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, list_of_experience);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", additionalInformationArrayList=" + list_of_experience +
                '}';
    }
}