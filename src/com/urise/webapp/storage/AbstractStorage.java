package com.urise.webapp.storage;

import com.urise.webapp.excaption.ExistStorageException;
import com.urise.webapp.excaption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            doUpdate(r, index);
        }
    }

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSave(r, index);
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(uuid, index);
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            doDelete(index);
        }
    }


    protected abstract int getIndex(String uuid);

    protected abstract void doUpdate(Resume r, int index);

    protected abstract void doSave(Resume r, int index);

    protected abstract Resume doGet(String uuid, int index);

    protected abstract void doDelete(int index);
}
