package com.urise.webapp.model;

public enum SelectionType {
    PERSONAL("Персональные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private final String title;

    SelectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
