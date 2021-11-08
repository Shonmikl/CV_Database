package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public record Experience(LocalDate startDate, LocalDate endDate, String description,
                         String title) {

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