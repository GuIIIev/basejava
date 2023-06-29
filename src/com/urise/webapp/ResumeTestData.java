package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("SomeName_1");
        for (ContactType type : ContactType.values()) {
            r1.getContacts(type);
        }

        }
}
