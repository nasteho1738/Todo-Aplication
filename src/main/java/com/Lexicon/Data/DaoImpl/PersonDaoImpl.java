package com.Lexicon.Data.DaoImpl;

import com.Lexicon.Data.PersonDao;
import com.Lexicon.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {

    private Connection connection;

    public PersonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person create(Person person) {
        System.out.println("Creating new person: " + person);
        String query = "Insert into person (first_name, last_name) values (?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastNast());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()) {
                person.setPersonId(generatedKeys.getInt(1));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Person created: " + person);
        return person;
    }


    @Override
    public Collection<Person> findAll() {
        System.out.println("Fetching all persons");
        String query = "select * from person";
        Person person = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setFirstName(resultSet.getString("last_name"));
                person.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("Found " + person.size() + "person");
        return (Collection<Person>) person;
    }

    @Override
    public Optional<Person> findById(int id) {
        Person person = null;
        String query = "select * from person where person_id =?";

        try (PreparedStatement statement = connection.prepareStatement(query);
) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));

                person.setLastName(resultSet.getString("last_name"));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        System.out.println("Found person: " + person);

        return Optional.ofNullable(person);

    }

    @Override
    public Collection<Person> findByName(String name) {
        Collection<Person> people = new ArrayList<>();
        String query = "SELECT * FROM person WHERE CONCAT(first_name, ' ', last_name) LIKE ?";
        try(PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                System.out.println("Found person: " + person);
                people.add(person);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return people;

    }

    @Override
    public Person update(Person person) {

        String query = null;
        try (PreparedStatement statement = connection.prepareStatement(query);
        ) {
            query = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Deleting person with id: " + id);
        String query = "DELETE FROM person WHERE person_id = ?";
        int rowsAffected = 0;
        try (PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;
    }
}
