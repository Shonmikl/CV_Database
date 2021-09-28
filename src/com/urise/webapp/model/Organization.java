package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

public class Organization {
     Collection<Period> periods;

     LocalDate startDate;
     LocalDate endDate;

     String title;
     String description;
}
