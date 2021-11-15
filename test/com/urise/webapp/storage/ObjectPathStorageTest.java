package com.urise.webapp.storage;

class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getPath(), new ObjectStreamStorage()) {
        });
    }
}