package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="table1")
public class EmployeeEntity {
	@Id
	private int tId;
	private String tName;
	private String tCity;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettCity() {
		return tCity;
	}
	public void settCity(String tCity) {
		this.tCity = tCity;
	}
	

}
