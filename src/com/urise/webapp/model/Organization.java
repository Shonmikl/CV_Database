package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

public class Organization {
     Collection<Period> periods;

     private LocalDate startDate;
     private LocalDate endDate;

     private String title;
     private String description;
     private String positionName;

     public void setPositionName(String positionName) {
          this.positionName = positionName;
     }

     public Organization(){}

     public Organization(Collection<Period> periods, LocalDate startDate, LocalDate endDate, String title, String description) {
          this.periods = periods;
          this.startDate = startDate;
          this.endDate = endDate;
          this.title = title;
          this.description = description;
     }

     public void setPeriods(Collection<Period> periods) {
          this.periods = periods;
     }

     public void setStartDate(LocalDate startDate) {
          this.startDate = startDate;
     }

     public void setEndDate(LocalDate endDate) {
          this.endDate = endDate;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public void setDescription(String description) {
          this.description = description;
     }
}
