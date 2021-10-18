package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File>{
    private final File directory;

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

    protected abstract void doWrite(Resume r, File file) throws IOException;

    @Override
    protected Resume getElement(File file) {
        return get(file.getName());
    }

    @Override
    protected void deleteResume(File file) {
        file.delete();
    }

    @Override
    protected List<Resume> getStorageAsList() {
        return null;
    }

    @Override
    public void clear() {
        directory.delete();

    }

    @Override
    public int size() {
        return (int) directory.length();
    }
}