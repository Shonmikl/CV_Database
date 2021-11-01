package com.urise.webapp.model;

import java.util.Objects;

public class Organization {
     private final Link homePage;

     public Organization(String name, String url, AdditionalInformation... additionalInformation) {
          this.homePage = new Link(name, url);
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Organization that = (Organization) o;
          return Objects.equals(homePage, that.homePage);
     }

     @Override
     public int hashCode() {
          return Objects.hash(homePage);
     }

     @Override
     public String toString() {
          return  "Organization ==> " + homePage;
     }
}