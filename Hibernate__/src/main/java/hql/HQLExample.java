package hql;

import java.util.Arrays;
import java.util.List;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLExample {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session s=factory.openSession();
        //HQL syntax
        String query="from Student where id=:x";
        //String query="from Student as s where s.city=:x and s.name=:n";
        
        Query<?> q=s.createQuery(query);
        q.setParameter("x", 12345);
       
        
        //single(unique)
        //multiple(list)
        //q.uniqueResult();
        @SuppressWarnings("unchecked")
		List<Student>list=(List<Student>) q.list();
        for(Student student:list)
        {
        	System.out.println(student.getName()+":"+student.getCerti().getCourse());
        }
        Transaction tx=s.beginTransaction();
        
        System.out.println("------------------------------------------");
        //Delete query
//       Query q2= s.createQuery("delete from Student s where s.id=:d");
//       q2.setParameter("d",1234);
//        
//       int r=q2.executeUpdate();
//       System.out.println("deleted successfully");
//       System.out.println(r);
        
        //Update query
//       Query q3= s.createQuery("update Student set city=:l where name=:m");
//      q3.setParameter("l","Meerut");
//      q3.setParameter("m","Monu");
//      int r=q3.executeUpdate();
//      System.err.println(r+"Object updated");
        
    //how to execute join query
       Query<?> q4= s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a ");
        @SuppressWarnings("unchecked")
		List<Object[]> list4=(List<Object[]>) q4.getResultList();
        for(Object[]arr:list4)
        {
        	System.out.println(Arrays.toString(arr));
        }
        tx.commit();

        s.close();
        
        factory.close();
	}

}
