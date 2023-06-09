package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "SomeName");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        index = Math.abs(index) - 1;
        size++;
        if (size - index - 1 >= 0) {
            System.arraycopy(storage, index, storage, index + 1, size - index - 1);
        }
        storage[index] = r;
    }

    @Override
    protected void extractResume(int index) {
        if (size - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        storage[size - 1] = null;
        size--;
    }
}
