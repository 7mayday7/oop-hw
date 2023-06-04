package hw3;

public class StudentController {
    public StudentGroupService studentGroupService;


    public StudentController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }


    public void printAll() {
        studentGroupService.printAll();
    }


    public boolean deleteStudent(String fullName) {
        studentGroupService.deleteStudent(fullName);
        return true;
    }


    public void addStudent(Student student) {
        studentGroupService.addStudent(student);
    }


    public void sortByFirstName() {
        studentGroupService.sortByFirstName();
    }


    public void sortByLastName() {
        studentGroupService.sortByLastName();
    }
}
