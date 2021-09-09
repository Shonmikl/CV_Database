package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;

public abstract class AbstractStorage implements Storage {
    protected static final Comparator<Resume> NAME_COMPARATOR = Comparator.comparing(Resume::getFullName);
    protected static final Comparator<Resume> UUID_COMPARATOR = Comparator.comparing(Resume::getUuid);
    protected static final Comparator<Resume> RESUME_COMPARATOR = UUID_COMPARATOR.thenComparing(NAME_COMPARATOR);


    protected abstract Object getKey(String uuid);

    protected abstract void updateElement(Resume r, Object key);

    protected abstract boolean isKeyExist(Object key);

    protected abstract void saveElement(Resume r, Object key);

    protected abstract Resume getElement(Object key);

    protected abstract void deleteElement(Object key);

    public void update(Resume r) {
        Object key = getExistedKey(r.getUuid());
        updateElement(r, key);
    }

    public void save(Resume r) {
        Object key = getNotExistedKey(r.getUuid());
        saveElement(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        deleteElement(key);
    }

    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return getElement(key);
    }

    protected Object getExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (!isKeyExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected Object getNotExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (isKeyExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}