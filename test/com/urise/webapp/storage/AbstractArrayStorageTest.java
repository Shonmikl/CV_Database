package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;

    private final static String ID_1 = "1";
    private final static String ID_2 = "2";
    private final static String ID_3 = "3";

    Resume resume1 = new Resume(ID_1);
    Resume resume2 = new Resume(ID_2);
    Resume resume3 = new Resume(ID_3);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;

    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void updateNotExistResume() {
        assertThrows(NotExistStorageException.class, () -> storage.update(new Resume("notExist")));
    }

    @Test
    void update() {
        storage.update(new Resume("1"));
        assertEquals(3, storage.size());
    }

    @Test
    void saveExistResume() {
        assertThrows(ExistStorageException.class, () -> storage.save(new Resume("1")));
    }

//    @Test
//    void saveOverflow() {
//        try {
//            for (int i = 3; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
//                storage.save(new Resume());
//            }
//        } catch (StorageException exception) {
//            Assertions.fail();
//        }
//        storage.save(new Resume());
//    }

    @Test
    void save() {
        assertEquals(3, storage.size());

    }

    @Test
    void deleteNotExistResume() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("5"));
    }

    @Test
    void delete() {
        storage.delete(ID_1);
        assertThrows(NotExistStorageException.class, ()-> storage.get(ID_1));

    }

    @Test
    void getAll() {
        Resume[] getAllExpected = storage.getAll();
        assertEquals(getAllExpected[0], resume1);
        assertEquals(getAllExpected[1], resume2);
        assertEquals(getAllExpected[2], resume3);
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}