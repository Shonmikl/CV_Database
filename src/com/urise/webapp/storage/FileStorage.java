package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.SerializeAble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private final SerializeAble serializeAble;
    private final File directory;

    protected FileStorage(File directory, SerializeAble serializeAble) {
        this.serializeAble = serializeAble;
        Objects.requireNonNull(directory, "directory mustn't be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " isn't directory");
        }

        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " isn't readable or writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
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
            serializeAble.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Path delete error", "IO error", e);
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
            serializeAble.doWrite(r, new FileOutputStream(file));
        } catch (IOException e) {
            throw new StorageException("Path delete error", "IO error", e);
        }
    }

    @Override
    protected Resume getElement(File file) {
        try {
            return serializeAble.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException(file.getName(), "File can not been read");
        }
    }

    @Override
    protected void deleteResume(File file) {
        if (!file.delete()) {
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