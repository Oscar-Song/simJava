package com.javaprojects.simulation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A family should have the parents and the children
 * <p>
 * Children should leave the house at age 18
 */
public class Family {
	
	public Person father;
	public Person mother;
	public Queue<Person> children;
	public Boolean finishedReproduce = false;
	public int famSize = 0;
	public int randNum;
	
	/**
	 * Constructor to instantiate a Family object with
	 * parents, empty list of children, and a random number 
	 * of children to have in the future
	 * <p>
	 * @param man a Person object that is the father of the family
	 * @param woman a Person object that is the mother of the family
	 */
	public Family(Person man, Person woman) {
		this.father = man;
		this.mother = woman;
		this.children = new LinkedList<Person>();
		famSize += 2;
		randNum = (int)(Math.random()*(5-1)+1)+1;
	}
	/**
	 * Have a child this year if the limit is not reached yet
	 * <p>
	 * @return a Person object that is either a Child or null
	 */
	public Person reproduce() {
		//Time for sex
		if(!finishedReproduce) {
			Gender gender = (Math.random()<0.5)?Gender.MALE:Gender.FEMALE;
			Person child = new Person(gender, 0);
			this.children.add(child);
			famSize++;
			if(children.size() >= randNum) {
				finishedReproduce = true;
			}
			return child;
		}
		return null;
	}
	/**
	 * Force anyone with age over 18 in this family to leave this family 
	 * <p>
	 * @return a list of Persons who were children of this family and are now age over 18
	 */
	public List<Person> childLeaveHome() {
		
		List<Person> youngAdults = new ArrayList<Person>();
		while(!children.isEmpty()) {
			if(children.peek().age >=18) {
				youngAdults.add(children.remove());
				famSize--;
			}
			else {
				break;
			}
		}
		return youngAdults;
	}
	/**
	 * Accessor method to get the size of the family
	 * @return an integer of family size
	 */
	public int getFamSize() {
		return famSize;
	}
	
	
}
