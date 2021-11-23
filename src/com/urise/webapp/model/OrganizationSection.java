package com.urise.webapp.model;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Organization> organizations;

    public OrganizationSection(Organization organizations) {
        this.organizations = List.of(organizations);
    }

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return "* " + organizations + "\n";
    }
}