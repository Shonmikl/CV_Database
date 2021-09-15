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
    public void updateResume(Resume r, Object key) {
        hashMapStorage.put(r.getUuid(), r);
    }

    @Override
    public boolean isKeyExist(Object key) {
        return hashMapStorage.containsKey(key);
    }

    @Override
    public void saveResume(Resume r, Object key) {
        hashMapStorage.put(r.getUuid(), r);
    }

    @Override
    public Resume getElement(Object key) {
        return hashMapStorage.get(key);
    }

    @Override
    public void deleteResume(Object key) {
        hashMapStorage.remove(key);
    }

    @Override
    public void clear() {
        hashMapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        Map<String, Resume> map = new TreeMap<>(hashMapStorage);
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return hashMapStorage.size();
    }
}