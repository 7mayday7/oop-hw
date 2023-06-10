package hw4.View;

import hw4.Model.Student;
import hw4.Controller.UserController;

import java.util.List;

public class StudentView implements UserView<Student> {
    UserController<Student> controller;

    public StudentView(UserController<Student> controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(String sortType) {
        int separatorLength = 32;
        List<Student> students = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.ID -> controller.getAllUsersSortedById();
            case SortType.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case SortType.LASTNAME -> controller.getAllUsersSortedByLastName();
            case SortType.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (students == null) {
            System.out.println("students is null");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-".repeat(separatorLength));
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        controller.create(fullName, age, phoneNumber);
    }

    @Override
    public void remove(String fullName) {
        controller.remove(fullName);
    }

    @Override
    public void edit(String fullName, Integer age, String phoneNumber) {
        controller.edit(fullName, age, phoneNumber);
    }
}
