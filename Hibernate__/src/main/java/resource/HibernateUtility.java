package resource;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;




import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.EmployeeEntity;

public class HibernateUtility {

	private static SessionFactory sessionFactory=getSessionFactory();
	private static SessionFactory getSessionFactory() {
		try
		{
			if(sessionFactory==null)
			{
				Configuration configuration=new Configuration();
				configuration.configure("hibernate.cfg.xml");
				ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
				
			}
		}catch(Exception e)
		{
			System.out.println("ERROR:HibernateUtility :"+e.getMessage());
			e.printStackTrace();
		}
		return sessionFactory;
	}
	public static SessionFactory createSessionFactory()
	{
		return getSessionFactory();
		
	}
	public static void closeSessionFactory()
	{
		if(!sessionFactory.isClosed()||sessionFactory!=null)
		{
			sessionFactory.close();
		}
	}
}