package hw5.Repos;

import hw5.Model.User;

import java.util.List;

public interface UserRepos<T extends User> {
    List<T> getAll();

    void add(T t);

    void remove(String name);

    Long getMaxId();
}
