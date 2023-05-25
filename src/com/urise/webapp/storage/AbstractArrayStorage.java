package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("Storage overflow");
        } else if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exists");
        } else {
            insertion(r, index);
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not found.");
        } else {
            extraction(uuid, index);
        }
    }

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume " + r.getUuid() + " not found.");
        } else {
            storage[index] = r;
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertion(Resume r, int index);

    protected abstract void extraction(String uuid, int index);

    public int size() {
        return size;
    }
}
