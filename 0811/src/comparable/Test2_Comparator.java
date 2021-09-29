package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// 프로그램 실행 이후에 정렬 기준이 바뀔 가능성이 있는 경우 Comparable로는 안됨.
public class Test2_Comparator {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("김유진", "321", 4.17,30));
		students.add(new Student("현병욱", "123", 3.47,28));
		students.add(new Student("한선규", "211", 2.5,27));
		students.add(new Student("양유진", "999", 2.5,33));
		
		System.out.println("---학번순 정렬 ---");
		Collections.sort(students, new StuNumComp());
		for(Student s: students) {
			System.out.println(s);
		}
		System.out.println("----------------");
		
		System.out.println("---이름순 정렬 ---");
		Collections.sort(students, new NameComp());
		for(Student s: students) {
			System.out.println(s);
		}
		System.out.println("----------------");
		
		System.out.println("---학점 내림차순 정렬(학점이 같은 경우 나이 오름차순) ---");
		Collections.sort(students, new GradeComp());
		for(Student s: students) {
			System.out.println(s);
		}
		System.out.println("----------------");
		
		PriorityQueue<Student> pq = new PriorityQueue<>(new NameComp());
	}
	
	static class StuNumComp implements Comparator<Student>{ // 학번 비교자
		@Override
		public int compare(Student o1, Student o2) {
			return o1.stuNum.compareTo(o2.stuNum);
		} 
	}
	
	static class NameComp implements Comparator<Student>{ // 이름 비교자
		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.compareTo(o2.name);
		} 
	}
	
	static class GradeComp implements Comparator<Student>{ // 학점 내림차순 비교자(학점 같으면 나이 오름차순)
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.grade > o2.grade) {
				return -1;
			}else if(o1.grade < o2.grade) {
				return +1;
			}else {
				return o1.age - o2.age;
			}
		} 
	}
	
	static class Student{
		private String name;
		private String stuNum;
		private double grade;
		private int age;
		
		public Student(String name, String stuNum, double grade, int age) {
			this.name = name;
			this.stuNum = stuNum;
			this.grade = grade;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", stuNum=" + stuNum + ", grade=" + grade + ", age=" + age + "]";
		}
	}
}
