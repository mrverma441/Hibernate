package cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mapping_OneToMany_ManyToOne.Answer;
import mapping_OneToMany_ManyToOne.Question;

public class CascadeExample {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session s=factory.openSession();
        
        Question q1=new Question();
        q1.setQuestionId(570);
        q1.setQuestion("What is swing framework ?");
        
        Answer a1=new Answer(23423,"first11 answer");
        Answer a2=new Answer(255,"second11 answer");
        Answer a3=new Answer(35,"third11 answer");
        
        List<Answer>list=new ArrayList<Answer>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);
        Transaction tx=s.beginTransaction();

        s.save(q1);
        
        tx.commit();
        s.close();
        factory.close();

	}

}
