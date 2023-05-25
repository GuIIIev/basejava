package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertion(Resume r, int index) {
        index = Math.abs(index) - 1;
        size++;
        if (size - index - 1 >= 0) {
            System.arraycopy(storage, index, storage, index + 1, size - index - 1);
        }
        storage[index] = r;
    }

    @Override
    protected void extraction(String uuid, int index) {
        if (size - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        storage[size - 1] = null;
        size--;
    }
}
