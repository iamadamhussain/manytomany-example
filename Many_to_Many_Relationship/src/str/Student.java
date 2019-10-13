package str;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="students")
public class Student {
	@Id
	@Column(name="studentid")
	private int studentId;
	private String studentName;
	private int marks;
	@ManyToMany(cascade=CascadeType.ALL) 
	@JoinTable(name="students_coures",joinColumns=@JoinColumn(name="student_id_fk",referencedColumnName="studentid"),inverseJoinColumns=@JoinColumn(name="course_id_fk",referencedColumnName="courseid"))
	/*
	 the @JoinTable annotation to specify the details of the join table (table name and two join columns - using the @JoinColumn annotation)
	  The @JoinTable annotation indicates that we will interact with the intermediary table (students_coures) 
	  and further you can see settings of the relationship including mapping of columns.

The joinColumns attribute is responsible for the columns mapping of the owning side. The name attribute contains the column name of the intermediary table, 
the referencedColumnName attribute contains the primary key column name (in our case the primary key column of the user table is id) of the owning side.

The inverseJoinColumns attribute is responsible for the columns mapping of the inverse side.  
	 */
	private Set<Course> courses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Set getCourses() {
		return courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}
	
	
}
