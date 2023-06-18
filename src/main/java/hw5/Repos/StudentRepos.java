package hw5.Repos;

import hw5.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepos implements UserRepos<Student> {
    private static StudentRepos INSTANCE;

    public static StudentRepos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StudentRepos();
        }
        return INSTANCE;
    }

    private final List<Student> students;

    public StudentRepos() {
        students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void remove(String fullName) {
        for (Student student : students) {
            if (student.getFullName().equals(fullName)) {
                students.remove(student);
                return;
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = 0L;
        for (Student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;
    }
}
