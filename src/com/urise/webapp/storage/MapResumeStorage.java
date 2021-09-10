package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> hashMapStorage = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        //return hashMapStorage.get(uuid);
        return uuid;
    }

    @Override
    public void updateElement(Resume r, Object key) {
        hashMapStorage.put(r.getUuid(), r);
    }

    @Override
    public boolean isKeyExist(Object key) {
        return hashMapStorage.containsKey(key);
    }

    @Override
    public void saveElement(Resume r, Object key) {
        hashMapStorage.put(r.getUuid(), r);
    }

    @Override
    public Resume getElement(Object key) {
        return hashMapStorage.get(key);
    }

    @Override
    public void deleteElement(Object key) {
        hashMapStorage.remove(key);
    }

    @Override
    public void clear() {
        hashMapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(hashMapStorage.values());
    }

    @Override
    public int size() {
        return hashMapStorage.size();
    }
}