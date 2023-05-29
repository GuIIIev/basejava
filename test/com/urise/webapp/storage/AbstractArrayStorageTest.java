package com.urise.webapp.storage;

import com.urise.webapp.excaption.ExistStorageException;
import com.urise.webapp.excaption.NotExistStorageException;
import com.urise.webapp.excaption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(new Resume(UUID_2));
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume("uuid4"));
    }

    @Test(expected = ExistStorageException.class)
    public void NotSave() throws Exception {
        storage.save(new Resume(UUID_2));
    }

    @Test(expected = StorageException.class)
    public void NotSaveOverflow() throws Exception {
        storage.save(new Resume("uuid99"));
    }

    @Test
    public void get() throws Exception {
        storage.get("uuid1");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}