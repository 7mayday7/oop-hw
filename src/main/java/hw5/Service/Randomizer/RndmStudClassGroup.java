package hw5.Service.Randomizer;

import hw5.Model.StudentClass;
import hw5.Repos.StudentClassRepos;
import hw5.Service.Team.StudentClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RndmStudClassGroup {
    private final Random random;

    StudentClassRepos studentClassRepository;
    StudentClass studentClass;
    StudentClassService studentClassService;

    public RndmStudClassGroup(StudentClassService studentClassService) {
        this.random = new Random();
        this.studentClassRepository = StudentClassRepos.getInstance();
        this.studentClassService = studentClassService;
    }

    public List<StudentClass> getAvailableStudentClasses() {
        List<StudentClass> studentClasses = new ArrayList<>();
        int freeTeacherSlots, freeStudentSlots;
        for (StudentClass studentClass : studentClassRepository.getAll()) {
            freeTeacherSlots = studentClass.getMaxTeachers() - studentClass.getTeacherRoster().size();
            freeStudentSlots = studentClass.getMaxStudents() - studentClass.getStudentRoster().size();
            if (freeTeacherSlots > 0
                    && studentClassService.getAvailableTeachers().size() > 0
                    || freeStudentSlots > 0
                    && studentClassService.getAvailableStudents().size() > 0) {
                studentClasses.add(studentClass);
            }
        }
        return studentClasses;
    }

    public void populateAllStudentClasses() {
        List<StudentClass> studentClasses = getAvailableStudentClasses();
        if (studentClasses.size() == 0) {
            System.out.println("(fillAll:) → все классы сформированны");
        }
        if (studentClasses.size() > 0) {
            do {
                studentClass = studentClasses.get(random.nextInt(studentClasses.size()));
                studentClassService.populateStudentClassById(studentClass.getId());
                studentClasses = getAvailableStudentClasses();
            } while (studentClasses.size() > 0);
        }
    }
}
