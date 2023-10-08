package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends Section {
    private static final long serialVersionUID = 1L;

    private List<Organisation> organisations;

    public OrganisationSection() {
    }

    public OrganisationSection(Organisation... organisations) {
        this(Arrays.asList(organisations));
    }

    public OrganisationSection(List<Organisation> organisations) {
        Objects.requireNonNull(organisations, "organisations must not be null");
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationSection that)) return false;
        return organisations.equals(that.organisations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisations);
    }

    @Override
    public String toString() {
        StringBuilder finalStr = new StringBuilder();
        for (Organisation o : organisations) {
            finalStr.append(o.toString()).append("\n");
        }
        return finalStr.toString();
    }
}
