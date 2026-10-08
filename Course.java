public class Course {
    private String courseName;
    private String[] students = new String[2]; // initial capacity
    private int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }

    public void addStudent(String student) {
        if (numberOfStudents == students.length) {
            String[] bigger = new String[students.length * 2];
            for (int i = 0; i < numberOfStudents; i++) {
                bigger[i] = students[i];
            }
            students = bigger;
        }
        students[numberOfStudents++] = student;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1]; // shift left
                }
                students[--numberOfStudents] = null;
                return;
            }
        }
    }

    public String[] getStudents() {
        String[] result = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            result[i] = students[i];
        }
        return result;
    }

    public int getNumberOfStudents() { return numberOfStudents; }

    public static void main(String[] args) {
        Course c = new Course("Java");
        c.addStudent("Ali"); c.addStudent("Hodan"); c.addStudent("Abdi");
        c.dropStudent("Hodan");
        System.out.println(c.getNumberOfStudents() + " -> " + String.join(", ", c.getStudents()));
    }
}
