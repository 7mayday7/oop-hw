package hw3;

import java.util.Comparator;
import java.util.Iterator;

public class StudentGroupService {

    private final StudentRepository studentRepository;


    public StudentGroupService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }


    public void printAll() {
        for (Student student : studentRepository.getStudentGroup()) {
            System.out.println(student);
        }
    }


    public void deleteStudent(String fullName) {
        Iterator<Student> iterator = studentRepository.getStudentGroup().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getFullName().equals(fullName)) {
                iterator.remove();
            }
        }
    }


    public void sortByFirstName() {
        Comparator<Student> comparator = Comparator.comparing(o -> o.getFullName().split(" ")[0]);
        studentRepository.getStudentGroup().getStudentsList().sort(comparator);
    }


    public void sortByLastName() {
        studentRepository.getStudentGroup().getStudentsList().sort(new StudentComparator());
    }
}
