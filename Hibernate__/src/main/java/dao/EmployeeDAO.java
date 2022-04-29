package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Employee;
import entity.EmployeeEntity;
import resource.HibernateUtility;

public class EmployeeDAO {
	public void addEmployee(Employee in_emp) throws Exception
	{
		
		System.out.println("Employee id: "+in_emp.gettId());
		SessionFactory sf =null;
		Session ss=null;
		
		try
		{
			
			EmployeeEntity ee=new EmployeeEntity();
			ee.settId(in_emp.gettId());
			ee.settName(in_emp.gettName());
			ee.settCity(in_emp.gettCity());
			
			sf=HibernateUtility.createSessionFactory();
			ss=sf.openSession();
			ss.beginTransaction();
			ss.save(ee);
			ss.getTransaction().commit();
			System.out.println("Insertion successfully");

			
		}catch(Exception e)
		{
				throw e;		
		}
		finally
		{

			if(sf.isOpen())
			{
				sf.close();
			}
			if(ss.isOpen())
			{
				ss.close();
			}
		}
	}

}
