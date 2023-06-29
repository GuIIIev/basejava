package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("SomeName_1");
        r1.addContact(ContactType.PHONE, "89202231221");
        r1.addContact(ContactType.SKYPE, "Skype_User");
        r1.addSection(SectionType.PERSONAL, new TextSection("Clever, smart, sociable, strong logic"));
        r1.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Smiling everyday", "hello with everyone")));
        r1.addSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(
                new Organization("Greenatom", "gteenatom.ru", LocalDate.of(2020, 1, 8), LocalDate.of(2023, 1, 8), "Analyst", "making some analysis"),
                new Organization("Greenatom1", "gteenat1om.ru", LocalDate.of(2015, 1, 8), LocalDate.of(2020, 1, 7), "Analyst", "making some analysis"))));
        System.out.println(r1);
        System.out.println("some contacts: \n");
        for (ContactType type : ContactType.values()) {
            System.out.println(r1.getContacts(type));
        }
        System.out.println("some sections: \n");

        for (SectionType type : SectionType.values()) {
            if (r1.getSections(type) != null) {
                System.out.println(r1.getSections(type).toString());
            }
        }

    }
}
