package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        //return hashMapStorage.get(uuid);
        return storageMap.get(uuid);
    }

    @Override
    public void updateResume(Resume r, Resume key) {
        storageMap.put(r.getUuid(), r);
    }

    @Override
    public boolean isKeyExist(Resume key) {
        return key != null;
    }

    @Override
    public void saveResume(Resume r, Resume key) {
        storageMap.put(r.getUuid(), r);
    }

    @Override
    public Resume getElement(Resume key) {
        return key;
    }

    @Override
    public void deleteResume(Resume key) {
        storageMap.remove((key).getUuid());
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public List<Resume> getStorageAsList() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}