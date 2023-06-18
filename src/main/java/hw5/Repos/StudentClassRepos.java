package hw5.Repos;

import hw5.Model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class StudentClassRepos implements TeamRepos<StudentClass> {
    private static StudentClassRepos INSTANCE;

    public static StudentClassRepos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StudentClassRepos();
        }
        return INSTANCE;
    }

    private final List<StudentClass> studentClasses;

    public StudentClassRepos() {
        this.studentClasses = new ArrayList<>();

    }

    @Override
    public List<StudentClass> getAll() {
        return studentClasses;
    }

    @Override
    public void add(StudentClass aStudentClass) {
        studentClasses.add(aStudentClass);
    }

    @Override
    public void remove(String teamName) {
        for (StudentClass studentClass : studentClasses) {
            if (studentClass.getTeamName().equals(teamName)) {
                studentClasses.remove(studentClass);
                return;
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = 0L;
        for (StudentClass studentClass : studentClasses) {
            if (studentClass.getId() > maxId) {
                maxId = studentClass.getId();
            }
        }
        return maxId;
    }
}
