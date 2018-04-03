package gr.pr.udemy.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class CoursesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "course_name", length = 45)
	private String courseName;
	
	@Basic
	@Column(name = "course_code", length = 45, unique = true)
	private String courseCode;
	
	public CoursesModel(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CoursesModel)) return false;
		
		CoursesModel that = (CoursesModel) o;
		
		if (getId() != that.getId()) return false;
		if (getCourseName() != null ? !getCourseName().equals(that.getCourseName()) : that.getCourseName() != null)
			return false;
		return getCourseCode() != null ? getCourseCode().equals(that.getCourseCode()) : that.getCourseCode() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getCourseName() != null ? getCourseName().hashCode() : 0);
		result = 31 * result + (getCourseCode() != null ? getCourseCode().hashCode() : 0);
		return result;
	}
}
