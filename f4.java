import java.util.Scanner;


// -------------------------
// BROKEN VERSION
// -------------------------
/* 
class BrokenSrmStudent {

    static String name;
    static String regNo;
    static int attendance;

    BrokenSrmStudent(
        String name,
        String regNo,
        int attendance
    ) {
        BrokenSrmStudent.name = name;
        BrokenSrmStudent.regNo = regNo;
        BrokenSrmStudent.attendance = attendance;
    }
}
*/

// -------------------------
// FIXED VERSION
// -------------------------

class SrmStudent {

    // Instance fields
    String name;
    String regNo;
    int attendance;

    // Static fields
    static String university =
        "SRM Institute of Science and Technology";

    static int admissionCount = 0;


    SrmStudent(
        String name,
        int attendance
    ) {

        this.name = name;
        this.attendance = attendance;

        admissionCount++;

        this.regNo =
            "RA2311003010" +
            admissionCount;
    }


    void printIdCard() {

        System.out.println(
            name + " | " +
            regNo + " | " +
            attendance + "%"
        );
    }


    static void printTotalAdmissions() {

        System.out.println(
            "Students admitted so far: " +
            admissionCount
        );
    }
}


public class f4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // =================================
        // BROKEN VERSION
        // =================================

        System.out.println(
            "===== BROKEN VERSION ====="
        );

        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();

        System.out.print(
            "Enter first student registration number: "
        );
        String reg1 = sc.nextLine();

        System.out.print(
            "Enter first student attendance: "
        );
        int attendance1 = sc.nextInt();

        sc.nextLine();


        System.out.print(
            "\nEnter second student name: "
        );
        String name2 = sc.nextLine();

        System.out.print(
            "Enter second student registration number: "
        );
        String reg2 = sc.nextLine();

        System.out.print(
            "Enter second student attendance: "
        );
        int attendance2 = sc.nextInt();

        sc.nextLine();


        BrokenSrmStudent student1 =
            new BrokenSrmStudent(
                name1,
                reg1,
                attendance1
            );

        BrokenSrmStudent student2 =
            new BrokenSrmStudent(
                name2,
                reg2,
                attendance2
            );


        System.out.println(
            "\nFirst student name: " +
            student1.name
        );

        System.out.println(
            "Second student name: " +
            student2.name
        );

        System.out.println(
            "Because name is static, the second student "
            + "overwrote the first student's data."
        );


        // =================================
        // FIXED VERSION
        // =================================

        System.out.println(
            "\n===== FIXED VERSION ====="
        );


        System.out.print(
            "Enter first student name: "
        );
        String fixedName1 = sc.nextLine();

        System.out.print(
            "Enter first student attendance: "
        );
        int fixedAttendance1 = sc.nextInt();

        sc.nextLine();


        System.out.print(
            "Enter second student name: "
        );
        String fixedName2 = sc.nextLine();

        System.out.print(
            "Enter second student attendance: "
        );
        int fixedAttendance2 = sc.nextInt();


        SrmStudent fixedStudent1 =
            new SrmStudent(
                fixedName1,
                fixedAttendance1
            );

        SrmStudent fixedStudent2 =
            new SrmStudent(
                fixedName2,
                fixedAttendance2
            );


        System.out.println(
            "\nStudent 1:"
        );

        fixedStudent1.printIdCard();


        System.out.println(
            "Student 2:"
        );

        fixedStudent2.printIdCard();


        SrmStudent.printTotalAdmissions();


        sc.close();
    }
}