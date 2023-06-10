package hw4.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Student extends User implements Comparable<Student> {
    private Double GPA;
    private String Supervisor;

    public Student(Long id, String fullName, Integer age, String phoneNumber) {
        super(id, fullName, age, phoneNumber);
    }

    @Override
    public int compareTo(Student o) {
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return String.format("%s %18s %2s %8s"
                , getId()
                , getFullName()
                , getAge()
                , getPhoneNumber());
    }
}
