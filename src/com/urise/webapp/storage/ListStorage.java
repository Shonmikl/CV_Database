package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {
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
    protected boolean isKeyExist(Integer key) {
        return key != null;
    }

    @Override
    protected void updateResume(Resume r, Integer key) {
        listStorage.set(key, r);
    }

    @Override
    protected void saveResume(Resume r, Integer key) {
        listStorage.add(r);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected Resume getElement(Integer key) {
        return listStorage.get(key);
    }

    @Override
    protected void deleteResume(Integer key) {
        listStorage.remove(getElement(key));
    }

    @Override
    public List<Resume> getStorageAsList() {
        return new ArrayList<>(listStorage);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}