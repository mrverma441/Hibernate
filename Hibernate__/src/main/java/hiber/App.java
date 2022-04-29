package hiber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
        //SessionFactory is like a connection
        //kind of thread safe object...
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        //Creating object of Student class
        Student student=new Student();
        student.setId(108);
        student.setName("KL_RAHUL");
        student.setCity("Lucknow_Supergiants");
        System.out.println(student);
        
        //Creating object of address class
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //for reading the image
//        FileInputStream fis=new FileInputStream("src/main/java/d1.jpg");
//        
//        byte[]data=new byte[fis.available()];
//        fis.read(data);
//        ad.setImage(data);
        Session session = factory.openSession();
        
        Transaction tx= session.beginTransaction();
        session.save(student);
        session.save(ad);
        tx.commit();       
      
        
        session.close();
        System.out.println("Done..");
        
    }
}
