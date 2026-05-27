import java.sql.*;
import java.util.*;

import Model.Employee;
import Service.Emp_Service;
import db.Con_db;
import static java.lang.Class.forName;
public class Main {
  public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
 Connection con=Con_db.getConnnection();
      Emp_Service service=new Emp_Service(con);

         while (true) {
             System.out.println("------------------------------------------");
             System.out.println("1. ADD Employee");
             System.out.println("2. Update Employee");
             System.out.println("3. Display Employee");
             System.out.println("4. View Employee");
             System.out.println("5. Delete Employee");
             System.out.println("6. Exit");
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
                     Employee emp=new Employee(name,email,mobileNo,city,state,date,dept,project,status,exp);
                     service.addEmployee(emp);
                     break;
                 case 2:
                  /*   System.out.println("Enter Employee ID to Update: ");
                     int updateId = sc.nextInt();
                     sc.nextLine();

                     System.out.println("Enter New Emp Name: ");
                     String newName = sc.nextLine();

                     System.out.println("Enter New Email: ");
                     String newEmail = sc.nextLine();

                     System.out.println("Enter New Mobile No: ");
                     String newMobile = sc.nextLine();

                     System.out.println("Enter New City: ");
                     String newCity = sc.nextLine();

                     String updateQuery = "UPDATE employees SET empName=?, emailId=?, mobileNo=?, city=? WHERE empId=?";

                     PreparedStatement ps3 = con.prepareStatement(updateQuery);

                     ps3.setString(1, newName);
                     ps3.setString(2, newEmail);
                     ps3.setString(3, newMobile);
                     ps3.setString(4, newCity);
                     ps3.setInt(5, updateId);

                     int row1 = ps3.executeUpdate();

                     if (row1 > 0) {
                         System.out.println("Employee Updated Successfully");
                     } else {
                         System.out.println("Employee ID not found");
                     }

                     break;

                   */
                     System.out.println("Enter Employee ID to Update: ");
                      int updateId= sc.nextInt();
                      sc.nextLine();

                      System.out.println("What You Want to Update ");
                      System.out.println("1.name / 2.email / 3.mobileNo / 4.city / 5.state / 6.date_of_join / 7.deptID/ 8.projectId/ 9.emp_status/ 10.experience");
                      int i=sc.nextInt();
                      sc.nextLine();
                      if(i==1){
                          System.out.println("Enter name ");
                          String newName=sc.nextLine();
                          String updateQuery = "UPDATE employees SET empName=? WHERE empId=?";
                          PreparedStatement ps3 = con.prepareStatement(updateQuery);
                          ps3.setString(1, newName);
                          ps3.setInt(2, updateId);

                          int row2 = ps3.executeUpdate();
                          if (row2 > 0) {
                              System.out.println("Employee Updated successfully");
                          } else {
                              System.out.println("Employee ID not found");
                          }
                         }else if(i==2){
                          System.out.println("Enter email ");
                          String newEmail=sc.nextLine();
                          String updateQuery = "UPDATE employees SET emailId=? WHERE empId=?";
                          PreparedStatement ps3 = con.prepareStatement(updateQuery);
                          ps3.setString(1, newEmail);
                          ps3.setInt(2, updateId);

                          int row2 = ps3.executeUpdate();
                          if (row2 > 0) {
                              System.out.println("Employee Updated successfully");
                          } else {
                              System.out.println("Employee ID not found");
                          }
                      }
                      break;
                 case 3:
                     service.viewEmployee();
                     break;

                 case 4:
                     System.out.println("Enter Employee ID to View: ");
                     int viewId = sc.nextInt();

                     String viewQuery = "SELECT * FROM employees WHERE empId=?";

                     PreparedStatement ps5 = con.prepareStatement(viewQuery);
                     ps5.setInt(1, viewId);

                     ResultSet rs5 = ps5.executeQuery();

                     if (rs5.next()) {
                         System.out.println("ID: " + rs5.getInt("empId"));
                         System.out.println("Name: " + rs5.getString("empName"));
                         System.out.println("Email: " + rs5.getString("emailId"));
                         System.out.println("Mobile No: " + rs5.getString("mobileNo"));
                         System.out.println("City: " + rs5.getString("city"));
                         System.out.println("State: " + rs5.getString("state"));
                         System.out.println("Date of Join: " + rs5.getString("date_of_join"));
                         System.out.println("Dept ID: " + rs5.getInt("deptID"));
                         System.out.println("Project ID: " + rs5.getInt("projectId"));
                         System.out.println("Status: " + rs5.getString("emp_status"));
                         System.out.println("Experience: " + rs5.getString("experience"));
                     } else {
                         System.out.println("Employee ID not found");
                     }

                     break;
                 case 5:
                     System.out.println("Enter Employee ID to Delete: ");
                     int deleteId = sc.nextInt();

                     String deleteQuery = "DELETE FROM employees WHERE empId=?";

                     PreparedStatement ps6 = con.prepareStatement(deleteQuery);
                     ps6.setInt(1, deleteId);

                     int row5 = ps6.executeUpdate();

                     if (row5 > 0) {
                         System.out.println("Employee Deleted Successfully");
                     } else {
                         System.out.println("Employee ID not found");
                     }

                     break;
                 case 6:
                     System.out.println("Are You Sure want to Exit");
                     String s = sc.nextLine();
                     if (s.equalsIgnoreCase("yes")) {
                         return;
                     } else {
                         continue;
                     }
             }
         }
  }
}
