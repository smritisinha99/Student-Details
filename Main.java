/*Name: Smriti Sinha
PRN: 21070126090
Branch: AI/ML-B1
 */

import java.util.Scanner;
public class Main {
    // Array of Student objects to store the information of multiple students.
    static Student[] students = new Student[10];
    static int count = 0;

    // Function to add a new student.
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PRN:");
        int prn = sc.nextInt();
        System.out.println("Enter Name:");
        String name = sc.next();
        System.out.println("Enter Date of Birth (dd/mm/yyyy):");
        String dob = sc.next();
        System.out.println("Enter Marks:");
        double marks = sc.nextDouble();

        // Create a new Student object and add it to the array of students.
        students[count] = new Student(prn, name, dob, marks);
        count++;
        System.out.println("Student added successfully!");
    }

    // Function to display all the students in the array.
    public static void displayStudents() {
        if (count == 0) {
            System.out.println("No students added yet!");
            return;
        }

        System.out.println("PRN\tName\t\tDate of Birth\t\tMarks");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println(s.getPrn() + "\t" + s.getName() + "\t\t" + s.getDob() + "\t\t" + s.getMarks());
        }
    }

    // Function to search for a student by PRN.
    public static void searchByPrn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PRN to search:");
        int prn = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].getPrn() == prn) {
                Student s = students[i];
                System.out.println("Student found!");
                System.out.println("PRN\tName\t\tDate of Birth\t\tMarks");
                System.out.println(s.getPrn() + "\t" + s.getName() + "\t\t" + s.getDob() + "\t\t" + s.getMarks());
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Function to search for a student by Name.
    public static void searchByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name to search:");
        String name = sc.next();

        for (int i = 0; i < count; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                Student s = students[i];
                System.out.println("Student found!");
                System.out.println("PRN\tName\t\tDate of Birth\t\tMarks");
                System.out.println(s.getPrn() + "\t" + s.getName() + "\t\t" + s.getDob() + "\t\t" + s.getMarks());
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Function to search for a student by position in the array.
    public static void searchByPosition() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Position to search:");
        int pos = sc.nextInt();

        if (pos >= count) {
            System.out.println("Invalid position!");
            return;
        }

        Student s = students[pos];
        System.out.println("Student found!");
        System.out.println("PRN\tName\t\tDate of Birth\t\tMarks");
        System.out.println(s.getPrn() + "\t" + s.getName() + "\t\t" + s.getDob() + "\t\t" + s.getMarks());
    }

    // Function to update/edit a student's information.
    public static void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PRN to update:");
        int prn = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].getPrn() == prn) {
                System.out.println("Enter new Name (Leave blank to keep existing):");
                String name = sc.nextLine().trim();
                if (!name.isEmpty()) {
                    students[i].setName(name);
                }

                System.out.println("Enter new Date of Birth (Leave blank to keep existing):");
                String dob = sc.nextLine().trim();
                if (!dob.isEmpty()) {
                    students[i].setDob(dob);
                }

                System.out.println("Enter new Marks (Enter -1 to keep existing):");
                double marks = sc.nextDouble();
                if (marks != -1) {
                    students[i].setMarks(marks);
                }

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Function to delete a student.
    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PRN to delete:");
        int prn = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].getPrn() == prn) {
                // Shift the remaining elements one position to the left.
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                count--;
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n***** MENU *****");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update/Edit Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByPrn();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    searchByPosition();
                    break;
                case 6:
                    updateStudent();
                    break;
                case 7:
                    deleteStudent();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}