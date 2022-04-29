package Notes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hiber.Student;

/*
 * -------1-PREREQUISITE----------
 *1-Java Core
 *2-JDBC
 *3-Database
 *---------2-What is Hibernate ? ORM?-----------
 *Hibernate is a java framework that simplifies the development of java 
 application to interact with the database.
 *Hibernate is ORM(object relational mapping) tool.
 *Hibernate is an open source and lightweight.
 *Hibernate is a non-invasive framework,means it won't forces the programmers
 to extend/implement any class/interface.
 *It is invented by gavin king in 2001.
 *Any type of application can build with Hibernate framework.
 *------Traditional way to save data(JDBC)----------
 *Java application---->Database(Table->Attribute)
 *We create object in our application inside the class.
 *To save this object in our database we had called to JDBC API.
 *Here we write code manually to store objects(data) to database using jdbc.
 *-----Where hibernate play its role?----------
 *Java application---->Database(Table->Attribute)
 *this time we will use hibernate framework.
 *we will give our object to hibernate.
 *and hibernate will save this object to the database.
 *Here we will use mapping to map the object so hibernate will know 
 which field is map to which attribute in the database.
 *We map our table with our class.
 *---------3-Creating Maven Project for hibernate and adding dependencies------
 *---------4-Creating simple project for hibernate and adding jars----------
 *---------5-Hibernate Configuration(hibernate.cfg.xml)-----------------
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
		<session-factory>
		<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:3306/myjdbc</property>
		<property name="connection.username">root</property>
		<property name="connection.password">7534050774</property>
		<property name="hbm2ddl.auto">update</property>
		<property name="show_sql">true</property>
			<mapping class="hiber.Student"></mapping>
		</session-factory>
	</hibernate-configuration>
 *Hibernate will communicate to the database so it will require some information like url,username,Password etc;
 *Thats the reason we need hibernate xml configuartion file
 *--------6-first hibernate program using annotation -------
 *create one Student class ,define three properties like id,name,city then tell to hibernate by which name hibernate will create the table ny using @Entity
 give @Id annotation before id properties so hibernate will be knowing it which is our primary key
 then generate getter setters 
 then generate constructors using fields
 then generate constructor from super class
 then generate tostring() method.
 then in main class give the following code-:
  Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        Student student=new Student();
        student.setId(103);
        student.setName("Rajeev");
        student.setCity("Jhandichaur");
        System.out.println(student);
        
        Session session = factory.openSession();
        
        Transaction tx= session.beginTransaction();
        session.save(student);
        tx.commit();       
      
        session.close();
 *----------6-first hibernate program using annotation--------------
 *----------7-Commonly use hibernate Annotations--------------
 *@Entity-use to mark any class as Entity
 *@Table-use to change the table details.
 *@Id-use to mark column as id(primary key)
 *@GeneratedValue-hibernate will automatically generate values for that using an internal sequence,therefore we dont have to set 
it manually.
@Column-can be used to specify column mappings.for example,to change the column name in the associated table in database.
@Transient-This tells hibernate not to save this field.
@Temporal-over a date field tells hibernate the format in which the data needs to be saved.
@Lob-it tells to hibernate that this is a large object not a simple object.
@OneToOne,@OneToMany,ManyToOne,@JoinColumn etc.
*-------8-Saving Image and other type value with hibernate---------
*--------9-Fetching object|get()Method|load() Method-------------
fetch data
1-
->get() method of hibernate session returns null if object is not found in cache 
as well as on database;
->load() method throws objectnotfoundexception if object is not found on cache as well as
on database but never return null;
2-
->get() involves database hit if object does not exist in session cache 
and returns a fully initialized object which may involve several database
call.
->load()method can return proxy in place and only initialize the object
or hit the database if any method other than getId() is called on persistent or entity object
This lazy initialization increases the performance.
3-
->use if you are not sure that object exists in db or not
->use if you are that object exists.
*-------------10-Embeddable Annotation-------------------------------
*-------------11-OneToOne Mapping------------------------------------
*-------------12-OneToMany:ManyToOne Mapping-------------------------
*--------------13-ManyToOne Mapping-----------------------------------
*--------------14-ManyToMany Practical--------------------------------
*-------------15-Fetch type theory------------------------------------------
1-LAZY-In lazy loading,associated data loads only when we explicityly 
call getter or size method.
2-EAGER-It is a desgin pattern in which data loading occurs on the spot.
*---------------16-Fetch Practical--------------------
*----------------17-Hibernate/Persistance lifecycle states---------------
With the help of hibernate we do save the object into our database;
when an object some properties or it have some variable till then its called object.
but once it saved to the database,it save in database in the form of table,because we do use RDBMS;
We provide our object to hibernate which contain different variable,properties or methods.then hibernate save it to the database;
so how many stages are included between this process,this is all about hibernate lifecycle states,and we will be knowing this in this video.
1-Transient state
2-Persistent state
3-Detached state
4-Remove State
here we have 2 things
one is database 
and other is session object;
database for saving the data in the form of table
And Session object is work like mediator for us.
Session have so many object like save ,update ,delete,createquery this take our object and move it to the database,we can understand this 
indirectly.
here lets suppose we have one object ob;
it have two properties one is n other is x
n=46,x=47;
When we create the new object and set its properties so at that time our object called in transient state.
now when we will call session.save method so our object will associated to the Session.
Now session have its reference
so now this object is in Persistent state
and along with this ,this object now moved to database in which it contain both field n and x;
If we make any changes in this persistent state and we made any changes so it will reflect in both database and session.
now suppose we close the session.
session.close()
so this object will disappear from the session
now it will move to the detached state.
now it is no longer associated with the session.
And if you made any changes it will not be reflect.
and now suppose we are in detached state.
and value also exist in database
and also it is associated with session
simply we can call delete
so value will be removed from the database
but still it will be associated with the session
*-------------------------18-Hibernate Object states practical ------------------------------------
*-------------------------19-What is HQL ?-------------------------------------
*How to get the data in hibernate ?
*get(),Load()
*How to load complex data ?
*It support both hql,sql
*sql is not recommended specially if you are java programmer
*Hql-Database independent
*easy to learn for programmer
*sql-Database independent
*easy to learn for DBA.
*from student-hql:Student is an entity name (class name)
*Select *from student-sql(student is a table name)
*-------------------------20-How to get HQL queries------------------------------
*-------------------------21-Some Complex hql queries-------------------------
Delete
Update
Join
*---------------------------22-Pagination---------------------------------------
*---------------------------23-Executing Native SQL queries----------------------
String q="select *from Student";
NativeQuery nq=s.createSQLQuery(q);
List<Object[]>list=nq.list();
for(Object[]student:list)
{
System.out.println(Arrays.deepToString(student));
System.out.println(student[4]);
}

*---------------------------24-Hibernate Cascading-------------------------------
*---------------------------25-Hibernate Caching--------------------------------
*1-Caching is a mechanism to enhance the performance of a application.
*Cache is use to reduce the number of database queries.
*----------------------------26-First level cache--------------------------------
*----------------------------27-Second level cache-------------------------------
*----------------------------28-Hibernate Mapping using XML file-----------------
*----------------------------29-How to map class in hibernate using xml file-----
*---------------------------Hibernate Criteria API|Criteria Restrictions|---------
 */
public class Note {

}
