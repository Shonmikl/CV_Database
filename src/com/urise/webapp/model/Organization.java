package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {

     private final Link homePage;

     protected final LocalDate startDate;
     protected final LocalDate endDate;
     private final String description;
     private final String title;

     public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
          this.homePage = new Link(name, url);
          this.startDate = startDate;
          this.endDate = endDate;
          this.title = title;
          this.description = description;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Organization that = (Organization) o;
          return homePage.equals(that.homePage) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && description.equals(that.description) && title.equals(that.title);
     }

     @Override
     public int hashCode() {
          return Objects.hash(homePage, startDate, endDate, description, title);
     }

     @Override
     public String toString() {
          return "Organization:\n" +
                  "homePage--->  " + homePage + "\n" +
                  "startDate--->  " + startDate + "\n" +
                  "endDate--->  " + endDate + "\n" +
                  "description--->  " + description + "\n" +
                  "title--->  " + title + "\n" ;
     }
}

