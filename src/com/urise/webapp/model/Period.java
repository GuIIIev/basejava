package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String jobTitle;
    private final String jobDescription;

    public Period(LocalDate startDate, LocalDate endDate, String jobTitle, String jobDescription) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return startDate.equals(period.startDate) && endDate.equals(period.endDate) && jobTitle.equals(period.jobTitle) && Objects.equals(jobDescription, period.jobDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, jobTitle, jobDescription);
    }

    @Override
    public String toString() {
        return "Period{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}
