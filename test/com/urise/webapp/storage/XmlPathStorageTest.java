package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStream;
import com.urise.webapp.storage.serializer.XmlStreamSerializer;

import static com.urise.webapp.storage.AbstractStorageTest.STORAGE_DIR;
import static org.junit.jupiter.api.Assertions.*;

class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}