package hw3;

public class Main {
    public static void main(String[] args) {

        StudentGroup group = new StudentGroup();
        StudentRepository repository = new StudentRepository(group);
        StudentGroupService service = new StudentGroupService(repository);
        StudentController controller = new StudentController(service);


        System.out.println("\nИсходный список: ");
        controller.addStudent(new Student(1L, "Иванов Орлов"));
        controller.addStudent(new Student(2L, "Анна Яковлева"));
        controller.addStudent(new Student(3L, "Ян Арбузов"));
        controller.printAll();


        System.out.println("\nСортировка по имени: ");
        controller.sortByFirstName();
        controller.printAll();


        System.out.println("\nСортировка по фамилии: ");
        controller.sortByLastName();
        controller.printAll();
    }
}
