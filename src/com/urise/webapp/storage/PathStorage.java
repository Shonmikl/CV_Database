package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.SerialStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private final Path directory;
    private final SerialStrategy serialStrategy;

    protected PathStorage(String dir, SerialStrategy serialStrategy) {
        this.serialStrategy = serialStrategy;
        directory = Paths.get(dir);
        Objects.requireNonNull(dir, "Directory mustn't be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "isn't directory or isn't writable");
        }
    }

    @Override
    public void clear() {
        getFilesList().forEach(this::deleteResume);
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
    }

    @Override
    protected Path getKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void updateResume(Resume r, Path path) {
        try {
            serialStrategy.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFilesName(path), e);
        }
    }

    @Override
    protected boolean isKeyExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void saveResume(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFilesName(path), e);
        }
        updateResume(r, path);
    }

    @Override
    protected Resume getElement(Path path) {
        try {
            return serialStrategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", getFilesName(path), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFilesName(path), e);
        }
    }

    @Override
    protected List<Resume> getStorageAsList() {
        return getFilesList().map(this::getElement).collect(Collectors.toList());
    }

    private String getFilesName(Path path) {
        return path.getFileName().toString();
    }

    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Path delete error", "Read error", e);
        }
    }
}