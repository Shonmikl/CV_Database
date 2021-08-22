package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void updateElement(Resume r, Object key);

    protected abstract void saveElement(Resume r, Object key);

    protected abstract boolean isKeyExist(Object key);

    protected abstract Object getKey(String uuid);

    protected abstract void deleteElement(Object key);

    protected abstract void insert(Resume r, int index);

    protected abstract Resume getElement(Object key);

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

    protected abstract void moveArray(int index);
}