package com.Lexicon.Data;

import java.util.Collection;

public interface Entity<T> {

    T create(T entity);
    Collection<T> findAll();
    T findById(int id);
    Collection<T> findByName(String name);
    T update(T entity);
    boolean deleteById(int id);
}
