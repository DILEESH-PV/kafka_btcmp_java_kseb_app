import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
                    System.out.println("Selected delete a Consumer");
                    System.out.println("Enter the consumer id for deleting a consumer");
                    consumerid=sc.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `consumer` WHERE `consumerid` = "+consumerid;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 4:
                    System.out.println("Selected update a Consumer");
                    System.out.println("Enter the consumer id");
                    consumerid=sc.nextInt();
                    System.out.println("Enter the consumer name to be updated");
                    name=sc.next();
                    System.out.println("Enter the address of consumer to be updated");
                    address=sc.next();
                    System.out.println("Enter the phone number to be updated");
                    phone=sc.next();
                    System.out.println("Enter the email to be updated");
                    email=sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "UPDATE `consumer` SET `name`='"+name+"',`address`='"+address+"',`phone`='"+phone+"',`email`='"+email+"' WHERE `consumerid` = "+consumerid;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 5:
                    System.out.println("View all Consumers");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql="SELECT `consumerid`, `name`, `address`, `phone`, `email` FROM `consumer` ";
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
                case 6:
                    System.out.println("Selected bill generation");
                    GregorianCalendar date = new GregorianCalendar();
                    int cMonth = date.get(Calendar.MONTH);
                    int cYear = date.get(Calendar.YEAR);
                    cMonth = cMonth+1;
                    System.out.println("Current month is  " + cMonth);
                    System.out.println("Current year is  " + cYear);
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `bill` WHERE `month`= '" + cMonth + "'AND `year`= '" + cYear + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        String sql1 = "SELECT `id` FROM `consumer` ";
                        Statement stmt1 = con.createStatement();
                        ResultSet rs = stmt1.executeQuery(sql1);
                        while (rs.next())
                          {
                            int id = rs.getInt("id");
                            String sql2 = "select SUM(`unit`) from usages where month(date) = '"+cMonth+"' AND year(date) = '"+cYear+"' AND `consumerid` ='"+id+"'";
                            Statement stmt2 = con.createStatement();
                            ResultSet rs1 = stmt2.executeQuery(sql2);
                            while (rs1.next())
                              {
                                int add = rs1.getInt("SUM(`Unit`)");
                                int status = 0;
                                int totalBill = add * 5;
                          // Random number generating section
                                int min = 10000;
                                int max = 99999;
                                int invoice = (int)(Math.random() * (max - min + 1) + min);
                                String sql3 = "INSERT INTO `bill`(`consumerid`, `month`, `year`, `bill`, `paidstatus`, `date`, `totalunits`, `duedate`, `invoice`) VALUES (?,?,?,?,?,now(),?,now()+ interval 14 day,?)";
                                PreparedStatement stmt3 = con.prepareStatement(sql3);
                                stmt3.setInt(1, id);
                                stmt3.setInt(2, cMonth);
                                stmt3.setInt(3, cYear);
                                stmt3.setInt(4, totalBill);
                                stmt3.setInt(5, 0);
                                stmt3.setInt(6, add);
                                stmt3.setInt(7,invoice );
                                stmt3.executeUpdate();
                            }
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("\nSuccessfully Generated Consumer Bill");
                    break;
                case 7:
                    System.out.println("Selected view Bill");
                    try
                       {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                           String sql = "SELECT b.`consumerid`, b.`month`, b.`year`, b.`bill`, b.`paidstatus`, b.`date`, b.`totalunits`, b.`duedate`, b.`invoice`, c.`name`, c.`address` FROM bill b JOIN consumer c ON b.consumerid=c.id";
                           Statement stmt=con.createStatement();
                           ResultSet rs=stmt.executeQuery(sql);
                           while (rs.next())
                           {
                               String getCode=rs.getString("consumerid");
                               String getMonth=rs.getString("month");
                               String getYear=rs.getString("year");
                               String getBill=rs.getString("bill");
                               String getPaid=rs.getString("paidstatus");
                               String getDate=rs.getString("date");
                               String getUnits=rs.getString("totalunits");
                               String getDue=rs.getString("duedate");
                               String getInvoice=rs.getString("invoice");
                               String getName=rs.getString("name");
                               String getAddress=rs.getString("address");

                               System.out.println("Consumer ID    : "+getCode);
                               System.out.println("Month          : "+getMonth);
                               System.out.println("Year           : "+getYear);
                               System.out.println("Amount         : "+getBill);
                               System.out.println("Paid Status    : "+getPaid);
                               System.out.println("Bill Date      : "+getDate);
                               System.out.println("Total Units    : "+getUnits);
                               System.out.println("Due Date       : "+getDue);
                               System.out.println("Invoice        : "+getInvoice);
                               System.out.println("Consumer Name  : "+getName);
                               System.out.println("Address        : "+getAddress+"\n");
                           }
                       }
                    catch (Exception e)
                      {
                          System.out.println(e);
                      }
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