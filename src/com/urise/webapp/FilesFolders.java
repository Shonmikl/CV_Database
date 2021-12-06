package com.urise.webapp;

import java.io.File;

public class FilesFolders {

    public static void main(String[] args) {
        File path = new File("./");
        displayFileName(path, " ");
    }

    private static void displayFileName(File path, String indent) {
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + " | " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + " | " + file.getName());
                    displayFileName(file, indent + "   ");
                }
            }
        }
    }
}