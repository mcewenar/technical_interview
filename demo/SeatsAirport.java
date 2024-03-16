import java.util.Scanner;


public class SeatsAirport {

    static int seats[] = new int[11];
    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Welcome to X airlines");

        while(true) {
            System.out.println("Please select an option:");
            System.out.println("1. View available seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: //Display seats
                    displaySeats();
                    break;
                case 2: //Reserve seats
                    reserveSeat();
                    break;
                case 3:
                    System.out.println("Byebye");
                    System.exit(0);
            }
        }

    }

    public static void reserveSeat() {
        System.out.println("Enter seat number to reserve");

        int seat = sc.nextInt();
        if(seats[seat] == 0) {
            seats[seat] = 1;
            System.out.println("Seat " + seat +
                    " reserved succesfully");
        } else {
            System.out.println("Seat " + seat
                    +"is already reserved");
        }
    }

    public static void displaySeats() {
        System.out.println("Seats: ");
        for(int i = 1; i <= 10; i++) {
            System.out.println("Seat "+i+ ": "+
                    (seats[i]== 0? "Available": "reserved"));
        }
    }



    public static void main(String[] args) {
        mainMenu();
    }

    // @Test
    // void addition() {
    //     assertEquals(2, 1 + 1);
    // }
}