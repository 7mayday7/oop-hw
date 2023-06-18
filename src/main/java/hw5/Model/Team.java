package hw5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Team {
    private final Long id;
    private String teamName;
    private int maxStudents;
    private int maxTeachers;
    private List<Student> studentRoster;
    private List<Teacher> teacherRoster;
}
