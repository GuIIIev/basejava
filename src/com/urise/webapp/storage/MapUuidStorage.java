package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected String getSearchKey(String uuid) {
        Set<String> keys = map.keySet();
        for (String s : keys) {
            if (s.equals(uuid)) {
                return uuid;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }
}
