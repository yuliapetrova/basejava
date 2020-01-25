/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int LENGTH = 10;
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
        for (Resume resume : storage) {
            if (null != resume && uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (null != storage[i] && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                size--;
            }
        }
        int j = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (null != storage[i]) {
                Resume temp = storage[j];
                storage[j] = storage[i];
                storage[i] = temp;
                j++;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size];
        int newStorageIndex = 0;
        for (Resume resume : storage) {
            if (null != resume) {
                newStorage[newStorageIndex] = resume;
                newStorageIndex++;
            }
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
