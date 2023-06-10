package hw4.View;

import hw4.Model.Teacher;
import hw4.Controller.UserController;

import java.util.List;

public class TeacherView implements UserView<Teacher> {

    UserController<Teacher> controller;

    public TeacherView(UserController<Teacher> controller) {
        this.controller = controller;
    }


    @Override
    public void sendOnConsole(String sortType) {
        int separatorLength = 32;
        List<Teacher> teachers = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.ID -> controller.getAllUsersSortedById();
            case SortType.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case SortType.LASTNAME -> controller.getAllUsersSortedByLastName();
            case SortType.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (teachers == null) {
            System.out.println("teachers is null");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
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
