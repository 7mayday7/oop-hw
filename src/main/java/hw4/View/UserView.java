package hw4.View;

import hw4.Model.User;

public interface UserView<T extends User> {
    void sendOnConsole(String sortType);

    void create(String fullName, Integer age, String phoneNumber);

    void remove(String fullName);

    void edit(String fullName, Integer age, String phoneNumber);
}
