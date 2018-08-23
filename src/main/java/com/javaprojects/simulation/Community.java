package com.javaprojects.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A community should have the following functionalities
 * <ul>
 * <li>Check the size of the population
 * <li>Adjust the Mating age
 * <li>Adjust the initial population size
 * </ul>
 *
 * 
 */
public class Community {
	
	public List<Person> allPeople;
	public Queue<Person> singleLadies;
	public Queue<Person> singleMen;
	public List<Family> listOfFam;
	
	public Community() {
		allPeople = new ArrayList<Person>();
		singleLadies = new LinkedList<Person>();
		singleMen = new LinkedList<Person>();
		listOfFam = new ArrayList<Family>();
		for(int i = 0; i < 10; i++) {
			Gender randGender;
			if(Math.random() < 0.5) {
				randGender = Gender.MALE;
				Person person = new Person(randGender,18);
				allPeople.add(person);
				singleMen.add(person);
			}
			else {
				randGender = Gender.FEMALE;
				Person person = new Person(randGender,18);
				allPeople.add(person);
				singleLadies.add(person);
			}
		}
		System.out.println("Community initiated.");
		System.out.println(singleLadies.size()+" ladies");
		System.out.println(singleMen.size()+" men");
	}
	/**
	 * Accessor method 
	 * 
	 * @return the total population
	 */
	public int getTotalPop() {
		return allPeople.size();
	}
	public void marriageSeason() {
		System.out.println("Marriage season!");
		int i =0;
		while(!singleLadies.isEmpty() && !singleMen.isEmpty()) {
			
			Family family = new Family(singleMen.peek(),singleLadies.peek());
			listOfFam.add(family);
			singleMen.remove();
			singleLadies.remove();
			i++;
		}
		System.out.println(i+" couples got married!");
	}
	public void reproduceSeason() {
		System.out.println("Reproduction Season!");
		for(Family fam: listOfFam){
			Person child = fam.reproduce();
			if(child != null) {
				allPeople.add(child);
			}
		}
	}
	public void ageUp() {
		List<Person> toDie = new ArrayList<Person>();
		for(int i = 0; i < allPeople.size(); i++) {
			allPeople.get(i).incAge();
			if(allPeople.get(i).age > 80) {
				toDie.add(allPeople.get(i));
			}
		}
		for(Person oldPerson: toDie) {
			allPeople.remove(oldPerson);
		}
	}
	public void adulthood() {
		List<Person> youngAdults = new ArrayList<Person>();
		for(Family fam: listOfFam) {
			youngAdults.addAll(fam.childLeaveHome());
		}
		for(Person youngAdult: youngAdults) {
			if(youngAdult.gender == Gender.MALE) {
				singleMen.add(youngAdult);
			}
			else {
				singleLadies.add(youngAdult);
			}
		}
	}
}
