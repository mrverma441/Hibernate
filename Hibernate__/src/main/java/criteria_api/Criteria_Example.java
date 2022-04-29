package criteria_api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hiber.Student;

public class Criteria_Example {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session s=factory.openSession();
   
        
         Criteria c=s.createCriteria(Student.class);
        
        // c.add(Restrictions.eq("certi.course","BCA"));
         //c.add(Restrictions.gt("id", 122));
         c.add(Restrictions.like("certi.course", "MCA%"));
         List<Student>students=c.list();
         for(Student st:students)
         {
        	 System.out.println(st);
         }
        s.close();
        factory.close();
	}
}
