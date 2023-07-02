package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("�������� ������");
        r1.addContact(ContactType.PHONE, "+7(921) 855-0482");
        r1.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        r1.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        r1.addContact(ContactType.LINKEDIN, "������� LinkedIn");
        r1.addContact(ContactType.GITHUB, "������� GitHub");
        r1.addContact(ContactType.STACKOVERFLOW, "������� Stackoverflow");
        r1.addContact(ContactType.HOME_PAGE, "�������� ��������");

        r1.addSection(SectionType.OBJECTIVE, new TextSection("������� ���������� � �������������� �������� �� Java Web � Enterprise �����������"));
        r1.addSection(SectionType.PERSONAL, new TextSection("������������� ����� ���, ������� ������, ������������, ��������������. ������ ���� � �����������."));
        r1.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
                "����������� ������� � �������� ���������� Java �������� ��� ��������� ����������: ���������� �������� �� ����� Spring Cloud/������������, ������� ����������� ����������� ����������� �� Spring Boot, ������� � ������� ��� �� Play-2, �������������� Spring Boot + Vaadin ������ ��� ����������� DIY ����",
                "� 2013 ����: ���������� �������� \"���������� Web ����������\",\"Java Enterprise\", \"�������������� maven. ���������������. XML (JAXB/StAX). ��� ������� (JAX-RS/SOAP). ��������� �������������� (JMS/AKKA)\". ����������� ������ ���������� � ������� ��������. ����� 3500 �����������.",
                "���������� ������������� �������������� ��� ������ ��������� ���������� ��������� Wrike. ���������� � Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "����������� �������� ���������� � ����������� ���������� ERP ������� River BPM. ���������� � 1�, Bonita BPM, CMIS, LDAP. ���������� ���������� ���������� ���������� �� �����: Scala/Play/Anorm/JQuery. ���������� SSO �������������� � ����������� ��������� ERP �������, ���������� CIFS/SMB java �������.",
                "���������� c ���� Rich Internet Application ���������� �� ����� ���������� JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock ��� ���������������� ���������.",
                "�������� JavaEE ���������� ��� ����������������� �������������� �����-��������� �������� (SOA-base �����������, JAX-WS, JMS, AS Glassfish). ���� ���������� �������� � ���������� � ��������� ����� ������� ����������� Nagios. ���������� ������ ������� ��� ����������������� � ����������� ������� �� JMX (Jython/ Django).",
                "���������� ���������� �� ������ �������� ���� �������� ��������� ������� ������ (Cyberplat, Eport, Chronopay, ��������), ������c���(Erip, Osmp) � ���������.")));
        r1.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(������������, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "����������: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "�����������: Maven + plugin development, Gradle, ��������� Ngnix",
                "����������������� Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "�������� ������ � ���� ���������� ��������� ���, SOA, �������� ���������������, ������������� ��������, UML, ��������������� ����������������",
                "������ �������, ���������� \"upper intermediate\"")));
        r1.addSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(
                new Organization("Java Online Projects",
                        "javaops.ru",
                        period, LocalDate.of(2013, 10, 1),
                        LocalDate.now(),
                        "����� �������.",
                        "��������, ����������� � ���������� Java ������ �������� � ����������."),
                new Organization("Wrike",
                        "wrike.com",
                        period, LocalDate.of(2014, 10, 1),
                        LocalDate.of(2016, 1, 1),
                        "������� ����������� (backend)",
                        "�������������� � ���������� ������ ��������� ���������� ��������� Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). ������������� ��������������, ����������� �� OAuth1, OAuth2, JWT SSO."),
                new Organization("RIT Center",
                        "",
                        period, LocalDate.of(2012, 4, 1),
                        LocalDate.of(2014, 10, 1),
                        "Java ����������",
                        "����������� �������� ���������� ������� ERP ��� ������ ���������: �������� ��������, ���������������, ������� CI (Jenkins), �������� ���� (������������ Flyway), ���������������� ������� (pgBoucer, Nginx), AAA via SSO. ����������� �� � ��������� ����� �������. ���������� �������������� ��������: CMIS, BPMN2, 1C (WebServices), �������� ������ ���������� (�����, ������� � pdf, doc, html). ���������� Alfresco JLAN ��� online �������������� �� �������� ���������� MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"),
                new Organization("Luxoft (Deutsche Bank)",
                        "luxoft.ru",
                        period, LocalDate.of(2010, 12, 1),
                        LocalDate.of(2012, 4, 1),
                        "������� �����������",
                        "������� � ������� Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). ���������� ���������� � ��������� ����� CRM. ���������� RIA-���������� ��� �����������������, ����������� � ������� ����������� � ������� ���������������� ���������. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."),
                new Organization("Yota",
                        "yota.ru",
                        period, LocalDate.of(2008, 6, 1),
                        LocalDate.of(2010, 12, 1),
                        "������� ����������",
                        "������ � ������������� Java EE ���������� ��� ������ \"��������� �������\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). ���������� �����������������, ���������� � ����������� ����������. ���������� online JMX ������� (Python/ Jython, Django, ExtJS)"),
                new Organization("Enkata",
                        "enkata.com",
                        period, LocalDate.of(2007, 3, 1),
                        LocalDate.of(2008, 6, 1),
                        "����������� ��",
                        "���������� ���������� (Eclipse RCP) � ��������� (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) ������ ����������� J2EE ���������� (OLAP, Data mining)."),
                new Organization("Siemens AG",
                        "siemens.com",
                        period, LocalDate.of(2005, 1, 1),
                        LocalDate.of(2007, 2, 1),
                        "����������� ��",
                        "���������� �������������� ������, �������������� �����������, ���������� � ������� �� �� ��������� IN ��������� Siemens @vantage (Java, Unix)."),
                new Organization("Alcatel",
                        "alcatel.ru",
                        period, LocalDate.of(1997, 9, 1),
                        LocalDate.of(2005, 1, 1),
                        "������� �� ����������� � ������������ ������������",
                        "������������, �������, ��������� �� �������� ���������� ������� Alcatel 1000 S12 (CHILL, ASM)."))));
        r1.addSection(SectionType.EDUCATION, new OrganizationSection(Arrays.asList(
                new Organization("Coursera",
                        "coursera.org",
                        period, LocalDate.of(2013, 3, 1),
                        LocalDate.of(2013, 5, 1),
                        "Functional Programming Principles in Scala' by Martin Odersky",
                        ""),
                new Organization("Luxoft",
                        "luxoft.ru",
                        period, LocalDate.of(2011, 3, 1),
                        LocalDate.of(2011, 4, 1),
                        "���� '��������-��������������� ������ ��. �������������� ������������� �� UML.'",
                        ""),
                new Organization("Siemens AG",
                        "siemens.com",
                        period, LocalDate.of(2005, 1, 1),
                        LocalDate.of(2005, 4, 1),
                        "3 ������ �������� ��������� IN ����� (������)",
                        ""),
                new Organization("Alcatel",
                        "alcatel.ru",
                        period, LocalDate.of(1997, 9, 1),
                        LocalDate.of(1998, 3, 1),
                        "6 ������� �������� �������� ���������� ����� (������)",
                        ""),
                new Organization("�����-������������� ������������ ����������������� ����������� �������������� ����������, �������� � ������",
                        "itmo.ru",
                        period, LocalDate.of(1993, 9, 1),
                        LocalDate.of(1996, 7, 1),
                        "����������� (����������� �, �++)",
                        ""))));
        System.out.println("����� ������ �� ������: " + r1.getUuid());
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
}
