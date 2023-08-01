package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");
        r1.addContact(ContactType.PHONE, "+7(921) 855-0482");
        r1.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        r1.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        r1.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        r1.addContact(ContactType.GITHUB, "Профиль GitHub");
        r1.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        r1.addContact(ContactType.HOME_PAGE, "Домашняя страница");

        r1.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        r1.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        r1.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.")));
        r1.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\"")));
        r1.addSection(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(
                new Organisation(
                        "Java Online Projects",
                        "javaops.ru",
                        List.of(
                                new Period(LocalDate.of(2013, 10, 1),
                                        LocalDate.now(),
                                        "Автор проекта.",
                                        "Создание, организация и проведение Java онлайн проектов и стажировок.")
                        )),
                new Organisation(
                        "Wrike",
                        "wrike.com",
                        List.of(
                                new Period(LocalDate.of(2014, 10, 1),
                                        LocalDate.of(2016, 1, 1),
                                        "Старший разработчик (backend)",
                                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")
                        )),
                new Organisation(
                        "RIT Center",
                        "",
                        List.of(
                                new Period(LocalDate.of(2012, 4, 1),
                                        LocalDate.of(2014, 10, 1),
                                        "Java архитектор",
                                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")
                        )),
                new Organisation(
                        "Luxoft (Deutsche Bank)",
                        "luxoft.ru",
                        List.of(
                                new Period(LocalDate.of(2010, 12, 1),
                                        LocalDate.of(2012, 4, 1),
                                        "Ведущий программист",
                                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")
                        )),
                new Organisation(
                        "Yota",
                        "yota.ru",
                        List.of(
                                new Period(LocalDate.of(2008, 6, 1),
                                        LocalDate.of(2010, 12, 1),
                                        "Ведущий специалист",
                                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")
                        )),
                new Organisation(
                        "Enkata",
                        "enkata.com",
                        List.of(
                                new Period(LocalDate.of(2007, 3, 1),
                                        LocalDate.of(2008, 6, 1),
                                        "Разработчик ПО",
                                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")
                        )),
                new Organisation(
                        "Siemens AG",
                        "siemens.com",
                        List.of(
                                new Period(LocalDate.of(2005, 1, 1),
                                        LocalDate.of(2007, 2, 1),
                                        "Разработчик ПО",
                                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")
                        )),
                new Organisation(
                        "Alcatel",
                        "alcatel.ru",
                        List.of(new Period(LocalDate.of(1997, 9, 1),
                                LocalDate.of(2005, 1, 1),
                                "Инженер по аппаратному и программному тестированию",
                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")
                        )))));
        r1.addSection(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(
                new Organisation(
                        "Coursera",
                        "coursera.org",
                        List.of(new Period(LocalDate.of(2013, 3, 1),
                                LocalDate.of(2013, 5, 1),
                                "Functional Programming Principles in Scala' by Martin Odersky",
                                "")
                        )),
                new Organisation(
                        "Luxoft",
                        "luxoft.ru",
                        List.of(
                                new Period(LocalDate.of(2011, 3, 1),
                                        LocalDate.of(2011, 4, 1),
                                        "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                                        "")
                        )),
                new Organisation(
                        "Siemens AG",
                        "siemens.com",
                        List.of(
                                new Period(LocalDate.of(2005, 1, 1),
                                        LocalDate.of(2005, 4, 1),
                                        "3 месяца обучения мобильным IN сетям (Берлин)",
                                        "")
                        )),
                new Organisation(
                        "Alcatel",
                        "alcatel.ru",
                        List.of(
                                new Period(LocalDate.of(1997, 9, 1),
                                        LocalDate.of(1998, 3, 1),
                                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                        "")
                        )),
                new Organisation(
                        "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                        "itmo.ru",
                        List.of(
                                new Period(LocalDate.of(1993, 9, 1),
                                        LocalDate.of(1996, 7, 1),
                                        "Аспирантура (программист С, С++)",
                                        ""),
                                new Period(LocalDate.of(1987, 9, 1),
                                        LocalDate.of(1993, 7, 1),
                                        "Инженер (программист Fortran, C)",
                                        "")
                        )),
                new Organisation(
                        "Заочная физико-техническая школа при МФТИ",
                        "mipt.ru",
                        List.of(
                                new Period(LocalDate.of(1984, 9, 1),
                                        LocalDate.of(1987, 6, 1),
                                        "Закончил с отличием",
                                        "")
                        ))
        )));
        System.out.println("Вывод данный по резюме: " + r1.getUuid());
        System.out.println(r1.getFullName());

        System.out.println("Some contacts: \n");
        for (ContactType type : ContactType.values()) {
            if (r1.getContacts(type) != null) {
                System.out.println(type.getTitle() + ": " + r1.getContacts(type));
            }
        }

        System.out.println("\n\nSome sections: \n");

        for (SectionType type : SectionType.values()) {
            if (r1.getSections(type) != null) {
                System.out.println(type.getTitle() + ": \n" + r1.getSections(type).toString());
            }
        }
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.addContact(ContactType.PHONE, "some phone number");
        resume.addContact(ContactType.SKYPE, "skype:skype");
        resume.addContact(ContactType.MAIL, "mail.ru");
        resume.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        resume.addContact(ContactType.GITHUB, "Профиль GitHub");
        resume.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        resume.addContact(ContactType.HOME_PAGE, "Домашняя страница");
        resume.addSection(SectionType.OBJECTIVE, new TextSection("над чем-то работаю"));
        resume.addSection(SectionType.PERSONAL, new TextSection("умный и красивый"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.")));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce")));
        resume.addSection(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(
                new Organisation(
                        "Java Online Projects",
                        "javaops.ru",
                        List.of(
                                new Period(LocalDate.of(2013, 10, 1),
                                        LocalDate.now(),
                                        "Автор проекта.",
                                        "Создание, организация и проведение Java онлайн проектов и стажировок.")
                        )),
                new Organisation(
                        "Wrike",
                        "wrike.com",
                        List.of(
                                new Period(LocalDate.of(2014, 10, 1),
                                        LocalDate.of(2016, 1, 1),
                                        "Старший разработчик (backend)",
                                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")
                        )))));
        resume.addSection(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(
                new Organisation(
                        "Coursera",
                        "coursera.org",
                        List.of(new Period(LocalDate.of(2013, 3, 1),
                                LocalDate.of(2013, 5, 1),
                                "Functional Programming Principles in Scala' by Martin Odersky",
                                "")
                        )),
                new Organisation(
                        "Luxoft",
                        "luxoft.ru",
                        List.of(
                                new Period(LocalDate.of(2011, 3, 1),
                                        LocalDate.of(2011, 4, 1),
                                        "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                                        "")
                        )))));
        return resume;
    }
}
