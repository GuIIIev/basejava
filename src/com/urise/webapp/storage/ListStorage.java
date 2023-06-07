package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doUpdate(Resume r, int index) {
        list.set(index, r);
    }

    @Override
    protected void doSave(Resume r, int index) {
        list.add(r);
    }

    @Override
    protected Resume doGet(String uuid, int index) {
        return list.get(index);
    }

    @Override
    protected void doDelete(int index) {
        list.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

}
