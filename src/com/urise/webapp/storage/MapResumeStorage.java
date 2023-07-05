package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Resume searchKey) {
        map.remove(((Resume) searchKey).getUuid());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }
}
