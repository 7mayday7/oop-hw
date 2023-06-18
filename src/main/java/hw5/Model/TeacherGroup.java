package hw5.Model;

import lombok.Getter;
import lombok.ToString;
import hw5.Service.Iterator.TeacherGroupIter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class TeacherGroup implements Iterable<Teacher> {
    private final List<Teacher> teachersList;

    public TeacherGroup() {
        this.teachersList = new ArrayList<>();
    }

    @Override
    public Iterator<Teacher> iterator() {
        return new TeacherGroupIter(teachersList);
    }
}
