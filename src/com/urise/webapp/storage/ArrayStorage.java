package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                for (int j = i + 1; j < size; j++) {
                    storage[j - 1] = storage[j];
                }
                storage[size] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size == 0) {
            return new Resume[0];
        }
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
