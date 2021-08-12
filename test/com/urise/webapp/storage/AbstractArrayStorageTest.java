package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {
    private static Storage storage;

    private final static String ID_1 = "1";
    private final static String ID_2 = "2";
    private final static String ID_3 = "3";

    protected AbstractArrayStorageTest(Storage storage) {
        AbstractArrayStorageTest.storage = storage;
    }


    @BeforeAll
    static void setUp() {
        storage.clear();
        storage.save(new Resume(ID_1));
        storage.save(new Resume(ID_2));
        storage.save(new Resume(ID_3));
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void updateNotExistElement() {
        assertThrows(NotExistStorageException.class, ()-> storage.update(new Resume("notExist")));
    }

    @Test
    void update() {
        storage.update(new Resume("1"));
        assertEquals(3, storage.size());
    }

    @Test
    void saveExistElement() {
        storage.save(new Resume("Exist"));
        assertThrows(ExistStorageException.class, ()->storage.save(new Resume("Exist")));
    }

    @Test
    void saveOverflow() {

   }

    @Test
    void save() {
        storage.save(new Resume("save"));
        assertEquals(4, storage.size());
        storage.delete("save");
    }

    @Test
    void deleteNotExistElement() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("5"));
    }

    @Test
    void delete() {
        storage.delete(ID_1);
        Assertions.assertEquals(2, storage.size());
        storage.save(new Resume(ID_1));
    }

    @Test
    void getAll() {
        Resume[] getAllExpected = new Resume[3];
        getAllExpected[0] = new Resume(ID_1);
        getAllExpected[1] = new Resume(ID_2);
        getAllExpected[2] = new Resume(ID_3);

        assertEquals(Arrays.toString(getAllExpected), Arrays.toString(storage.getAll()));
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}