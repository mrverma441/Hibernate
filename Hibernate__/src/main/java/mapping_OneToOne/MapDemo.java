package mapping_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	     SessionFactory factory = cfg.buildSessionFactory();
	     
	     //Creation Question
	     
	     Question q1 = new Question();
	     q1.setQuestionId(1212);
	     q1.setQuestion("What is Java ?");
	     
	     //Creating Answer
	     
	     Answer answer = new Answer();
	     answer.setAnswerId(343);
	     answer.setAnswer("Java is a programming language");
	     answer.setQuestion(q1);
	     q1.setAnswer(answer);
	     
	     
        //Creation Question
	     
	     Question q2 = new Question();
	     q2.setQuestionId(242);
	     q2.setQuestion("What is collection framework ?");
	     
	     //Creating Answer
	     
	     Answer answer1 = new Answer();
	     answer1.setAnswerId(344);
	     answer1.setAnswer("API to work with objects in java");
	     answer1.setQuestion(q2);
	     q2.setAnswer(answer1);
	     
	     
	     //session
	     
	     Session session = factory.openSession();
	     Transaction tx = session.beginTransaction();
	     
	     session.save(answer);
	     session.save(answer1);
	     session.save(q1);
	     session.save(q2);
	     
	     tx.commit();
	     Question newq=(Question)session.get(Question.class, 242);
	     System.out.println(newq.getQuestion());
	     System.out.println(newq.getAnswer().getAnswer());
	     session.close();
	     factory.close();
	}

}
