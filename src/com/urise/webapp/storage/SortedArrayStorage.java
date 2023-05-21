package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("Storage overflow");
        } else if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exists");
        } else {
            size++;
            for (int i = size - 1; i > Math.abs(index) - 1; i--) {
                storage[i] = storage[i - 1];
            }
            storage[Math.abs(index) - 1] = r;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not found.");
        } else {
            for (int i = index; i < size; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
