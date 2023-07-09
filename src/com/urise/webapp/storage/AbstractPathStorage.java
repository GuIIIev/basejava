package com.urise.webapp.storage;

import com.urise.webapp.excaption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    protected List<Resume> doCopyAll() {

/*        try {

            //List<Resume> list = Files.list(directory).forEach(this::new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.list(directory).forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {

                }
            });
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        /*if (files == null) {
            throw new StorageException("Path read error", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (Path file : files) {
            list.add(doGet(file));
        }
        return list;*/
        return null;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("couldn't create path", path.toString(), e);
        }
        doUpdate(r, path);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.toString(), e);
        }
    }

    @Override
    protected void doDelete(Path file) {
        try {
            Files.delete(file);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    protected abstract void doWrite(Resume r, OutputStream file) throws IOException;

    protected abstract Resume doRead(InputStream file) throws IOException;
}
