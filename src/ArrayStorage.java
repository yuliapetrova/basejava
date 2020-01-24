/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int LENGTH = 10000;
    Resume[] storage = new Resume[LENGTH];

    void clear() {
        this.storage = new Resume[LENGTH];
    }

    void save(Resume r) {
        for (int i = 0; i < this.storage.length; i++) {
            if (null == this.storage[i]) {
                this.storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : this.storage) {
            if (null != resume && uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        Resume result = new Resume();
        result.uuid = "No such element with uuid = " + uuid;
        return result;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.storage.length; i++) {
            if (null != this.storage[i] && uuid.equals(this.storage[i].uuid)) {
                this.storage[i] = null;
            }
        }
        formatArray();
    }

    private void formatArray() {
        Resume[] newStorage = new Resume[LENGTH];
        int newStorageIndex = 0;
        for (Resume resume : this.storage) {
            if (null != resume) {
                newStorage[newStorageIndex] = resume;
                newStorageIndex++;
            }
        }
        this.storage = newStorage;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        int size = 0;
        for (Resume resume : this.storage) {
            if (null != resume) {
                size++;
            }
        }
        return size;
    }
}
