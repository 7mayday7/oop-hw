package hw3;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class StudentGroup implements Iterable<Student> {
    private final List<Student> studentsList;


    public StudentGroup() {
        studentsList = new ArrayList<>();
    }


    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(studentsList);
    }


    public void addStudent(Student student) {
        studentsList.add(student);
    }
}
