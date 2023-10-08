package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class
DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            writeWithException(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            writeWithException(dos, r.getSections().entrySet(), entry -> {
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
                        writeWithException(dos, ((ListSection) section).getItems(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeWithException(dos, ((OrganisationSection) section).getOrganisations(), organisation -> {
                            dos.writeUTF(organisation.getHomePage().getName());
                            dos.writeUTF(organisation.getHomePage().getUrl());
                            writeWithException(dos, organisation.getPeriod(), period -> {
                                localDateWriter(dos, period.getStartDate());
                                localDateWriter(dos, period.getEndDate());
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                            });
                        });
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readWithException(dis, () -> resume.setContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readWithException(dis, () -> {
                SectionType section = SectionType.valueOf(dis.readUTF());
                switch (section) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.setSection(section, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.setSection(section, new ListSection(getSectionList(dis, dis::readUTF)));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        resume.setSection(section, new OrganisationSection(getSectionList(dis, () -> new Organisation(
                                new Link(dis.readUTF(), dis.readUTF()),
                                getSectionList(dis, () -> new Period(
                                        localDateReader(dis),
                                        localDateReader(dis),
                                        dis.readUTF(),
                                        dis.readUTF()))
                        ))));
                }
            });
            return resume;
        }
    }

    private void localDateWriter(DataOutputStream dos, LocalDate localDateStart) throws IOException {
        dos.writeInt(localDateStart.getYear());
        dos.writeInt(localDateStart.getMonth().getValue());
        dos.writeInt(localDateStart.getDayOfMonth());
    }

    private LocalDate localDateReader(DataInputStream dis) throws IOException {
        return LocalDate.of(dis.readInt(), dis.readInt(), dis.readInt());
    }

    private <T> void writeWithException(DataOutputStream dos, Collection<T> collection, IWriter<T> writer) throws IOException { // интерфейс для вывода элемента коллекции куда то в поток
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }

    private <T> void readWithException(DataInputStream dis, IReader<T> reader) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            reader.read();
        }
    }

    interface IWriter<T> {
        void write(T t) throws IOException;
    }

    interface IReader<T> {
        void read() throws IOException;
    }

    interface IGetter<T> {
        T get() throws IOException;
    }

    private <T> List<T> getSectionList(DataInputStream dis, IGetter<T> getter) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(getter.get());
        }
        return list;
    }
}
