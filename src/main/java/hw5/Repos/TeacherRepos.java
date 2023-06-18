package hw5.Repos;

import hw5.Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepos implements UserRepos<Teacher> {
    private static TeacherRepos INSTANCE;

    public static TeacherRepos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeacherRepos();
        }
        return INSTANCE;
    }

    private final List<Teacher> teachers;

    public TeacherRepos() {
        teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void remove(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getFullName().equals(name)) {
                teachers.remove(teacher);
                return;
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getId() > maxId) {
                maxId = teacher.getId();
            }
        }
        return maxId;
    }
}
