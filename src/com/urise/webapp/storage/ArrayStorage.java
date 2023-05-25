package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertion(Resume r, int index) {
        storage[size] = r;
        size++;
    }

    @Override
    protected void extraction(String uuid, int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }
}
