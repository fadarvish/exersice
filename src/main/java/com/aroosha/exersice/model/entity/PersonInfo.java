package com.aroosha.exersice.model.entity;

import javax.persistence.*;

@Entity
@Table(name="personinfo")
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int personId;
    private int documentId;

    public int getPersonId() {
        return personId;
    }

    public PersonInfo setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public int getDocumentId() {
        return documentId;
    }

    public PersonInfo setDocumentId(int documentId) {
        this.documentId = documentId;
        return this;
    }

    public int getId() {
        return id;
    }
}
