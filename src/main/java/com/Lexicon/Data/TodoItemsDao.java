package com.Lexicon.Data;

import com.Lexicon.model.Person;
import com.sun.tools.javac.comp.Todo;

import java.util.Collection;
import java.util.Optional;

public interface TodoItemsDao {
    Todo create(Todo todo);
    Collection<Todo> findAll();
    Optional<Todo> findById(int id);
    Collection<Todo> findByDoneStatus(boolean doneStatus);
    Collection<Todo> findByAssignee(int assigneeId);
    Collection<Todo> findByAssignee(Person assignee);
    Collection<Todo> findByUnassignedTodos();
    Todo update(Todo todo);
    boolean deleteById(int id);




}
