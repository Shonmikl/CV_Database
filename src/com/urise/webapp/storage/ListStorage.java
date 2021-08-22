package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> listStorage = new LinkedList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected void updateElement(Resume r, Object key) {
        listStorage.set((Integer) key, r);
    }

    @Override
    protected void saveElement(Resume r, Object key) {
        listStorage.add(r);
    }

    @Override
    protected boolean isKeyExist(Object key) {
        return listStorage.contains(key);
    }

    @Override
    protected Object getKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void deleteElement(Object key) {
        listStorage.remove(key);
    }

    @Override
    protected void insert(Resume r, int index) {

    }

    @Override
    protected Resume getElement(Object key) {
        return listStorage.get((Integer) key);
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Resume get(String uuid) {
        getExistedKey(uuid);
        return listStorage.get((Integer) getKey(uuid));
    }

    @Override
    protected void moveArray(int index) {

    }
}