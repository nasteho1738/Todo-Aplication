package com.Lexicon.model;

public class Person {
    private int personId;
    private String firstName;
    private String lastNast;

    public Person() {
        this.personId = personId;
        this.firstName = firstName;
        this.lastNast = lastNast;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNast() {
        return lastNast;
    }

    public void setLastNast(String lastNast) {
        this.lastNast = lastNast;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastNast='" + lastNast + '\'' +
                '}';
    }

    public void setId(int personId) {
    }

    public void add(Person person) {
    }

    public String size() {
        return null;
    }

    public void setLastName(String lastName) {
    }

    public String getLastName() {


        return null;
    }

    public int getId() {
        return Integer.parseInt(null);
    }
}

