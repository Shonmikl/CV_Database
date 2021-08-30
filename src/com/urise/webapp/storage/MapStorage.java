package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> mapStorage = new TreeMap<>();

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    public void updateElement(Resume r, Object key) {
        mapStorage.put((String) key, r);
    }

    @Override
    public boolean isKeyExist(Object key) {
        return mapStorage.containsKey(key);
    }

    @Override
    public void saveElement(Resume r, Object key) {
        mapStorage.putIfAbsent((String) key, r);
    }

    @Override
    public Resume getElement(Object key) {
        return mapStorage.get(key);
    }

    @Override
    public void deleteElement(Object key) {
        mapStorage.remove(key);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return mapStorage.values().stream().toList();
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}