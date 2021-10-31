package com.urise.webapp.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesAndFolders {
    public static final File PATH = new File("E:/TopJava/basejava");

    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get(String.valueOf(PATH))).filter(Files::isRegularFile)
                .forEach(System.out::println);
    }
}