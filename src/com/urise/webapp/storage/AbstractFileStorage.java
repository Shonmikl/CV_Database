package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    protected AbstractFileStorage(File directory) {

        Objects.requireNonNull(directory, "directory mustn't be null");
        if (!directory.isDirectory()) {
            throw  new IllegalArgumentException(directory.getAbsolutePath() + " isn't directory");
        }

        if (!directory.canRead() || !directory.canWrite()) {
            throw  new IllegalArgumentException(directory.getAbsolutePath() + " isn't readable or writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null) {
            for (File file : files) {
                deleteResume(file);
            }
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void updateResume(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected boolean isKeyExist(File file) {
        return file.exists();
    }

    @Override
    protected void saveResume(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume getElement(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException(file.getName(), "File can not been read");
        }
    }

    @Override
    protected void deleteResume(File file) {
        if(!file.delete()) {
            throw new StorageException(file.getName(), "File was not deleted");
        }
    }

    @Override
    protected List<Resume> getStorageAsList() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory can not been read", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File f : files) {
            list.add(getElement(f));
        }
        return list;
    }
}