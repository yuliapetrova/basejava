/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int LENGTH = 10000;
    private Resume[] storage = new Resume[LENGTH];
    private int size = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i]) {
                storage[i] = null;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (null == storage[i]) {
                storage[i] = r;
                size++;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (null != resume && uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                size--;
            }
        }
        storage = formatArray(LENGTH);
    }

    private Resume[] formatArray(int arraySize) {
        Resume[] newStorage = new Resume[arraySize];
        int newStorageIndex = 0;
        for (Resume resume : storage) {
            if (null != resume) {
                newStorage[newStorageIndex] = resume;
                newStorageIndex++;
            }
        }
        return newStorage;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return formatArray(size);
    }

    int size() {
        return size;
    }
}
