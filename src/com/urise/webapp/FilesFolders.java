package com.urise.webapp;

import java.io.File;

public class FilesFolders {

    public static void main(String[] args) {
        File path = new File("E:/TopJava/basejava/.");
        displayFileName(path);
    }

    private static void displayFileName(File path) {
        if (path.isFile()) {
            System.out.println(path.getName());
        } else {
            System.out.println(path.getName());
            if (path.listFiles() == null) {
                System.out.println("File is not exist");
            } else {
                File files[] = path.listFiles();
                for (File dirOrFile : files) {
                    displayFileName(dirOrFile);
                }
            }
        }
    }
}