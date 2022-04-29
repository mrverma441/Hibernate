package mapping_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        
        Person p=new Person(12,"Monu","Delhi","7534050774");
        Session s=factory.openSession();
        
        Transaction tx=s.beginTransaction();
        s.save(p);
        tx.commit();
        factory.close();
	}

}
