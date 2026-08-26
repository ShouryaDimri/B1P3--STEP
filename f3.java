import java.util.Scanner;

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

    void allot(String name) {

        if (occupied < beds) {

            occupied++;

            System.out.println(
                name +
                " allotted to room " +
                roomNo
            );

        } else {

            System.out.println(
                "Room " + roomNo + " is full"
            );
        }
    }
}


public class f3 {

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
        String studentName
    ) {

        HostelRoom room =
            findAvailableRoom(rooms);

        // Null check prevents NullPointerException
        if (room != null) {

            room.allot(studentName);

        } else {

            System.out.println(
                "No rooms available for " +
                studentName
            );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        sc.nextLine();

        HostelRoom[] rooms =
            new HostelRoom[n];


        // Input room details
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


        // First student
        System.out.print(
            "\nEnter student name for allotment: "
        );

        String student1 = sc.nextLine();

        safeAllot(
            rooms,
            student1
        );


        // Second student
        System.out.print(
            "\nEnter another student name: "
        );

        String student2 = sc.nextLine();

        safeAllot(
            rooms,
            student2
        );


        sc.close();
    }
}