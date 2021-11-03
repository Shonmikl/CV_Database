package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class AdditionalInformation {

    protected final LocalDate startDate;
    protected final LocalDate endDate;

    protected final String description;
    protected final String title;

    public AdditionalInformation(LocalDate startDate, LocalDate endDate, String description, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalInformation that = (AdditionalInformation) o;
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