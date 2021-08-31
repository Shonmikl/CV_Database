package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ArrayStorageTest extends AbstractStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Test
    void saveOverflow() {
        assertDoesNotThrow(
                ()->  {
                    for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                        storage.save(new Resume());
                   }
                     } , "overflow happened ahead of time");
    }
}