package com.urise.webapp.storage;

import com.urise.webapp.excaption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private final Path directory;
    private Strategy strategy;

    protected PathStorage(String dir, Strategy strategy) {
        Objects.requireNonNull(dir, "directory must not be null");

        directory = Paths.get(dir);
        this.strategy = strategy;
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
/*    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>();
        try (Stream<Path> pathStream = Files.list(directory)) {
            pathStream.forEach((Path p) -> {
                list.add(AbstractPathStorage.this.doGet(p));
            });
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
        return list;
    }*/

    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(directory)) {
            pathStream.forEach((Path p) -> {
                list.add(PathStorage.this.doGet(p));
            });
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
        return list;
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
            strategy.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
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
            return strategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.toString(), e);
        }
    }

    @Override
    protected void doDelete(Path file) {
        try {
            Files.delete(file);
        } catch (IOException e) {
            throw new StorageException("Path delete error", e);
        }
    }

    @Override
    public void clear() {
        try (Stream<Path> pathStream = Files.list(directory)) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path file) {
                    PathStorage.this.doDelete(file);
                }
            });
        } catch (IOException e) {
            throw new StorageException("Path delete error", e);
        }
    }

    @Override
    public int size() {
        try (Stream<Path> pathStream = Files.list(directory)) {
            return (int) pathStream.count();
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
    }
}
