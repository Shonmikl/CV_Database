package com.urise.webapp.storage;

import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractArrayStorageTest {
    private static Storage storage = new SortedArrayStorage();

    private static final String ID_3 = "3";
    private static final String ID_2 = "2";
    private static final String ID_1 = "1";


    @BeforeAll
    public static void setUp() {

        storage.save(new Resume(ID_1));
        storage.save(new Resume(ID_2));
        storage.save(new Resume(ID_3));
    }

    @Test
    void clear() {
        Assertions.assertNull(null);
    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {

    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}