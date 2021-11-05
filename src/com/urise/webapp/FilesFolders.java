package com.urise.webapp;

import java.io.File;

public class FilesFolders {

    public static void main(String[] args) {
        File path = new File("/TopJava/basejava/");
        displayFileName(path);
    }

    private static void displayFileName(File path) {
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(file.getName());
                    displayFileName(file);
                }
            }
        }
    }
}