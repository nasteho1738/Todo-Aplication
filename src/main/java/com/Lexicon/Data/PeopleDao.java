package com.Lexicon.Data;

import com.Lexicon.model.Person;

import java.util.Collection;
import java.util.Optional;

public interface PeopleDao {
    Person create(Person person);
    Collection<Person> findAll();
    Optional<Person> findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);

}
