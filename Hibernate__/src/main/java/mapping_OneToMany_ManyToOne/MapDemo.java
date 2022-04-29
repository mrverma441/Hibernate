package mapping_OneToMany_ManyToOne;

import java.util.ArrayList;
import java.util.List;

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
	     q1.setQuestionId(231);
	     q1.setQuestion("What is Java ?");
	     
	     //Creating Answer
	     
	     Answer answer = new Answer();
	     answer.setAnswerId(347);
	     answer.setAnswer("Java is a programming language");
	     answer.setQuestion(q1);
	     
	     
	     Answer answer1 = new Answer();
	     answer1.setAnswerId(34);
	     answer1.setAnswer("it have different frameworks");
	     answer1.setQuestion(q1);
	    
	     Answer answer2 = new Answer();
	     answer2.setAnswerId(389);
	     answer2.setAnswer("can be used for android development");
	     answer2.setQuestion(q1);
	    
	     
	    List<Answer>list=new ArrayList<Answer>();
	    list.add(answer);
	    list.add(answer1);
	    list.add(answer2);
	    q1.setAnswers(list);

	    
	     //session
	     
	     Session session = factory.openSession();
	     Transaction tx = session.beginTransaction();
	     
	     session.save(answer);
	     session.save(answer1);
	     session.save(answer2);
	     session.save(q1);
//	     session.save(q2);
//	     
	     tx.commit();
	     
	     //For fetching the data
	     Question newq=(Question)session.get(Question.class, 231);
	     System.out.println(newq.getQuestion());
	     for(Answer a:newq.getAnswers())
	     {
	    	 System.out.println(a.getAnswer());
	     }

	     
//	     Question newq=(Question)session.get(Question.class, 242);
//	     System.out.println(newq.getQuestion());
//	     System.out.println(newq.getAnswer().getAnswer());
	     session.close();
	     factory.close();
	}

}
