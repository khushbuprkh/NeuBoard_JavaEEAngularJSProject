package com.neu.edu.pojo;

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
