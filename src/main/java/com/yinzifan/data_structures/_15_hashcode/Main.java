package com.yinzifan.data_structures._15_hashcode;

public class Main {
	
	public static void main(String[] args) {
		Integer a = 42;
		Integer b = -42;
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		Double pi = 3.1415926;
		String str = "algorithm";
		String str2 = "ALGORITHM";
		
		System.out.println(pi.hashCode());
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		
	}
	
	class Student {
		int grade;
		int cls;
		String firstName;
		String lastName;
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public int getCls() {
			return cls;
		}
		public void setCls(int cls) {
			this.cls = cls;
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
		@Override
		public int hashCode() {
			int B = 31;
			int hash = 0;
			hash = hash * B + grade;
			hash = hash * B + cls;
			hash = hash * B + firstName.hashCode();
			hash = hash * B + lastName.hashCode();
			return hash;
		}
		
		
	}

}
