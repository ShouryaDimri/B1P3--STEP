import java.util.Scanner;

class FeeAccount {

    private String regNo;
    private double totalFee;
    private double amountPaid;

    FeeAccount(String regNo, double totalFee, double amountPaid) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    void pay(double amount) {

        if (amount <= 0) {
            System.out.println(
                "Payment rejected for " + regNo
            );
            return;
        }

        amountPaid += amount;

        if (amountPaid > totalFee) {
            amountPaid = totalFee;
        }
    }

    double getDue() {
        return totalFee - amountPaid;
    }
}


// Inheritance
class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(
        String regNo,
        double totalFee,
        double amountPaid
    ) {
        super(regNo, totalFee, amountPaid);
    }

    void payInTwoInstallments(double amount) {

        double installment = amount / 2;

        pay(installment);
        pay(installment);
    }
}


// Hostel Room
class HostelRoom {

    String roomNo;
    int beds;
    int occupied;

    HostelRoom(
        String roomNo,
        int beds,
        int occupied
    ) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    void allot(String studentName) {

        if (occupied < beds) {

            occupied++;

            System.out.println(
                studentName +
                " allotted to room " +
                roomNo
            );
        }
    }
}


// F5 SrmStudent
class SrmStudent {

    String name;
    String regNo;

    // Composition
    HostelFeeAccount feeAccount;
    HostelRoom room;

    // Static counter
    static int totalStudents = 0;

    SrmStudent(
        String name,
        String regNo,
        HostelFeeAccount feeAccount
    ) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;

        // Initially no room
        this.room = null;

        totalStudents++;
    }

    String fullStatus() {

        String roomNumber;

        if (room == null) {
            roomNumber = "unallotted";
        } else {
            roomNumber = room.roomNo;
        }

        return name +
               " | Due: Rs " +
               feeAccount.getDue() +
               " | Room: " +
               roomNumber;
    }
}


public class f5 {

    static HostelRoom findAvailableRoom(
        HostelRoom[] rooms
    ) {

        for (HostelRoom room : rooms) {

            if (room != null &&
                room.occupied < room.beds) {

                return room;
            }
        }

        return null;
    }


    static void safeAllot(
        HostelRoom[] rooms,
        SrmStudent student
    ) {

        HostelRoom room =
            findAvailableRoom(rooms);

        if (room != null) {

            room.allot(student.name);

            student.room = room;

        } else {

            System.out.println(
                "No rooms available for " +
                student.name
            );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // =========================
        // ROOMS
        // =========================

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        sc.nextLine();

        HostelRoom[] rooms =
            new HostelRoom[n];

        for (int i = 0; i < n; i++) {

            System.out.println(
                "\nRoom " + (i + 1)
            );

            System.out.print("Enter room number: ");
            String roomNo = sc.nextLine();

            System.out.print("Enter number of beds: ");
            int beds = sc.nextInt();

            System.out.print("Enter occupied beds: ");
            int occupied = sc.nextInt();

            sc.nextLine();

            rooms[i] =
                new HostelRoom(
                    roomNo,
                    beds,
                    occupied
                );
        }


        // =========================
        // STUDENTS
        // =========================

        System.out.print(
            "\nEnter number of students: "
        );

        int studentCount = sc.nextInt();
        sc.nextLine();

        SrmStudent[] students =
            new SrmStudent[studentCount];


        for (int i = 0; i < studentCount; i++) {

            System.out.println(
                "\n===== Student " +
                (i + 1) +
                " ====="
            );

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print(
                "Enter registration number: "
            );

            String regNo = sc.nextLine();

            System.out.print(
                "Enter total hostel fee: "
            );

            double totalFee = sc.nextDouble();

            System.out.print(
                "Enter amount already paid: "
            );

            double amountPaid = sc.nextDouble();

            sc.nextLine();


            HostelFeeAccount feeAccount =
                new HostelFeeAccount(
                    regNo,
                    totalFee,
                    amountPaid
                );


            students[i] =
                new SrmStudent(
                    name,
                    regNo,
                    feeAccount
                );
        }


        // =========================
        // PAYMENTS
        // =========================

        System.out.println(
            "\n===== PAYMENT SECTION ====="
        );

        for (SrmStudent student : students) {

            System.out.println(
                "\nStudent: " + student.name
            );

            System.out.print(
                "Enter payment amount: "
            );

            double payment = sc.nextDouble();

            student.feeAccount.pay(payment);
        }


        // =========================
        // ROOM ALLOTMENT
        // =========================

        System.out.println(
            "\n===== ROOM ALLOTMENT ====="
        );

        for (SrmStudent student : students) {

            System.out.print(
                "Allot room to " +
                student.name +
                "? (yes/no): "
            );

            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {

                safeAllot(
                    rooms,
                    student
                );
            }
        }


        // =========================
        // FINAL STATUS
        // =========================

        System.out.println(
            "\n===== FINAL STATUS ====="
        );

        for (SrmStudent student : students) {

            System.out.println(
                student.fullStatus()
            );
        }


        System.out.println(
            "Total students: " +
            SrmStudent.totalStudents
        );

        sc.close();
    }
}