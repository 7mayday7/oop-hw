package hw5.Service.Iterator;

import hw5.Model.StudentClass;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudClassGroupIter implements Iterator<StudentClass> {
    private final List<StudentClass> studentClasses;
    private int position;

    public StudClassGroupIter(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    @Override
    public boolean hasNext() {
        return position < studentClasses.size();
    }

    @Override
    public StudentClass next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studentClasses.get(position++);
    }

    @Override
    public void remove() {
        studentClasses.remove(position - 1);
    }
}
