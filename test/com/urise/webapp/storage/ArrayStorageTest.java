package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStorageTest extends AbstractArrayStorage {

    @Override
    protected void insert(Resume r, int index) {

    }

    @Override
    protected void moveArray(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}