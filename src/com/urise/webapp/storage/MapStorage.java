package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        Set<String> set = new HashSet<>(map.keySet());
        map.keySet().removeAll(set);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.putIfAbsent(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(String uuid, Object searchKey) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid, Object searchKey) {
        map.remove(uuid);
    }


    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Set<String> keys = map.keySet();
        List<String> stringsList = new ArrayList<>(keys);
        for (int i = 0; i < stringsList.size(); i++) {
            if (stringsList.get(i).equals(uuid)) {
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
