package com.urise.webapp;

import java.io.File;

public class FilesAndFolders {
    public static final File PATH = new File("E:/TopJava/basejava");

    public static void displayAll(File path) {

        if(path.isFile()) {
            System.out.println(path.getName());
        } else {
            System.out.println(path.getName());
            File files[] = path.listFiles();
            for(File dirOrFile: files){
                displayAll(dirOrFile);
            }
        }
    }

    public static void main(String[] args) {
        displayAll(PATH);
    }
}