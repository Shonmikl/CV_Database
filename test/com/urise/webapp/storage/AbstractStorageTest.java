package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private final static String ID_1 = "1";
    private final static String ID_2 = "2";
    private final static String ID_3 = "3";

    protected Resume resume1 = new Resume(ID_1, "name1");
    protected Resume resume2 = new Resume(ID_2, "name2");
    protected Resume resume3 = new Resume(ID_3, "name3");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(resume3);
        storage.save(resume1);
        storage.save(resume2);

    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void updateNotExistResume() {
        assertThrows(NotExistStorageException.class, () -> storage.update(new Resume("TEST_UUID", "TEST_NAME")));
    }

    @Test
    void update() {
        Resume resume4 = new Resume(ID_1, "TEST");
        storage.update(resume1);
        assertEquals(resume4.getFullName(), "TEST");
    }

    @Test
    void saveExistResume() {
        assertThrows(ExistStorageException.class, () -> storage.save(resume1));
    }

    @Test
    void save() {
        Resume test = new Resume("TEST_UUID", "TEST_NAME");
        storage.save(test);
        assertEquals(test, storage.get("TEST_UUID"));
    }

    @Test
    void deleteNotExistResume() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("5"));
    }

    @Test
    void delete() {
        storage.delete(ID_1);
        assertThrows(NotExistStorageException.class, () -> storage.get(ID_1));
    }

    @Test
    void getAllSorted() {
        List<Resume> expectedStorage = storage.getAllSorted();
        List<Resume> testStorage = List.of(resume1, resume2, resume3);
        assertEquals(testStorage, expectedStorage);
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }
}