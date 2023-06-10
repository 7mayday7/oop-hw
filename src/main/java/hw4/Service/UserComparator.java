package hw4.Service;

import hw4.Model.User;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        String familyName1 = o1.getFullName().split("\\s+")[1];
        String familyName2 = o2.getFullName().split("\\s+")[1];
        return familyName1.compareTo(familyName2);
    }
}
