package hw5.View;

import hw5.Model.Student;
import hw5.Control.UserControl;


import java.util.List;

public class StudentView implements UserView<Student> {
    UserControl<Student> controller;

    public StudentView(UserControl<Student> controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(String sortType) {
        int separatorLength = 39;
        List<Student> students = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.ID -> controller.getAllUsersSortedById();
            case SortType.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case SortType.LASTNAME -> controller.getAllUsersSortedByLastName();
            case SortType.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (students == null || students.size() < 1) {
            System.out.println("(DB:) → нет студентов");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        System.out.println("Студенты:");
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
    public void createRandom(Integer quantity) {
        controller.createRandom(quantity);
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
