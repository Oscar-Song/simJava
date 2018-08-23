package com.javaprojects.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Ignore;
import org.junit.Test;

public class FamilyTest {

	private static Family fam;
	private static Person man;
	private static Person woman;
	private static int testNum;
	@BeforeClass
	public static void initFamily() {
		man = new Person(Gender.MALE, 18);
		woman = new Person(Gender.FEMALE, 18);
		
		fam = new Family(man, woman);
		
		testNum = 1;
		System.out.println("Testing family size");
		assertEquals(fam.famSize, 2);
		
		System.out.println("Testing man and woman equality");
		assertEquals(fam.father, man);
		assertEquals(fam.mother, woman);
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Test "+testNum);
	}
	@After
	public void afterTest() {
		testNum ++;
	}
	
	@Test
	public void testRandNum() {
		System.out.println("Testing range of children amount to reproduce");
		assertTrue(fam.randNum<=5 && fam.randNum >= 1);
	}
	
	@Test
	public void testChildLeaveHome() {
		System.out.println("Testing amount of children leaving home");
		Queue<Person> children = new LinkedList<Person>();
		List<Person> grownups = new ArrayList<Person>();
		grownups.add(new Person(Gender.MALE,30));
		grownups.add(new Person(Gender.FEMALE, 25));
		grownups.add(new Person(Gender.FEMALE, 18));
		for(Person grownup: grownups) {
			children.add(grownup);
		}
		children.add(new Person(Gender.MALE, 17));
		children.add(new Person(Gender.FEMALE, 0));
		
		fam.children = children;
		assertEquals(grownups, fam.childLeaveHome());
	}
	
	@Test
	public void testReproduce() {
		System.out.println("Testing Reproduction");
		int n = fam.randNum;
		int loopSize = n + 10;
		for(int i = 0; i < loopSize; i++) {
			fam.reproduce();
		}
		
		assertEquals(fam.famSize, n+2);
	}
	
	

}
