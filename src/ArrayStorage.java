import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return;
            } else {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i  = 0; i < storage.length; i++) {
            if (storage[i] == null) {
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
            } else if(Objects.equals(storage[i].uuid,uuid)) {
                for (int j = i + 1; j < storage.length; j++) {
                    storage[j-1] = storage[j];
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
        if (this.size() == 0) {
            return new Resume[0];
        }
        Resume[] newStorage = new Resume[this.size()];
        for (int i = 0; i < newStorage.length; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return counter;
            } else {
                counter++;
            }
        }
        return 0;
    }
}
