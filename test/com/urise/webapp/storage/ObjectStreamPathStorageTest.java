package com.urise.webapp.storage;

import static org.junit.Assert.*;

public class ObjectStreamPathStorageTest extends AbstractStorageTest{
    public ObjectStreamPathStorageTest(Storage storage) {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }
}