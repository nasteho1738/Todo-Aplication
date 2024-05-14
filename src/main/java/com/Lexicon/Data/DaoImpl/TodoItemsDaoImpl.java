package com.Lexicon.Data.DaoImpl;

import com.Lexicon.Data.TodoItemsDao;
import com.Lexicon.model.Person;
import com.sun.tools.javac.comp.Todo;

import java.util.Collection;

public class TodoItemsDaoImpl implements TodoItemsDao {

    private Collection collection;

    public TodoItemsDaoImpl(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean doneStatus) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int assigneeId) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodos() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
