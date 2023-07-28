package com.urise.webapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organisation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Link homePage;
    private List<Period> period = new ArrayList<>();

    public Organisation() {
    }

    public Organisation(String name, String url, List<Period> period) {
        this.homePage = new Link(name, url);
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisation that = (Organisation) o;
        return homePage.equals(that.homePage) && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, period);
    }

    @Override
    public String toString() {
        StringBuilder periodStr = new StringBuilder();
        for (Period p : period) {
            periodStr.append(p.toString()).append("\n");
        }
        return homePage + "\n" + periodStr;
    }
}
