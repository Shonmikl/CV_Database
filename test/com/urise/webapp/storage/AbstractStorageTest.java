package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractStorageTest {
    protected final static File STORAGE_DIR = new File("D://VLC/plugins/stream_filter");
    protected Storage storage;

    protected final String ID_1 = "001";
    protected final String ID_2 = "002";
    protected final String ID_3 = "003";

    protected final String NAME_1 = "NAME_1";
    protected final String NAME_2 = "NAME_2";
    protected final String NAME_3 = "NAME_3";

    protected Resume resume1 = ResumeTestData.receiveFilledResume(ID_1, NAME_1);
    protected Resume resume2 = ResumeTestData.receiveFilledResume(ID_2, NAME_2);
    protected Resume resume3 = ResumeTestData.receiveFilledResume(ID_3, NAME_3);

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