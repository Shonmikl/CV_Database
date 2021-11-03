package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    List<AdditionalInformation> additionalInformationArrayList = new ArrayList<>();

    public Organization(String name, String url, AdditionalInformation... additionalInformationList) {
        this(new Link(name, url), Arrays.asList(additionalInformationList));
    }

    public Organization(Link homePage, List<AdditionalInformation> additionalInformationArrayList) {
        this.homePage = homePage;
        this.additionalInformationArrayList = additionalInformationArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(additionalInformationArrayList, that.additionalInformationArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, additionalInformationArrayList);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", additionalInformationArrayList=" + additionalInformationArrayList +
                '}';
    }
}