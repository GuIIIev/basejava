package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, Section> sections = r.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType sectionType = entry.getKey();
                Section section = entry.getValue();
                switch (sectionType) {
                    case OBJECTIVE:
                        dos.writeUTF(sectionType.getTitle());
                        dos.writeUTF(((TextSection) section).getContent());
                    case PERSONAL:
                        dos.writeUTF(sectionType.getTitle());
                        dos.writeUTF(((TextSection) section).getContent());
                    case ACHIEVEMENT:
                        dos.writeUTF(sectionType.getTitle());
                        dos.writeInt(((ListSection) section).getItems().size());
                        List<String> list = ((ListSection) section).getItems();
                        for (String s : list) {
                            dos.writeUTF(s);
                        }
                    case QUALIFICATIONS:
                        dos.writeUTF(sectionType.getTitle());
                        dos.writeInt(((ListSection) section).getItems().size());
                        list = ((ListSection) section).getItems();
                        for (String s : list) {
                            dos.writeUTF(s);
                        }
                    case EXPERIENCE:
                        dos.writeUTF(sectionType.getTitle());
                        List<Organisation> listOrganisations = ((OrganisationSection) section).getOrganizations();
                        dos.writeInt(listOrganisations.size());
                        for (Organisation organisation : listOrganisations) {
                            dos.writeUTF(organisation.getHomePage().getName());
                            dos.writeUTF(organisation.getHomePage().getUrl());
                            List<Period> periods = organisation.getPeriod();
                            for (Period period : periods) {
                                LocalDate startDate = period.getStartDate();
                                dos.writeInt(startDate.getYear());
                                dos.writeInt(startDate.getMonth().getValue());
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                            }
                        }
                    case EDUCATION:
                        dos.writeUTF(sectionType.getTitle());
                        listOrganisations = ((OrganisationSection) section).getOrganizations();
                        dos.writeInt(listOrganisations.size());
                        for (Organisation organisation : listOrganisations) {
                            dos.writeUTF(organisation.getHomePage().getName());
                            dos.writeUTF(organisation.getHomePage().getUrl());
                            List<Period> periods = organisation.getPeriod();
                            for (Period period : periods) {
                                LocalDate startDate = period.getStartDate();
                                dos.writeInt(startDate.getYear());
                                dos.writeInt(startDate.getMonth().getValue());
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                            }
                        }
                        break;
                }
                dos.writeUTF(entry.getKey().name());
                dos.writeInt(Arrays.asList(SectionType.valueOf(entry.getKey().name())).size());
                List<SectionType> list = new ArrayList<>(List.of(SectionType.valueOf(entry.getKey().name())));
                for (SectionType s : list) {
                    dos.writeUTF(s.toString());
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            int sectionSize = dis.readInt();
            for (int i = 0; i < sectionSize; i++) {
                SectionType section = SectionType.valueOf(dis.readUTF());
                int sectionItems = dis.readInt();
                for (int j = 0; j < sectionItems; j++) {
                    dis.readUTF();
                }
            }
            return resume;
        }
    }
}
