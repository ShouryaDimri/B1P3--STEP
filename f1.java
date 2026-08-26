import java.util.Scanner;

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    // Constructor
    SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    // Update attendance
    void addAttendanceUpdate(int newAttendance) {
        attendance = newAttendance;
    }

    // Instance method because it checks ONE student's attendance
    boolean isEligible() {
        return attendance >= 75;
    }

    // Static because it calculates for the WHOLE class
    static double classAverage(SrmStudent[] students) {
        int sum = 0;

        for (SrmStudent student : students) {
            sum += student.attendance;
        }

        return (double) sum / students.length;
    }
}

public class f1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SrmStudent[] students = new SrmStudent[5];

        System.out.println("Enter details of 5 students:");

        for (int i = 0; i < 5; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter registration number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter attendance: ");
            int attendance = sc.nextInt();

            sc.nextLine(); // consume newline

            students[i] =
                new SrmStudent(name, regNo, attendance);
        }

        System.out.println("\n--- Attendance Report ---");

        for (SrmStudent student : students) {

            if (student.isEligible()) {
                System.out.println(
                    student.name + " - " +
                    student.attendance + "% - Eligible"
                );
            } else {
                System.out.println(
                    student.name + " - " +
                    student.attendance + "% - Detained"
                );
            }
        }

        System.out.println(
            "\nClass average: " +
            SrmStudent.classAverage(students) +
            "%"
        );

        sc.close();
    }
}