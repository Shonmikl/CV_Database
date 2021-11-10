package com.urise.webapp.model;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return items + "\n";
    }
}
