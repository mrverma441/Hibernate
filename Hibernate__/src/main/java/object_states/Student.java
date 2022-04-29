package object_states;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //@Entity("student_details")
//@Table(name="mystudents")
public class Student {
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.city;

	}
	@Id
	private int id;
	private String name;
	private String city;
	private Certification certi;
	
	public Certification getCerti() {
		return certi;
	}
	public void setCerti(Certification certi) {
		this.certi = certi;
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
