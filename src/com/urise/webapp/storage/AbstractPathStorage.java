package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory mustn't be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "isn't directory or isn't writable");
        }
    }
        
    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteResume);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        String[] list = directory.toFile().list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

//    @Override
//    protected Path getKey(String uuid) {
//        return new Path(directory);
//    }

//    @Override
//    protected void updateResume(Resume r, Path path) {
//        try {
//            doWrite(r, new BufferedOutputStream(new FileOutputStream(path)));
//        } catch (IOException e) {
//            throw new StorageException("Path write error", r.getUuid(), e);
//        }
//    }
//
//    @Override
//    protected boolean isKeyExist(Path path) {
//        return Path.exists();
//    }
//
//    @Override
//    protected void saveResume(Resume r, Path path) {
//        try {
//            path.createNewPath();
//        } catch (IOException e) {
//            throw new StorageException("Couldn't create Path " + path.toAbsolutePath(), path.getFileName(), e);
//        }
//        updateResume(r, path);
//    }
//
//    @Override
//    protected Resume getElement(Path path) {
//        try {
//            return doRead(new BufferedInputStream(new PathInputStream(path)));
//        } catch (IOException e) {
//            throw new StorageException("Path read error", path.getFileName(), e);
//        }
//    }
//
//    @Override
//    protected void deleteResume(Path path) {
//        if (!Path.delete()) {
//            throw new StorageException("Path delete error", path.getFileName());
//        }
//    }
//
//    @Override
//    protected List<Resume> getStorageAsList() {
//        Path[] paths = directory.listPaths();
//        if (paths == null) {
//            throw new StorageException("Directory can not been read", null);
//        }
//        List<Resume> list = new ArrayList<>(paths.length);
//        for (Path f : paths) {
//            list.add(getElement(f));
//        }
//        return list;
//    }
}