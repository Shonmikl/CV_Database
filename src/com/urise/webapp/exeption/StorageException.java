package com.urise.webapp.exeption;

public class StorageException extends RuntimeException {

    private String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String path_delete_error, String message, Exception e) {
        super(message, e);

    }

    public String getUuid() {
        return uuid;
    }
}