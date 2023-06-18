package hw5.Service.Init;

import hw5.Control.StudentClassControl;
import hw5.Control.StudentControl;
import hw5.Control.TeacherControl;
import hw5.Repos.StudentClassRepos;
import hw5.Repos.StudentRepos;
import hw5.Repos.TeacherRepos;
import hw5.Service.Randomizer.RndmStudClassGroup;
import hw5.Service.Team.StudentClassService;
import hw5.Service.User.StudService;
import hw5.Service.User.TeacherService;
import hw5.View.StudentClassView;
import hw5.View.StudentView;
import hw5.View.TeacherView;

import lombok.Data;
import lombok.Getter;

import java.io.IOException;

@Data
@Getter
public class Initializer {
    private final StudentRepos studentRepository;
    private final TeacherRepos teacherRepository;
    private final StudentClassRepos studentClassRepository;

    private final StudService studentService;
    private final TeacherService teacherService;
    private final StudentClassService studentClassService;
    private final RndmStudClassGroup studentClassGroupRandomizer;

    public final StudentView studentView;
    public final TeacherView teacherView;
    public final StudentClassView studentClassView;

    public Initializer() throws IOException {
        this.studentRepository = StudentRepos.getInstance();
        this.teacherRepository = TeacherRepos.getInstance();
        this.studentClassRepository = StudentClassRepos.getInstance();
        this.studentService = initStudentService();
        this.teacherService = initTeacherService();
        this.studentClassService = iniStudentClassService();
        this.studentView = initStudentView(studentService);
        this.teacherView = initTeacherView(teacherService);
        this.studentClassView = initStudentClassView(studentClassService);
        this.studentClassGroupRandomizer = new RndmStudClassGroup(this.studentClassService);
    }

    private static StudService initStudentService() throws IOException {
        return new StudService();
    }

    private static TeacherService initTeacherService() throws IOException {
        return new TeacherService();
    }

    private static StudentClassService iniStudentClassService() {
        return new StudentClassService();
    }

    private static StudentView initStudentView(StudService studentService) {
        StudentControl studentController = new StudentControl(studentService);
        return new StudentView(studentController);
    }

    private static TeacherView initTeacherView(TeacherService teacherService) {
        TeacherControl teacherController = new TeacherControl(teacherService);
        return new TeacherView(teacherController);
    }

    private static StudentClassView initStudentClassView(StudentClassService studentClassService) {
        StudentClassControl studentClassController = new StudentClassControl(studentClassService);
        return new StudentClassView(studentClassController);
    }
}
