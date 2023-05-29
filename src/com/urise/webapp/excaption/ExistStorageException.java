package com.urise.webapp.excaption;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
