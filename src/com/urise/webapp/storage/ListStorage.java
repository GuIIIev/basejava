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
    protected void doUpdate(Resume r, Object searchKey) {
        list.set((Integer) searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        list.add(r);
    }

    @Override
    protected Resume doGet(String uuid, Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(String uuid, Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return list;
    }

    /*    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }*/

    @Override
    public List<Resume> getAllSorted() {
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}
