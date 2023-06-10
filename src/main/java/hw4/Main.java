package hw4;

import hw4.View.StudentView;
import hw4.View.TeacherView;
import hw4.View.SortType;
import hw4.Service.StudentService;
import hw4.Service.TeacherService;
import hw4.Repos.TeacherRepository;
import hw4.Repos.StudentRepository;
import hw4.Controller.StudentController;
import hw4.Controller.TeacherController;

public class Main {
    public static void main(String[] args) {
        StudentView studentView = getStudentView();
        TeacherView teacherView = getTeacherView();

        studentView.create("Иван Иванов", 27, "777-777");
        studentView.create("Олег Олегов", 30, "666-666");
        studentView.create("Петр Петров", 27, "999-999");

        studentView.sendOnConsole(SortType.AGE);

        teacherView.create("Денис Антонов", 17, "555-555");
        teacherView.create("Анна Николаева", 18, "333-333");
        teacherView.create("Анна Николаева", 18, "333-333");

        teacherView.sendOnConsole(SortType.ID);

        teacherView.edit("Елизавета Прокофьева", 25, "444-444");

        teacherView.sendOnConsole(SortType.ID);

        teacherView.create("Анна Николаева", 18, "333-333");
        teacherView.create("Анна Николаева", 18, "333-333");

        studentView.sendOnConsole(SortType.AGE);

    }

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }

    private static TeacherView getTeacherView() {
        TeacherRepository repository = new TeacherRepository();
        TeacherService service = new TeacherService(repository);
        TeacherController controller = new TeacherController(service);
        return new TeacherView(controller);
    }
}
