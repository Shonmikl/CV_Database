package com.urise.webapp;

import java.io.File;
import java.util.Objects;

public class FilesFolders {

    public static void main(String[] args) {
        File path = new File("/TopJava/basejava/");
        displayFileName(path);
    }

    private static void displayFileName(File path) {
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile() && files[i] !=null) {
                System.out.println(Objects.requireNonNull(files[i]).getName());
            } else if (Objects.requireNonNull(files[i]).isDirectory()) {
                System.out.println(files[i].getName());
                displayFileName(files[i]);
            }
        }
    }
}