package hw5;

import hw5.Service.Init.Initializer;
import hw5.Service.Randomizer.RndmStudClassGroup;
import hw5.View.SortType;
import hw5.View.StudentClassView;
import hw5.View.StudentView;
import hw5.View.TeacherView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Initializer init = new Initializer();
        RndmStudClassGroup studentClassGroupRandomizer = init.getStudentClassGroupRandomizer();
        StudentView studentView = init.studentView;
        TeacherView teacherView = init.teacherView;
        StudentClassView classView = init.studentClassView;

        studentView.createRandom(12);
        studentView.sendOnConsole(SortType.ID);
        teacherView.createRandom(3);
        teacherView.sendOnConsole(SortType.ID);

        classView.createAndPopulate("Учебная группа №1");
        classView.sendOnConsole(SortType.TEAM_ID);

        classView.setStudentClassTeacherLimitById(1L, 2);
        classView.sendOnConsole(SortType.TEAM_ID);

        classView.load();
        classView.sendOnConsole(SortType.TEAM_ID);

        studentView.create("Анна Каренина", 35, "999-999");
        studentView.createRandom(300);
        teacherView.createRandom(7);

        studentClassGroupRandomizer.populateAllStudentClasses();
        classView.sendOnConsole(SortType.TEAM_ID);

        classView.sendOnConsole(SortType.NONE, "Анна Каренина");
    }

}