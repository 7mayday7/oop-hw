package hw5.View;

import hw5.Model.Team;

public interface TeamView<T extends Team> {
    void sendOnConsole(String sortType);  // GET request

    void sendOnConsole(String sortType, String fullName);  // GET request

    void create(String teamName);  // POST request

    void createAndPopulate(String teamName);

    void populateStudentClassById(Long id);

    void load();

    void remove(String fullName);  // DELETE request

    // edit // PUT request
    void addTeacher(Long teacherId, Long studentClassId);

    void addTeacher(String teacherName, Long studentClassId);

    void addStudent(Long studentId, Long studentClassId);

    void addStudent(String studentName, Long studentClassId);

    void setStudentClassTeacherLimitById(Long id, int limit);

    Long getStudentClassIdByUserName(String fullName);
}
