package com.urise.webapp.storage;

public class ObjectStorageTest extends AbstractStorageTest {
    public ObjectStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }
}