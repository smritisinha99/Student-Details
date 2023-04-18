// This is the Student class that defines the attributes of a student.
public class Student {
    // Instance members of Student class.
    private int prn;
    private String name;
    private String dob;
    private double marks;

    // Constructor to initialize the instance members of Student class.
    public Student(int prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // Getter methods for the instance members of Student class.
    public int getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
    }

    public void setDob(String dob) {
    }

    public void setMarks(double marks) {
    }
}