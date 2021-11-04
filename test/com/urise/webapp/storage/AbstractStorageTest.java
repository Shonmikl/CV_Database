package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    protected Storage storage;
    protected ResumeTestData resumeTestData = new ResumeTestData();

    protected final String ID_1 = ResumeTestData.createsRandomString();
    protected final String ID_2 = ResumeTestData.createsRandomString();
    protected final String ID_3 = ResumeTestData.createsRandomString();

    protected final String NAME_1 = ResumeTestData.createsRandomString();
    protected final String NAME_2 = ResumeTestData.createsRandomString();
    protected final String NAME_3 = ResumeTestData.createsRandomString();

    protected Resume resume1 = resumeTestData.makesResume(ID_1, NAME_1);
    protected Resume resume2 = resumeTestData.makesResume(ID_2, NAME_2);
    protected Resume resume3 = resumeTestData.makesResume(ID_3, NAME_3);


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