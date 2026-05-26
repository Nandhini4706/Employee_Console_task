package Model;

public class Employee {
    public String empName;
    public String emailId;
    public String mobileNo;
    public String city;
    public String state;
    public String date_of_join;
    public int deptId;
    public int projectId;
    public String emp_status;
    public String experience;

    public Employee(String empName,String emailId, String mobileNo, String city,String state, String date_of_join, int deptId, int projectId, String emp_status, String experience){
        this.empName=empName;
        this.emailId=emailId;
        this.mobileNo=mobileNo;
        this.city=city;
        this.state=state;
        this.date_of_join=date_of_join;
        this.deptId=deptId;
        this.projectId=projectId;
        this.emp_status=emp_status;
        this.experience=experience;
    }
}
