package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(((TextSection) section).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        dos.writeInt(((ListSection) section).getItems().size());
                        List<String> list = ((ListSection) section).getItems();
                        for (String s : list) {
                            dos.writeUTF(s);
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organisation> listOrganisations = ((OrganisationSection) section).getOrganizations();
                        dos.writeInt(listOrganisations.size());
                        for (Organisation organisation : listOrganisations) {
                            dos.writeUTF(organisation.getHomePage().getName());
                            dos.writeUTF(organisation.getHomePage().getUrl());
                            List<Period> periods = organisation.getPeriod();
                            dos.writeInt(periods.size());
                            for (Period period : periods) {
                                LocalDate localDate = period.getStartDate();
                                dos.writeInt(localDate.getYear());
                                dos.writeInt(localDate.getMonth().getValue());
                                localDate = period.getEndDate();
                                dos.writeInt(localDate.getYear());
                                dos.writeInt(localDate.getMonth().getValue());
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                            }
                        }
                        break;
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
                switch (section) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.addSection(section, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        int listSectionSize = dis.readInt();
                        List<String> list = new ArrayList<>();
                        for (int j = 0; j < listSectionSize; j++) {
                            list.add(dis.readUTF());
                        }
                        resume.addSection(section, new ListSection(list));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organisation> listOrganisations = new ArrayList<>();
                        int listOrganisationsSize = dis.readInt();
                        for (int j = 0; j < listOrganisationsSize; j++) {
                            Link link = new Link(dis.readUTF(), dis.readUTF());
                            int periodSize = dis.readInt();
                            List<Period> periods = new ArrayList<>();
                            for (int k = 0; k < periodSize; k++) {
                                periods.add(new Period(
                                        LocalDate.of(dis.readInt(), dis.readInt(), 1),
                                        LocalDate.of(dis.readInt(), dis.readInt(), 1),
                                        dis.readUTF(),
                                        dis.readUTF()));
                            }
                            listOrganisations.add(new Organisation(link, periods));
                        }
                        resume.addSection(section, new OrganisationSection(listOrganisations));
                        break;
                }
            }
            return resume;
        }
    }
}
