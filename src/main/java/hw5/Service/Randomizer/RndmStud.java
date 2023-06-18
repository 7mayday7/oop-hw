package hw5.Service.Randomizer;

import hw5.Service.DataReader.DataReader;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@EqualsAndHashCode(callSuper = true)
public class RndmStud extends DataReader {
    Random random;

    public RndmStud() throws IOException {
        this.random = new Random();
    }

    public List<String> getData() {
        List<String> studentDataList = new ArrayList<>();
        String fullName = "";
        int age = 0;
        String phoneNumber = "";
        int gender;

        gender = random.nextInt(2);
        if (gender == 0) {
            fullName = getLoadedWomenFirstNames().get(random.nextInt(getLoadedWomenFirstNames().size()))
                    + " "
                    + getLoadedWomenLastNames().get(random.nextInt(getLoadedWomenLastNames().size()));
            age = random.nextInt(16, 21);
            phoneNumber = RndmPhoneNumber.getPhoneNumber();
        }
        if (gender == 1) {
            fullName = getLoadedMenFirstNames().get(random.nextInt(getLoadedMenFirstNames().size()))
                    + " "
                    + getLoadedMenLastNames().get(random.nextInt(getLoadedMenLastNames().size()));
            age = random.nextInt(16, 21);
            phoneNumber = RndmPhoneNumber.getPhoneNumber();
        }
        studentDataList.add(fullName);
        studentDataList.add(String.valueOf(age));
        studentDataList.add(phoneNumber);


        return studentDataList;
    }
}
