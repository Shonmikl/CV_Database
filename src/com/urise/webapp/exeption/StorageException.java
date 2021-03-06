package com.urise.webapp.exeption;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException (String message) {
        this(message, null, null);
    }

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String uuid, String message, Exception e) {
        super(message, e);
        this.uuid = uuid;

    }

    public String getUuid() {
        return uuid;
    }
}