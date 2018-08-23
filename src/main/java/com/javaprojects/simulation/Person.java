package com.javaprojects.simulation;

enum Gender{
	MALE, FEMALE;
}
/**
 * A person object with gender and age
 */
public class Person {
	
	
	public Gender gender;
	public int age;
	/**
	 * Returns a Person object that constitutes the
	 * basic unit of a community
	 * 
	 * @param gender Male or female
	 * @param age    from 0 to 80
	 */
	public Person(Gender gender, int age) {
		this.gender = gender;
		this.age = age;
	}

	/**
	 * Modifier method that increments the Person's age by 1
	 */
	public void incAge() {
		this.age++;
	}
	
}


