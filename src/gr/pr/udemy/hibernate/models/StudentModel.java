package gr.pr.udemy.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "udemy")
public class StudentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "first_name", nullable = true, length = 45)
	private String firstName;
	
	@Basic
	@Column(name = "last_name", nullable = true, length = 45)
	private String lastName;
	
	@Basic
	@Column(name = "email", nullable = true, length = 45)
	private String email;
	
	public StudentModel(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public StudentModel() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StudentModel)) return false;
		
		StudentModel that = (StudentModel) o;
		
		if (getId() != that.getId()) return false;
		if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
			return false;
		return getEmail() != null ? getEmail().equals(that.getEmail()) : that.getEmail() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return "StudentModel{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
