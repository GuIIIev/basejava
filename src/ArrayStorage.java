import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        size = 0; // обнуление кол-ва резюме в массиве
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return;
            }
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                size++; // +1 кол-во резюме в массиве
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return null;
            } else if (Objects.equals(storage[i].uuid, uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return;
            } else if (Objects.equals(storage[i].uuid, uuid)) {
                size--; // -1 кол-во резюме в массиве
                for (int j = i + 1; j < storage.length; j++) {
                    storage[j - 1] = storage[j];
                    if (storage[j] == null) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size == 0) {
            return new Resume[0];
        }
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < newStorage.length; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
