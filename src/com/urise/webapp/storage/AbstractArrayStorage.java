package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    public static final int STORAGE_LIMIT = 10;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    public int size;

    protected abstract void moveArray(int index);

    protected abstract void insert(Resume r, int index);

    protected abstract Integer getKey(String uuid);

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateElement(Resume r, Object key) {
        storage[(Integer) key] = r;
    }

    @Override
    protected void saveElement(Resume r, Object key) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Overflow", r.getUuid());
        }
        insert(r, (Integer) key);
        size++;
    }

    @Override
    protected void deleteElement(Object key) {
        moveArray((Integer) key);
        storage[size - 1] = null;
        size--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected boolean isKeyExist(Object key) {
        return (Integer) key >= 0;
    }

    @Override
    protected Resume getElement(Object key) {
        return storage[(Integer) key];
    }
}