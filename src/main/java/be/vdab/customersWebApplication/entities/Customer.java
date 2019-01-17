package be.vdab.customersWebApplication.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer implements Serializable {

	private static final long serialVersionUID=1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	private String firstname;
	private String surname;

	public Customer(String firstname, String surname) {
		this.firstname=firstname;
		this.surname=surname; 
	}
	
	public Customer() {
	}
	
	public long getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	} 
	
}
