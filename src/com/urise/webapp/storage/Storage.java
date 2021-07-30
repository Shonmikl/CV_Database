package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}