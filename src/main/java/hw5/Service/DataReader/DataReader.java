package hw5.Service.DataReader;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataReader {

    private final List<String> loadedMenFirstNames;
    private final List<String> loadedMenLastNames;
    private final List<String> loadedWomenFirstNames;
    private final List<String> loadedWomenLastNames;
    private final List<String> fileNames;
    private final List<List<String>> listNames;
    private final List<String> studentClassNames;

    private final String pathToFiles = "./src/main/java/hw5/Data/";

    public DataReader() throws IOException {
        this.loadedMenFirstNames = new ArrayList<>();
        this.loadedMenLastNames = new ArrayList<>();
        this.loadedWomenFirstNames = new ArrayList<>();
        this.loadedWomenLastNames = new ArrayList<>();
        this.fileNames = new ArrayList<>();
        this.listNames = new ArrayList<>();
        this.studentClassNames = new ArrayList<>();

        fileNames.add("male_names.txt");
        listNames.add(loadedMenFirstNames);
        fileNames.add("male_surnames.txt");
        listNames.add(loadedMenLastNames);
        fileNames.add("female_names.txt");
        listNames.add(loadedWomenFirstNames);
        fileNames.add("female_surnames.txt");
        listNames.add(loadedWomenLastNames);
        fileNames.add("stud_class_titles.txt");
        listNames.add(studentClassNames);

        for (int i = 0; i < fileNames.size(); i++) {
            BufferedReader br = new BufferedReader(new FileReader(pathToFiles + fileNames.get(i)));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    listNames.get(i).add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
