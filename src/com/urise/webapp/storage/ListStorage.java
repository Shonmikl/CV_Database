package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> listStorage = new LinkedList<Resume>();


    @Override
    public void clear() {
        if(listStorage.size() > 0) {
            listStorage.clear();
        }
    }

    @Override
    public void update(Resume r) {
        int index = listStorage.indexOf(r);
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            listStorage.set(index, r);
        }
    }

    @Override
    public void save(Resume r) {
       if(!listStorage.contains(r)) {
           listStorage.add(listStorage.size(), r);
       } else {
           throw new ExistStorageException(r.getUuid());
       }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else listStorage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        Resume[] copyOfList = listStorage.toArray(new Resume[listStorage.size()]);
        return copyOfList;
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (uuid.equals(listStorage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}