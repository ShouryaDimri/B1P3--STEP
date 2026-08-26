import java.util.Scanner;

class FeeAccount {

    private String regNo;
    private double totalFee;
    private double amountPaid;

    FeeAccount(
        String regNo,
        double totalFee,
        double amountPaid
    ) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    void pay(double amount) {

        if (amount <= 0) {
            System.out.println(
                "Payment rejected: amount must be positive"
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


// Child class
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


// Child class
class ScholarshipFeeAccount extends FeeAccount {

    private double scholarshipPercent;

    ScholarshipFeeAccount(
        String regNo,
        double totalFee,
        double amountPaid,
        double scholarshipPercent
    ) {
        super(regNo, totalFee, amountPaid);

        this.scholarshipPercent = scholarshipPercent;
    }

    double effectiveDue() {

        double due = getDue();

        return due -
            (due * scholarshipPercent / 100);
    }
}


public class f2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------
        // Plain Fee Account
        // -------------------------

        System.out.println("PLAIN FEE ACCOUNT");

        System.out.print("Enter registration number: ");
        String plainReg = sc.nextLine();

        System.out.print("Enter total fee: ");
        double plainFee = sc.nextDouble();

        System.out.print("Enter amount already paid: ");
        double plainPaid = sc.nextDouble();


        FeeAccount plain =
            new FeeAccount(
                plainReg,
                plainFee,
                plainPaid
            );


        System.out.print("Enter new payment: ");
        double plainPayment = sc.nextDouble();

        plain.pay(plainPayment);


        // -------------------------
        // Hostel Fee Account
        // -------------------------

        System.out.println("\nHOSTEL FEE ACCOUNT");

        System.out.print("Enter registration number: ");
        sc.nextLine();
        String hostelReg = sc.nextLine();

        System.out.print("Enter total fee: ");
        double hostelFee = sc.nextDouble();

        System.out.print("Enter amount already paid: ");
        double hostelPaid = sc.nextDouble();


        HostelFeeAccount hostel =
            new HostelFeeAccount(
                hostelReg,
                hostelFee,
                hostelPaid
            );


        System.out.print(
            "Enter amount to pay in two installments: "
        );

        double installmentAmount = sc.nextDouble();

        hostel.payInTwoInstallments(
            installmentAmount
        );


        // -------------------------
        // Scholarship Account
        // -------------------------

        System.out.println("\nSCHOLARSHIP FEE ACCOUNT");

        System.out.print("Enter registration number: ");
        sc.nextLine();
        String scholarshipReg = sc.nextLine();

        System.out.print("Enter total fee: ");
        double scholarshipFee = sc.nextDouble();

        System.out.print("Enter amount already paid: ");
        double scholarshipPaid = sc.nextDouble();

        System.out.print("Enter scholarship percentage: ");
        double scholarshipPercent = sc.nextDouble();


        ScholarshipFeeAccount scholarship =
            new ScholarshipFeeAccount(
                scholarshipReg,
                scholarshipFee,
                scholarshipPaid,
                scholarshipPercent
            );


        System.out.print(
            "Enter new payment: "
        );

        double scholarshipPayment =
            sc.nextDouble();

        scholarship.pay(scholarshipPayment);


        // -------------------------
        // instanceof
        // -------------------------

        FeeAccount[] accounts = {
            plain,
            hostel,
            scholarship
        };

        System.out.println("\n--- Account Details ---");

        for (FeeAccount account : accounts) {

            if (account instanceof ScholarshipFeeAccount) {

                ScholarshipFeeAccount s =
                    (ScholarshipFeeAccount) account;

                System.out.println(
                    "Scholarship account effective due: Rs " +
                    s.effectiveDue()
                );

            } else if (account instanceof HostelFeeAccount) {

                HostelFeeAccount h =
                    (HostelFeeAccount) account;

                System.out.println(
                    "Hostel account due: Rs " +
                    h.getDue()
                );

            } else {

                System.out.println(
                    "Plain account due: Rs " +
                    account.getDue()
                );
            }
        }

        sc.close();
    }
}