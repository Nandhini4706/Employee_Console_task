package Service;

import Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Emp_Service {
    Connection con;
    public Emp_Service(Connection con){
        this.con=con;
    }
    public void addEmployee(Employee emp)throws Exception{

        String insertQuery = "INSERT INTO employees(empName, emailId, mobileNo, city, state, date_of_join, deptID, projectId, emp_status, experience) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQuery);
        ps.setString(1, emp.empName);
        ps.setString(2, emp.emailId);
        ps.setString(3, emp.mobileNo);
        ps.setString(4, emp.city);
        ps.setString(5, emp.state);
        ps.setString(6, emp.date_of_join);
        ps.setInt(7, emp.deptId);
        ps.setInt(8, emp.projectId);
        ps.setString(9, emp.emp_status);
        ps.setString(10, emp.experience);

        int row = ps.executeUpdate();
        if(row > 0) {
            System.out.println("Employee Added Successfully");
        }else{
            System.out.println("Employee not added");
        }
        ps.close();
    }
}
