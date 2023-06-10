package hw4.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User implements Comparable<Teacher> {
    private String scienceDegree;

    public Teacher(Long id, String fullName, Integer age, String phoneNumber) {
        super(id, fullName, age, phoneNumber);
    }

    @Override
    public int compareTo(Teacher o) {
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
