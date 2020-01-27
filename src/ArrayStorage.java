/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int LENGTH = 10000;
    private Resume[] storage = new Resume[LENGTH];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                for (int j = i; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size];
        int newStorageIndex = 0;
        for (int i = 0; i < size; i++) {
            newStorage[newStorageIndex] = storage[i];
            newStorageIndex++;
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
