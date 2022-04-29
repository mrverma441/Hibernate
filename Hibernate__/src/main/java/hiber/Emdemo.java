package hiber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emdemo {

	public static void main(String[] args) {
		    Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory =cfg.buildSessionFactory();
	        
	        Student student1=new Student();
	        student1.setId(141);
	        student1.setName("Monu verma");

	        student1.setCity("Lucknow");
	        
	        Certification certification=new Certification();
	        certification.setCourse("Android");
	        certification.setDuration("2 months");
	        
	        student1.setCerti(certification);
	        
	        
	        
	        Student student2=new Student();
	        student2.setId(142);
	        student2.setName("Mukul joshi");

	        student2.setCity("durgapur");
	        
	        Certification certification2=new Certification();
	        certification2.setCourse("Hibernate");
	        certification2.setDuration("3 months");
	        
	        student2.setCerti(certification2);

	        
	        Session s=factory.openSession();
	        
	        Transaction tx=s.beginTransaction();
	        
	        s.save(student1);
	        s.save(student2);
	        tx.commit();
	        s.close();
	        
	        
	        factory.close();
	        
	}
}
