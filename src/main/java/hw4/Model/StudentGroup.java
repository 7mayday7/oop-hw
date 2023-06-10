package hw4.Model;

import hw4.Service.StudentGroupIterator;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
//@Data
public class StudentGroup implements Iterable<Student> {
    private final List<Student> studentsList;

    public StudentGroup() {
        studentsList = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(studentsList);
    }
}
