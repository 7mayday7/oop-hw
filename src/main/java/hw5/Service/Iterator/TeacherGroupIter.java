package hw5.Service.Iterator;

import hw5.Model.Teacher;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TeacherGroupIter implements Iterator<Teacher> {
    private final List<Teacher> teacherList;
    private int position;

    public TeacherGroupIter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public boolean hasNext() {
        return position < teacherList.size();
    }

    @Override
    public Teacher next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return teacherList.get(position++);
    }

    @Override
    public void remove() {
        teacherList.remove(position - 1);
    }
}
