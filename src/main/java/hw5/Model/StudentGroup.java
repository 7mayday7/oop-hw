package hw5.Model;

import lombok.Getter;
import lombok.ToString;

import hw5.Service.Iterator.StudGroupIter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class StudentGroup implements Iterable<Student> {
    private final List<Student> studentsList;

    public StudentGroup() {
        this.studentsList = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudGroupIter(studentsList);
    }
}
