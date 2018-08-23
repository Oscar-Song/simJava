package com.javaprojects.simulation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {

	private static Person person;
	private static int testNum;
	@BeforeClass
	public static void initPerson() {
		person = new Person(Gender.MALE, 18);
		testNum = 1;
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("Test " + testNum+" starts");
	}
	@After
	public void afterEachTest() {
		System.out.println("Test "+ testNum+" ends");
		testNum++;
	}
	@Test
	public void testAge() {
		person.incAge();
		assertEquals(19, person.age);
		person.incAge();
		assertEquals(20, person.age);
		
	}

}
