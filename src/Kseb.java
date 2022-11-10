import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Kseb {
    public static void main(String[] args) {
        int ch,consumerid;
        String name,address,email,phone;
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
                    System.out.println("Selected add a Consumer");
                    System.out.println("Enter the consumer id");
                    consumerid=sc.nextInt();
                    System.out.println("Enter the consumer name");
                    name=sc.next();
                    System.out.println("Enter the address ");
                    address=sc.next();
                    System.out.println("Enter the phone number");
                    phone=sc.next();
                    System.out.println("Enter the email id");
                    email=sc.next();
                    System.out.println("New consumer added\n");
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql="INSERT INTO `consumer`(`consumerid`, `name`, `address`, `phone`, `email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt= con.prepareStatement(sql);
                        stmt.setInt(1,consumerid);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setString(4,phone);
                        stmt.setString(5,email);
                        stmt.executeUpdate();
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }

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