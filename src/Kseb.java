import java.sql.*;
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
                    System.out.println("Selected search a Consumer");
                    String search;
                    System.out.println("Enter the consumer id/consumer name/consumer phone");
                    search=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql="SELECT `consumerid`, `name`, `address`, `phone`, `email` FROM `consumer` WHERE `consumerid` ='"+search+"'  OR `name`='"+search+"' OR `phone` ='"+search+"' ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next())
                        {
                            String getCode=rs.getString("consumerid");
                            String getName=rs.getString("name");
                            String getAddress=rs.getString("address");
                            String getPhno=rs.getString("phone");
                            String getEmail=rs.getString("email");
                            System.out.println("Consumer ID    : "+getCode);
                            System.out.println("Consumer Name  : "+getName);
                            System.out.println("Address        : "+getAddress);
                            System.out.println("Phone Number   : "+getPhno);
                            System.out.println("Email          : "+getEmail+"\n");

                        }
                    }catch (Exception e){
                        System.out.println(e);}


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