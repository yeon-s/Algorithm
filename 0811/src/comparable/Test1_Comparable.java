package comparable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test1_Comparable {
	public static void main(String[] args) {
		Student[] students1 = new Student[3];
		students1[0] = new Student("현병욱", "123", 3.47);
		students1[1] = new Student("김유진", "321", 4.17);
		students1[2] = new Student("한선규", "211", 2.5);
		
		ArrayList<Student> students2 = new ArrayList<>();
		students2.add(new Student("김유진", "321", 4.17));
		students2.add(new Student("현병욱", "123", 3.47));
		students2.add(new Student("한선규", "211", 2.5));
//		System.out.println(students2.get(0).compareTo(students2.get(2)));		
		
		Queue<Student> students3 = new LinkedList<>();
		students3.offer(new Student("한선규", "211", 2.5));
		students3.offer(new Student("현병욱", "123", 3.47));
		students3.offer(new Student("김유진", "321", 4.17));
		
		PriorityQueue<Student> students4 = new PriorityQueue<>();
		students4.add(new Student("김유진", "321", 4.17));
		students4.add(new Student("한선규", "211", 2.5));
		students4.add(new Student("현병욱", "123", 3.47));
		students4.add(new Student("양유진", "789", 2.5));
		
		while(!students4.isEmpty()) {
			System.out.println(students4.remove());
		}
	}
	
	static class Student implements Comparable<Student> {
		private String name;
		private String stuNum;
		private double grade;
		
		public Student(String name, String stuNum, double grade) {
			this.name = name;
			this.stuNum = stuNum;
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", stuNum=" + stuNum + ", grade=" + grade + "]";
		}

		@Override
		public int compareTo(Student other) { 
			if(this.grade > other.grade)
				return -1;
			else if(this.grade < other.grade)
				return +1;
			else {
				return this.stuNum.compareTo(other.stuNum);
			}
		}
	}
}


