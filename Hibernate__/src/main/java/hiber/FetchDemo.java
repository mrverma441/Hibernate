package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		//get,load
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session session =factory.openSession();
        //get-student:108
        Student student=(Student)session.load(Student.class, 108);
        System.out.println(student);
        
        
        Address address=(Address)session.load(Address.class, 1);
        System.out.println(address.getStreet()+" : "+address.getCity());

        
        
        session.close();
        factory.close();
	}
}
