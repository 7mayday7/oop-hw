package hw5.Repos;

import hw5.Model.Team;

import java.util.List;

public interface TeamRepos<T extends Team> {
    List<T> getAll();

    void add(T t);

    void remove(String teamName);

    Long getMaxId();
}
