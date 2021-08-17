package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;

    private final static String ID_1 = "1";
    private final static String ID_2 = "2";
    private final static String ID_3 = "3";

    protected Resume resume1 = new Resume(ID_1);
    protected Resume resume2 = new Resume(ID_2);
    protected Resume resume3 = new Resume(ID_3);

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
       Resume resume4 = new Resume("1");
        storage.update(resume4);
        assertEquals(resume4.getUuid(), resume1.getUuid());
    }

    @Test
    void saveExistResume() {
        assertThrows(ExistStorageException.class, () -> storage.save(new Resume("1")));
    }

    @Test
    void saveOverflow() {
        try {
            for (int i = 3; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException exception) {
            Assertions.fail();
        }
        storage.save(new Resume());
    }

    @Test
    void save() {
        storage.save(new Resume("newSave"));
        assertEquals(4, storage.size());

    }

    @Test
    void deleteNotExistResume() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("5"));
    }

    @Test
    void delete() {
        storage.delete(ID_1);
        assertEquals(2, storage.size());

    }

    @Test
    void getAll() {
        Resume[] getAllExpected = storage.getAll();
        //assertArrayEquals(storage, getAllExpected);
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}