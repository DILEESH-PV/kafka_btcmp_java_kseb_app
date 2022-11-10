import java.util.Scanner;

public class Kseb {
    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option");
            System.out.println("1 Add a Consumer ");
            System.out.println("2 Search a Consumer ");
            System.out.println("3 Delete a Consumer ");
            System.out.println("4 Update a Consumer ");
            System.out.println("5 View all Consumers ");
            System.out.println("6 Generate Bill ");
            System.out.println("7 View Bill  ");
            System.out.println("8 Top two high bill consumers");
            System.out.println("9.Exit ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Add a Consumer");
                    break;
                case 2:
                    System.out.println("Search a Consumer");
                    break;
                case 3:
                    System.out.println("Delete a Consumer");
                    break;
                case 4:
                    System.out.println("Update a Consumer");
                    break;
                case 5:
                    System.out.println("View all Consumers");
                    break;
                case 6:
                    System.out.println("Generate Bill");
                    break;
                case 7:
                    System.out.println("View Bill");
                    break;
                case 8:
                    System.out.println("Top two high bill paying consumers");
                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice");

            }

        }
    }
}