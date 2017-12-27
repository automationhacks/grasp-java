/**
 * Write a class Student which keeps track of how many students it created.
 */
public class Student {
    public static Integer studentCount = 0;

    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;

        studentCount = studentCount + 1;
    }

    public static void main(String[] args) {
        for (Integer i=0; i < 10; i++) {
            Student s = new Student(i, "Student " + i);
        }

        System.out.println("Total number: " + Student.studentCount.toString());
    }
}