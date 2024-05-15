package com.Lexicon.Data.DaoImpl;

import com.Lexicon.Data.TodoItemsDao;
import com.Lexicon.model.Person;
import com.sun.tools.javac.comp.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class TodoItemsDaoImpl implements TodoItemsDao {

    private Connection connection;
    private Object todo;

    public TodoItemsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Todo create(Todo todo) {
        String query = "insert into todo_items (title, description, done) values (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setBoolean(3, todo.isdone);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()) todo.retainAll(Collections.singleton(generatedKeys.getInt(1)));

        }catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("Todo created: " + todo);
        return todo;
    }

    @Override
    public Collection<Todo> findAll() {
        String query = "SELECT * FROM todo_items";
        Collection<Todo> todos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Found " + todos);
        return todos;
    }

    @Override
    public Optional<Todo> findById(int id) {
        String query = "SELECT * FROM todo_items WHERE id = ?";
        Todo todo = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = PreparedStatement.executeQuery();
            if (resultSet.next()) {
                todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Not found " + id);
        return Optional.ofNullable(todo);
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean doneStatus) {
        String query = "SELECT * FROM todo_items WHERE done = ?";
        Collection<Todo> todos = new ArrayList<>();
        Todo todo = new Todo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, doneStatus);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Found " + todos.size() + "Status " + doneStatus);
        return todos;
    }

    @Override
    public Collection<Todo> findByAssignee(int assigneeId) {
        String query = "SELECT ti.* FROM todo_items ti JOIN person p ON ti.assignee_id = p.id WHERE p.id = ?";
        Collection<Todo>todos = new ArrayList<>();
        Todo todo = new Todo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, assigneeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Found " + todos.size() + "Status " + assigneeId);
        return todos;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        String query = "SELECT ti.* FROM todo_items ti JOIN person p ON ti.assignee_id = p.id WHERE p.first_name = ? AND p.last_name = ?";
        Collection<Todo> todos = new ArrayList<>();
        Todo todo = new Todo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, assignee.getFirstName());
            preparedStatement.setString(2, assignee.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Found " + todos.size() + "Status " + assignee);
        return todos;
    }

    @Override
    public Collection<Todo> findByUnassignedTodos() {
        String query = "SELECT * FROM todo_items WHERE assignee_id IS NULL";
        Collection<Todo> todos = new ArrayList<>();
        Todo todo = new Todo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setDone(resultSet.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("found " + todos.size());
        return todos;
    }

    @Override
    public Todo update(Todo todo) {
        String query = "UPDATE todo_items SET title = ?, description = ?, done = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setBoolean(3, todo.isDone());
            preparedStatement.setInt(4, todo.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM todo_items WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
