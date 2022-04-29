package object_states;

import object_states.Certification;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		//Practical of hibernate object states
		//Transient
		//Persistent
		//Detached
		//Remove
		//System.out.println("Example:");
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        
        
      
        //creating student object
        
        Student student=new Student();
        student.setId(123457);
        student.setName("New Name");
        student.setCity("ABC");
        student.setCerti(new Certification("Java hibernate course ","2Months"));
        //Student:Transient
        
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(student);
        //Student:Persistent state-associated with session ,database
        student.setName("Monu");
        tx.commit();

        s.close();
        //student:Detached
        student.setName("Sachin");
        factory.close();
        
		
	}
}
