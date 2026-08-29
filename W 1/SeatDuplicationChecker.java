import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (seats[i] == seats[j]) {
                    duplicate = true;
                    System.out.println("Duplicate seat found: " + seats[i]);
                }
            }
        }

        if (!duplicate) {
            System.out.println("No duplicate seats found.");
        }

        sc.close();
    }
}