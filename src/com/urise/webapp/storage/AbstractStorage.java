package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract Object getKey(String uuid);

    protected abstract void updateResume(Resume r, SK key);

    protected abstract boolean isKeyExist(SK key);

    protected abstract void saveResume(Resume r, SK key);

    protected abstract Resume getElement(SK key);

    protected abstract void deleteResume(SK key);

    protected abstract List<Resume> getStorageAsList();

    public void update(Resume r) {
        LOG.info("Update" + r);
        SK key = getExistedKey(r.getUuid());
        updateResume(r, key);
    }

    public void save(Resume r) {
        LOG.info("Save" + r);
        SK key = getNotExistedKey(r.getUuid());
        saveResume(r, key);
    }

    public void delete(String uuid) {
        LOG.info("Delete" + uuid);
        SK key = getExistedKey(uuid);
        deleteResume(key);
    }

    public Resume get(String uuid) {
        LOG.info("Get" + uuid);
        SK key = getExistedKey(uuid);
        return getElement(key);
    }

    protected SK getExistedKey(String uuid) {
        LOG.info("Get Existed Key" + uuid);
        SK key = (SK) getKey(uuid);
        if (!isKeyExist(key)) {
            LOG.warning("Resume " + uuid + " doesn't exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected SK getNotExistedKey(String uuid) {
        SK key = (SK) getKey(uuid);
        if (isKeyExist(key)) {
            LOG.warning("Resume " + uuid + " already exists");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    public List<Resume> getAllSorted() {
        LOG.info("Get All Sorted");
        List<Resume> list = getStorageAsList();
        Collections.sort(list);
        return list;
    }
}