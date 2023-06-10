package hw4.Repos;

import hw4.Model.User;

import java.util.List;

public interface UserRepository<T extends User> {
    List<T> getAll();

    void add(T t);

    void remove(String name);

    Long getMaxId();
}
