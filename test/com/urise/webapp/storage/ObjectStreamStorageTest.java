package com.urise.webapp.storage;

import com.urise.webapp.storage.strategy.streamStrategy;

public class ObjectStreamStorageTest extends AbstractStorageTest {
    public ObjectStreamStorageTest() {
        super(new FileStorage(STORAGE_DIR, new streamStrategy()));
    }
}