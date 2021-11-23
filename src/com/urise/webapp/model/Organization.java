package com.urise.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Link homePage;
    private final List<Experience> experiences;

    public Organization(String name, String url, Experience... experiences) {
        this(new Link(name, url), Arrays.asList(experiences));
    }

    public Organization(Link homePage, List<Experience> experiences) {
        this.homePage = homePage;
        this.experiences = experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(experiences, that.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, experiences);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", additionalInformationArrayList=" + experiences +
                '}';
    }

    public static class Experience implements Serializable {
        LocalDate startDate;
        LocalDate endDate;
        String description;
        String title;

        public Experience(LocalDate startDate, LocalDate endDate, String description, String title) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
            this.title = title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Experience that = (Experience) o;
            return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(description, that.description) && Objects.equals(title, that.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, description, title);
        }

        @Override
        public String toString() {
            return "AdditionalInformation==> " +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", description='" + description + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}