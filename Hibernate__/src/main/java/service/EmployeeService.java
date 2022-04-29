package service;

import bean.Employee;
import dao.EmployeeDAO;

public class EmployeeService {

	public void addEmployee(Employee emp) throws Exception
	{
		try
		{
			validateEmpName(emp.gettName());
			EmployeeDAO eo=new EmployeeDAO();
			eo.addEmployee(emp);
			
		}catch(Exception e)
		{
			throw e;
			
		}
		
		
	}

	private void validateEmpName(String gettName) throws Exception {

		System.out.println("Validation Method :"+gettName);
		String RE="[A-Z][a-zA-Z]{2,19}";
		if(gettName.matches(RE))
		{
			System.out.println("Name is valid");
		}
		else
		{
			System.out.println("Name is invalid");
			throw new Exception ("EmployeeName "+gettName+" is invalid");
			
		}
	}
}
