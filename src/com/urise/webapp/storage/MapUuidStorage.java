package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

class MapUuidStorage extends AbstractStorage {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    public void updateResume(Resume r, Object key) {
        mapStorage.put((String) key, r);
    }

    @Override
    public boolean isKeyExist(Object key) {
        return mapStorage.containsKey(key);
    }

    @Override
    public void saveResume(Resume r, Object key) {
        mapStorage.putIfAbsent((String) key, r);
    }

    @Override
    public Resume getElement(Object key) {
        return mapStorage.get(key);
    }

    @Override
    public void deleteResume(Object key) {
        mapStorage.remove(key);
    }

    @Override
    public List<Resume> getAllSorted() {
        Map<String, Resume> map1 = new TreeMap<>(mapStorage);
        return new ArrayList<>(map1.values());
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