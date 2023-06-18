package hw5.Service.User;

import hw5.Model.Student;
import hw5.Model.User;
import hw5.Repos.StudentRepos;
import hw5.Repos.UserRepos;
import hw5.Service.Comparator.UserComparator;
import hw5.Service.Randomizer.RndmStud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudService implements UserService<Student> {
    private final UserRepos<Student> studentRepository;
    private final RndmStud studentRandomizer;

    public StudService() throws IOException {
        this.studentRepository = StudentRepos.getInstance();
        this.studentRandomizer = new RndmStud();
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        for (Student student : studentRepository.getAll()) {
            if (student.getFullName().equals(fullName)) {
                System.out.println("(createStudent:)'" + fullName + "' → такой записи нет");
                return;
            }
        }
        Long id = studentRepository.getMaxId() + 1;
        Student student = new Student(id, fullName, age, phoneNumber);
        studentRepository.add(student);
    }

    @Override
    public void createRandom(Integer quantity) {
        for (int i = 0; i < quantity; i++) {
            create(studentRandomizer.getData().get(0),
                    Integer.valueOf(studentRandomizer.getData().get(1)),
                    studentRandomizer.getData().get(2)
            );
        }
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public List<Student> getAllUsersSortedByFirstName() {
        List<Student> students = studentRepository.getAll();
        Collections.sort(students);

        return students;
    }

    @Override
    public List<Student> getAllUsersSortedByLastName() {
        List<Student> students = studentRepository.getAll();
        students.sort(new UserComparator<>());

        return students;
    }

    @Override
    public List<Student> getAllUsersSortedByAge() {
        List<Student> students = studentRepository.getAll();
        students.sort((Comparator.comparing(User::getAge)));

        return students;
    }

    @Override
    public List<Student> getAllUsersSortedById() {
        List<Student> students = studentRepository.getAll();
        students.sort((Comparator.comparing(User::getId)));

        return students;
    }

    @Override
    public void remove(String fullName) {
        studentRepository.remove(fullName);
    }

    @Override
    public void edit(String fullName, Integer age, String phoneNumber) {
        for (Student student : studentRepository.getAll()) {
            if (student.getFullName().equals(fullName)) {
                System.out.println("(editStudent:)'" + fullName + "' → найдено");
                student.setAge(age);
                student.setPhoneNumber(phoneNumber);
                System.out.println("(editStudent:) +++ update field age and phoneNumber +++");
                return;
            }
        }
        System.out.println("(editStudent:)'" + fullName + "' → такой записи нет");
    }

    @Override
    public List<Student> getAvailableUsers() {
        List<Student> studentList = new ArrayList<>();
        for (Student student : studentRepository.getAll()) {
            if (student.getTeam_id() == null) {
                studentList.add(student);
            }
        }
        return studentList;
    }
}
