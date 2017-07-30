package com.neu.edu.pojo;


public class Enums {
//	@Embeddable
	public enum RoleType {
		ADMIN(1), TEACHER(2), STUDENT(3);

		private int value;

		private RoleType(int value)

		{
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	public enum Status {
		ACTIVE(1), INACTIVE(2);

		private int value;

		private Status(int value)

		{
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
//	@Embeddable
	public enum Gender{
		MALE(1), FEMALE(2);

		private int value;

		private Gender(int value)

		{
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
	}
//	@Embeddable
	public enum Level{
		GRADUATE(1), UNDERGRADUATE(2);

		private int value;

		private Level(int value)

		{
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
	}

}
