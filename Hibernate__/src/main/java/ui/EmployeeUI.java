package ui;

import bean.Employee;
import service.EmployeeService;

public class EmployeeUI {
	public static void main(String[] args) {
		createEmployee();
	}
	private static void createEmployee()
	{
		try
		{
			Employee e1=new Employee();
			e1.settId(2000);
			e1.settName("RAHUL");
			e1.settCity("Delhi");
			
			EmployeeService es=new EmployeeService();
			es.addEmployee(e1);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
