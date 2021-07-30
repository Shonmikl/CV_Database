package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractArrayStorageTest {
    private static Storage STORAGE;
    private static final String ID_3 = "3";
    private static final String ID_2 = "2";
    private static final String ID_1 = "1";


    @BeforeAll
    public static void setUp() {

        STORAGE.save(new Resume(ID_1));
        STORAGE.save(new Resume(ID_2));
        STORAGE.save(new Resume(ID_3));
    }

    @Test
    void clear() {
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
        Assertions.assertEquals(3, STORAGE.size());
    }
}