package hw5.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Student extends User implements Comparable<Student> {
    Long team_id = null;

    public Student(Long id, String fullName, Integer age, String phoneNumber) {
        super(id, fullName, age, phoneNumber);
    }

    @Override
    public int compareTo(Student o) {
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return String.format("%3s %23s %2s %8s"
                , getId()
                , getFullName()
                , getAge()
                , getPhoneNumber());
    }
}
