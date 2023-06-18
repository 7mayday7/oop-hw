package hw5.Service.DataReader;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentClassesLoader extends DataReader {
    List<String> studentClasses;

    public StudentClassesLoader() throws IOException {
        this.studentClasses = getStudentClassNames();
    }

    public List<String> getData() {
        return this.studentClasses;
    }
}
