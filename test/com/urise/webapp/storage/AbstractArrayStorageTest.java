package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {

    private static Storage storage = new ArrayStorage();

    @BeforeAll
    public static void setUp() throws Exception {

        storage.clear();
        storage.save(new Resume("uuid1"));
        storage.save(new Resume("uuid2"));
        storage.save(new Resume("uuid3"));

    }

    @Test
    void clear() throws Exception {
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void update() throws Exception {

    }

    @Test
    void save() throws Exception{

    }

    @Test
    void get() throws Exception{
    }

    @Test
    void delete() throws Exception{
        Assertions.assertEquals(2, storage.size());
    }

    @Test
    void getAll() throws Exception{
    }

    @Test
    void size() throws Exception{
        Assertions.assertEquals(3, storage.size());
    }
}