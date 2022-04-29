package fetch_type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	     SessionFactory factory = cfg.buildSessionFactory();
	     
	     Session s=factory.openSession();
	     Transaction tx=s.beginTransaction();
	     
	     
	     Question q=(Question)s.get(Question.class, 242);
	     System.out.println(q.getQuestionId());
	     System.out.println(q.getQuestion());
	     System.out.println(q.getAnswers().size());
	    
	     tx.commit();
	     s.close();
	     factory.close();
	}

}
