package Service;

import Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void viewEmployee() throws  Exception{
        String query="Select * from employees";
        PreparedStatement ps= con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        boolean boo=false;
        while(rs.next()){
            boo=true;
            System.out.println("Id : " +rs.getInt("empId"));
            System.out.println("Name : " +rs.getString("empName"));
            System.out.println("EmailId : " +rs.getString("emailId"));
            System.out.println("Mobile No : " +rs.getString("mobileNo"));
            System.out.println("City : " +rs.getString("city"));
            System.out.println("State : " +rs.getString("state"));
            System.out.println("Date Of Join : " +rs.getString("date_of_join"));
            System.out.println("Department Id : " +rs.getInt("deptId"));
            System.out.println("Project Id : " +rs.getInt("projectId"));
            System.out.println("Status : " +rs.getString("emp_status"));
            System.out.println("Experience : " +rs.getString("experience"));
            System.out.println("-------------------------------------------------------");
        }
        if(!boo){
            System.out.println("Employee Not found ");
        }
    }

    public void deleteEmployee(int deleteId) throws Exception{
        String query="DELETE FROM employees WHERE id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,deleteId);
        ResultSet rs=ps.executeQuery();
        boolean found =false;
        while(rs.next()){
            found=true;
            System.out.println("Id : " +rs.getInt("empId"));
            System.out.println("Name : " +rs.getString("empName"));
            System.out.println("EmailId : " +rs.getString("emailId"));
            System.out.println("Mobile No : " +rs.getString("mobileNo"));
            System.out.println("City : " +rs.getString("city"));
            System.out.println("State : " +rs.getString("state"));
            System.out.println("Date Of Join : " +rs.getString("date_of_join"));
            System.out.println("Department Id : " +rs.getInt("deptId"));
            System.out.println("Project Id : " +rs.getInt("projectId"));
            System.out.println("Status : " +rs.getString("emp_status"));
            System.out.println("Experience : " +rs.getString("experience"));
            System.out.println("-------------------------------------------------------");
        }
        if(!found){
            System.out.println("Employee Not Found");
        }
    }
}
