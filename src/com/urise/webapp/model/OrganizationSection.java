package com.urise.webapp.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {

    private static final long serialVersionUID = 1L;
    private final List<Organization> organizations;

    public OrganizationSection(Organization organizations) {
        this.organizations = Collections.singletonList(organizations);
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