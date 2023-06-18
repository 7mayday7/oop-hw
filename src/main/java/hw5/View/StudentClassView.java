package hw5.View;

import hw5.Control.TeamControll;
import hw5.Model.Student;
import hw5.Model.StudentClass;
import hw5.Model.Teacher;

import java.util.List;

public class StudentClassView implements TeamView<StudentClass> {
    TeamControll<StudentClass> controller;

    public StudentClassView(TeamControll<StudentClass> controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(String sortType) {
        int separatorLength = 39;
        List<StudentClass> studentClasses = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.TEAM_ID -> controller.getAllTeamsSortedById();
            case SortType.TEAM_NAME -> controller.getAllTeamsSortedByTeamName();
            default -> null;
        };
        if (studentClasses == null || studentClasses.size() < 1) {
            System.out.println("(DB:) → нет учебных групп");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        System.out.println("Учебные группы:");
        for (StudentClass studentClass : studentClasses) {
            System.out.println(studentClass);
        }
        System.out.println("-".repeat(separatorLength));
    }

    @Override
    public void sendOnConsole(String sortType, String fullName) {
        StudentClass studentClass = getStudentClassById(getStudentClassIdByUserName(fullName));
        int separatorLength = 39;
        System.out.println("-".repeat(separatorLength));
        System.out.println("Учебная группа:");
        System.out.println(getStudentClassById(getStudentClassIdByUserName(fullName)));
        System.out.println("Преподаватели:");
        for (Teacher teacher : getStudentClassTeachersList(studentClass)) {
            System.out.println(teacher);
        }
        System.out.println("Студенты:");
        for (Student student : getStudentClassStudentsList(studentClass)) {
            System.out.println(student);
        }
        System.out.println("-".repeat(separatorLength));
    }

    private List<Student> getStudentClassStudentsList(StudentClass studentClass) {
        return controller.getStudentClassStudentsList(studentClass);
    }

    private List<Teacher> getStudentClassTeachersList(StudentClass studentClass) {
        return controller.getStudentClassTeachersList(studentClass);
    }

    @Override
    public void create(String teamName) {
        controller.create(teamName);
    }

    @Override
    public void createAndPopulate(String teamName) {
        controller.createAndPopulate(teamName);
    }

    @Override
    public void populateStudentClassById(Long id) {
        controller.populateStudentClassById(id);
    }

    @Override
    public void load() {
        controller.load();
    }

    @Override
    public void remove(String teamName) {
        controller.remove(teamName);
    }

    @Override
    public void addTeacher(Long teacherId, Long studentClassId) {
        controller.addTeacher(teacherId, studentClassId);
    }

    @Override
    public void addTeacher(String teacherName, Long studentClassId) {
        controller.addTeacher(teacherName, studentClassId);
    }

    @Override
    public void addStudent(Long studentId, Long studentClassId) {
        controller.addStudent(studentId, studentClassId);
    }

    @Override
    public void addStudent(String studentName, Long studentClassId) {
        controller.addStudent(studentName, studentClassId);
    }

    @Override
    public void setStudentClassTeacherLimitById(Long id, int limit) {
        controller.setStudentClassTeacherLimitById(id, limit);
    }

    @Override
    public Long getStudentClassIdByUserName(String fullName) {
        return controller.getStudentClassIdByUserName(fullName);
    }

    public StudentClass getStudentClassById(Long id) {
        return controller.getStudentClassById(id);
    }
}
