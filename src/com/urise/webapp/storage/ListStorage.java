package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> listStorage = new LinkedList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isKeyExist(Object key) {
        return key != null;
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        listStorage.set((int) key, r);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        listStorage.add(r);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected Resume getElement(Object key) {
        return listStorage.get((int) key);
    }

    @Override
    protected void deleteResume(Object key) {
        listStorage.remove(getElement(key));
    }

    @Override
    public List<Resume> getAllSorted() {
        return listStorage;
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}