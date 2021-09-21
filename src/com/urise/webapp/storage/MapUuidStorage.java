package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

class MapUuidStorage extends AbstractStorage<String> {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    public void updateResume(Resume r, String key) {
        mapStorage.put(key, r);
    }

    @Override
    public boolean isKeyExist(String key) {
        return mapStorage.containsKey(key);
    }

    @Override
    public void saveResume(Resume r, String key) {
        mapStorage.putIfAbsent(key, r);
    }

    @Override
    public Resume getElement(String key) {
        return mapStorage.get(key);
    }

    @Override
    public void deleteResume(String key) {
        mapStorage.remove(key);
    }

    @Override
    public List<Resume> getStorageAsList() {
        return  new ArrayList<>(mapStorage.values());
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}