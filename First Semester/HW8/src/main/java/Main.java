import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        StudentChannel studentChannel = new StudentChannel(
                Paths.get("D:\\Projects\\Programming\\KFU" +
                        "\\itis_second_course\\First Semester" +
                        "\\HW8\\src\\main\\java\\students.txt"));
        studentChannel.writeStudent(new Student(
                "Azataadnotsad",
                1513412,
                928334,
                false
        ));
        Student student = studentChannel.readStudent();
        System.out.println(student.toString());
    }
}
