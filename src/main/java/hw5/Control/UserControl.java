package hw5.Control;

import hw5.Model.User;

import java.util.List;

public interface UserControl<T extends User> {
    void create(String fullName, Integer age, String phoneNumber);

    void createRandom(Integer quantity);

    List<T> getAllUsersSortedByFirstName();

    List<T> getAllUsersSortedByLastName();

    List<T> getAllUsersSortedByAge();

    List<T> getAllUsersSortedById();

    boolean remove(String fullName);

    List<T> getAll();

    void edit(String fullName, Integer age, String phoneNumber);
}