package com.Lexicon;

import com.Lexicon.Data.DaoImpl.PersonDaoImpl;
import com.Lexicon.Data.DaoImpl.TodoItemsDaoImpl;
import com.Lexicon.Data.PersonDao;
import com.Lexicon.Data.TodoItemsDao;
import com.sun.tools.javac.comp.Todo;

import java.sql.Connection;

public class App {

    public static void main(String[] args )
    {
        Connection Connection;
        TodoItemsDao todoItemsDao = new TodoItemsDaoImpl(Connection);
            PersonDao personDao = new PersonDaoImpl(Connection);
            Todo todo = new Todo();
            todo.setTitle("Buy groceries");
            todo.setDescription("Milk, eggs, bread");
            todo.setDone(false);
            Todo createdTodo = todoItemsDao.create(todo);
            System.out.println("Created Todo: " + createdTodo);

        }
    }
