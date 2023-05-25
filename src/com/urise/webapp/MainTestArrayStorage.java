package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;


/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r6 = new Resume();
        r6.setUuid("uuid3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r3); //for SortedArrayStorage
        ARRAY_STORAGE.save(r6);

        printAll();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        //Check update method
        printAll();
        ARRAY_STORAGE.update(r3);

        //Checks in methods
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.get(r5.getUuid());
        ARRAY_STORAGE.update(r5);
        ARRAY_STORAGE.delete(r3.getUuid());

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
