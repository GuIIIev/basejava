package com.urise.webapp.storage;

import com.urise.webapp.excaption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников
    //методы для реализации наследников

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            insertResume(r, index);
        }
    }



    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume r, int index);
}
