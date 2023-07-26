package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";
        File file = new File(".\\.gitignore");

        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("D:\\JavaPractice\\basejava\\src");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\nSome recursion: \n\n");
        printDir(dir, "");
    }


    public static void printDir(File dir, String level) {
        File[] list = dir.listFiles();

        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    System.out.println(level + "Directory: " + file.getName());
                    printDir(file, level + " ");
                } else if (file.isFile()) {
                    System.out.println(level + "File: " + file.getName());
                }
            }
        }
    }
}

