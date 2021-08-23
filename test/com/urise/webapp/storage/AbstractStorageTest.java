package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private final static String ID_1 = "1";
    private final static String ID_2 = "2";
    private final static String ID_3 = "3";

    protected Resume resume1 = new Resume(ID_1);
    protected Resume resume2 = new Resume(ID_2);
    protected Resume resume3 = new Resume(ID_3);

    public AbstractStorageTest(Storage storage) {
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
        Resume resume4 = new Resume(ID_1);
        storage.update(resume1);
        assertEquals(resume4.toString(), resume1.toString());
    }

    @Test
    void saveExistResume() {
        assertThrows(ExistStorageException.class, () -> storage.save(new Resume(ID_1)));
    }

    @Test
    void saveOverflow() {
        for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT - 4; i++) {
            storage.save(new Resume());
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    void save() {
        Resume test = new Resume("newSave");
        storage.save(test);
        assertEquals(test.toString(), "newSave");
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
        Resume[] expectedStorage = storage.getAll();
        Resume[] testStorage = {resume1, resume2, resume3};
        assertArrayEquals(testStorage, expectedStorage);
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}