package firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hiber.Student;

public class FirstDemo {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session s=factory.openSession();
        
        
        Student student=s.get(Student.class, 12345);
        System.out.println(student);
        
        System.out.println("Working something");
        Student student1=s.get(Student.class, 123456);
        System.out.println(student1);
        
        Student student2=s.get(Student.class, 123456);

        System.out.println(student2);
        Student student3=s.get(Student.class, 12345);

        System.out.println(student3);
        
        
        System.out.println(s.contains(student1));
        System.out.println(s.contains(student2));
        System.out.println(s.contains(student3));
        
        Student student4=s.get(Student.class, 123457);

        System.out.println(student4);
        System.out.println(s.contains(student4));
        
        s.close();
        factory.close();
	}

}
