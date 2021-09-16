package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

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
    protected void updateResume(Resume r, Object key) {
        storage[(int) key] = r;
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        if (size >= STORAGE_LIMIT ) {
            throw new StorageException("Overflow", r.getUuid());
        }
        insert(r, ((int) key));
        size++;
    }

    @Override
    protected void deleteResume(Object key) {
        moveArray((int) key);
        storage[size - 1] = null;
        size--;
    }

    public List<Resume> sort() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected boolean isKeyExist(Object key) {
        return (int) key >= 0;
    }

    @Override
    protected Resume getElement(Object key) {
        return storage[(int) key];
    }
}