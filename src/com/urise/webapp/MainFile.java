package com.urise.webapp;

import com.urise.webapp.excaption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;


public class MainFile {
    public MainFile() throws IOException {
    }

    public static void main(String[] args) {
        String filePath = ".\\.gitignore";
        File file = new File(".\\.gitignore");

        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File(".\\src\\com\\urise\\webapp");
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
        printDir(dir);
    }

    public static void printDir(File dir) {

        File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDir(file);
                } else if (file.isFile()) {
                    System.out.println("\tFile: " + file.getName());
                }
            }
        }
    }

    public static Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            try {
                return (Resume) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new StorageException("Error read resume", null, e);
            }
        }
    }

}
