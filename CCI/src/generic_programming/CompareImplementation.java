package generic_programming;

import java.util.Comparator;


public class CompareImplementation {
	
	public static class Student implements Comparable<Student> {
		
		private String studentName;
		private int studentId;
		private double gpa;
		
		public Student(String studentName, int studentId, double gpa) {
			this.studentName = studentName;
			this.studentId = studentId;
			this.gpa = gpa;
		}
		
		// Ascending order output
		@Override
		public int compareTo(Student s) {
			return (this.gpa > s.gpa)? 1 : ((this.gpa < s.gpa)? -1:0);
		}
	}
	
	public static class Student2{
		
	}
	
}