package hw5.Service.Iterator;

import hw5.Model.Student;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudGroupIter implements Iterator<Student> {
    private final List<Student> studentList;
    private int position;

    public StudGroupIter(List<Student> studentsList) {
        this.studentList = studentsList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studentList.get(position++);
    }

    @Override
    public void remove() {
        studentList.remove(position - 1);
    }
}
