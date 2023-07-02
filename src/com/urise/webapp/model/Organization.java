package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Period> period = new ArrayList<>();

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String jobTitle, String jobDescription) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(jobTitle, "jobTitle must not be null");
        this.homePage = new Link(name, url);
        period.add(new Period(startDate, endDate, jobTitle, jobDescription));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, period);
    }

    @Override
    public String toString() {
        return homePage + " " + period;
    }
}
