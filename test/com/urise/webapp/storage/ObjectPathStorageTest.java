package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStream;

class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getPath(), new ObjectStream()) {
        });
    }
}