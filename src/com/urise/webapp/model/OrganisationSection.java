package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganisationSection extends Section {
    private static final long serialVersionUID = 1L;

    private List<Organisation> organizations;

    public OrganisationSection() {
    }

    public OrganisationSection(List<Organisation> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public List<Organisation> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationSection)) return false;
        OrganisationSection that = (OrganisationSection) o;
        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizations);
    }

    @Override
    public String toString() {
        StringBuilder finalStr = new StringBuilder();
        for (Organisation o : organizations) {
            finalStr.append(o.toString()).append("\n");
        }
        return finalStr.toString();
    }
}
