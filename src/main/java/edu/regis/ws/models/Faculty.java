package edu.regis.ws.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="faculty", catalog="regis", uniqueConstraints = {
		@UniqueConstraint(columnNames="first_name"),
		@UniqueConstraint(columnNames="last_name") } )

public class Faculty implements Serializable {
	
	private Integer facultyId;
	private String firstName;
	private String lastName;
	
	public Faculty() {
	}
	
	public Faculty( String firstName, String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getFacultyId() {
		return this.facultyId;
	}
	
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}
	
	@Column(name = "first_name", unique = true, nullable = false)
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", unique = true, nullable = false)
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
