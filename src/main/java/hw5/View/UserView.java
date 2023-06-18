package hw5.View;

import hw5.Model.User;

public interface UserView<T extends User> {
    void sendOnConsole(String sortType);  // GET request

    void create(String fullName, Integer age, String phoneNumber);  // POST request

    void createRandom(Integer quantity);

    void remove(String fullName);  // DELETE request

    void edit(String fullName, Integer age, String phoneNumber);  // PUT request
}
