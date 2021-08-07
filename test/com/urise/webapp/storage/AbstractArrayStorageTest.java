package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractArrayStorageTest {
    private static Storage storage = new SortedArrayStorage();

    private static final String ID_1 = "1";
    private static final String ID_2 = "2";
    private static final String ID_3 = "3";

    @BeforeAll
    public static void setUp() {
        storage.save(new Resume(ID_1));
        storage.save(new Resume(ID_2));
        storage.save(new Resume(ID_3));
    }

    @Test
    void clearNotExistElement() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("5"));
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
        Storage updateStorage = new SortedArrayStorage();
        updateStorage.save(new Resume("new"));
        updateStorage.update(new Resume("new"));
        assertEquals(1, updateStorage.size());
    }

//    @Test
//    void saveExistElement() {
//        assertThrows(ExistStorageException.class, () -> storage.save(new Resume(ID_2)));
//    }

//    @Test
//        // todo
//    void saveOverflow() {
//        Storage[] overflowStorage = new SortedArrayStorage[0];
//        assertThrows(StorageException.class, () -> overflowStorage[0].save(new Resume("3")));
//    }

    @Test
    void save() {
        Storage saveStorage = new SortedArrayStorage();
        saveStorage.save(new Resume(ID_1));
        assertEquals(1, saveStorage.size());
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

//    @Test
//    void getAll() {
//        Resume getAllExpected[] = new Resume[3];
//        getAllExpected[0] = new Resume(ID_1);
//        getAllExpected[1] = new Resume(ID_2);
//        getAllExpected[2] = new Resume(ID_3);
//
//        assertSame(Arrays.toString(getAllExpected), Arrays.toString(storage.getAll()));
//    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}