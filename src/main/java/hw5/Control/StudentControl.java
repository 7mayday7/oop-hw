package hw5.Control;

import hw5.Model.Student;
import hw5.Service.User.UserService;

import java.util.List;

public class StudentControl implements UserControl<Student> {
    public UserService<Student> studentService;

    public StudentControl(UserService<Student> studentService) {
        this.studentService = studentService;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        studentService.create(fullName, age, phoneNumber);
    }

    @Override
    public void createRandom(Integer quantity) {
        studentService.createRandom(quantity);
    }

    @Override
    public List<Student> getAllUsersSortedByFirstName() {
        return studentService.getAllUsersSortedByFirstName();
    }

    @Override
    public List<Student> getAllUsersSortedByLastName() {
        return studentService.getAllUsersSortedByLastName();
    }

    @Override
    public List<Student> getAllUsersSortedByAge() {
        return studentService.getAllUsersSortedByAge();
    }

    @Override
    public List<Student> getAllUsersSortedById() {
        return studentService.getAllUsersSortedById();
    }

    @Override
    public boolean remove(String fullName) {
        studentService.remove(fullName);
        return true;
    }

    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @Override
    public void edit(String fullName, Integer age, String phoneNumber) {
        studentService.edit(fullName, age, phoneNumber);
    }
}
