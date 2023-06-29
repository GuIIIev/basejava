package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String jobTitle;
    private final String jobDescription;

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String jobTitle, String jobDescription) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(jobTitle, "jobTitle must not be null");
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && jobTitle.equals(that.jobTitle) && Objects.equals(jobDescription, that.jobDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, jobTitle, jobDescription);
    }
}
