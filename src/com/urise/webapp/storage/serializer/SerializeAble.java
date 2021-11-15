package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface SerializeAble {
    void doWrite(Resume r, OutputStream os) throws IOException;
    Resume doRead (InputStream is) throws IOException;
}