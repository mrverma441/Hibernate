package secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hiber.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
	
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session s1=factory.openSession();
        
        
       Student st1= s1.get(Student.class, 12345);
       System.out.println(st1);
        s1.close();
        
        
        Session s2=factory.openSession();
        
        Student st2= s2.get(Student.class, 12345);
        System.out.println(st2);
        
        s2.close();
	}
}
