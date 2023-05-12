package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == r.getUuid()) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Resume " + r.getUuid() + " not found.");
    }

    public void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == r.getUuid()) {
                System.out.println("Resume " + r.getUuid() + " already exists");
                return;
            }
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].getUuid(), uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume " + uuid + " not found.");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].getUuid(), uuid)) {
                for (int j = i + 1; j < size; j++) {
                    storage[j - 1] = storage[j];
                }
                storage[size] = null;
                size--;
                return;
            }
        }
        System.out.println("Resume " + uuid + " not found.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        if (size == 0) {
            return new Resume[0];
        }
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    public int size() {
        return size;
    }
}
