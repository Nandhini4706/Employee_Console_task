import java.sql.*;
import java.util.*;
import db.Con_db;
import static java.lang.Class.forName;
public class Main {
  public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
//Connection con=Con_db.getConnnection();
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");

         Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/employee",
                 "root",
                 "Nandhu07"
         );

         while (true) {
             System.out.println("------------------------------------------");
             System.out.println("1. ADD Employee");
             System.out.println("2. Update Employee");
             System.out.println("3. View Employee");
             System.out.println("4. Exit");
             System.out.println("------------------------------------------");

             System.out.println("Enter Your Choice : ");
             int choice = sc.nextInt();
             sc.nextLine();
             switch (choice) {
                 case 1:
                     System.out.println("Enter Emp Name ");
                     String name = sc.nextLine();
                     System.out.println("Enter Emp email ");
                     String email = sc.nextLine();
                     System.out.println("Enter Emp mobileNo ");
                     String mobileNo = sc.nextLine();
                     System.out.println("Enter Emp city ");
                     String city = sc.nextLine();
                     System.out.println("Enter Emp state ");
                     String state = sc.nextLine();
                     System.out.println("Enter date_of_joining ");
                     String date = sc.nextLine();
                     System.out.println("Enter deptId ");
                     int dept = sc.nextInt();
                     System.out.println("Enter projectId ");
                     int project = sc.nextInt();
                     sc.nextLine();
                     System.out.println("Enter Emp_status ");
                     String status = sc.nextLine();
                     System.out.println("Enter experience ");
                     String exp = sc.nextLine();

                     String insertQuery = "INSERT INTO employees(empName, emailId, mobileNo, city, state, date_of_join, deptID, projectId, emp_status, experience) VALUES(?,?,?,?,?,?,?,?,?,?)";
                     PreparedStatement ps = con.prepareStatement(insertQuery);
                     ps.setString(1, name);
                     ps.setString(2, email);
                     ps.setString(3, mobileNo);
                     ps.setString(4, city);
                     ps.setString(5, state);
                     ps.setString(6, date);
                     ps.setInt(7, dept);
                     ps.setInt(8, project);
                     ps.setString(9, status);
                     ps.setString(10, exp);

                     int row = ps.executeUpdate();
                     if(row > 0) {
                         System.out.println("Employee Added Successfully");
                     }else{
                         System.out.println("Employee not added");
                     }
                     break;
                 case 2:

                 case 3:
                     String selectQuery = "SELECT * FROM employees";
                     PreparedStatement ps2 = con.prepareStatement(selectQuery);

                     ResultSet rs = ps2.executeQuery();

                     boolean found = false;

                     while (rs.next()) {
                         found = true;

                         System.out.println("ID: " + rs.getInt("empId"));
                         System.out.println("Name: " + rs.getString("empName"));
                         System.out.println("Email: " + rs.getString("emailId"));
                         System.out.println("Mobile No: " + rs.getString("mobileNo"));
                         System.out.println("City: " + rs.getString("city"));
                         System.out.println("State: " + rs.getString("state"));
                         System.out.println("Date of Join: " + rs.getString("date_of_join"));
                         System.out.println("Dept ID: " + rs.getInt("deptID"));
                         System.out.println("Project ID: " + rs.getInt("projectId"));
                         System.out.println("Status: " + rs.getString("emp_status"));
                         System.out.println("Experience: " + rs.getString("experience"));
                         System.out.println("----------------------------------");
                     }

                     if (!found) {
                         System.out.println("Employee not found");
                     }

                     break;
                 case 4:
                     System.out.println("Are You Sure want to Exit");
                     String s = sc.nextLine();
                     if (s.equalsIgnoreCase("yes")) {
                         return;
                     } else {
                         continue;
                     }
             }
         }


     }catch(Exception e){
         System.out.println(e);
     }
  }
}
