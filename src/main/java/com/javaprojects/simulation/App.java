package com.javaprojects.simulation;

/**
 * The App program implements the main function to 
 * run the simulation of a community
 * <p>
 * Still needs to implement the plotting functionality
 * 
 * @author oscarsong
 * @version 1.0
 * @since 2018-07-15
 */

public class App 
{
	public static void main(String[] args) {
		int dataSize = 300;
		Community comm = new Community();
		//double[] xData = new double[dataSize];
		//double[] yData = new double[dataSize];
		for(int year = 1; year <= dataSize; year++) {
			System.out.println("Year: "+year);
			comm.marriageSeason();
			comm.reproduceSeason();
			comm.ageUp();
			comm.adulthood();
			int totalPop = comm.getTotalPop();
			System.out.println("Total Population: "+ totalPop);
			
			//xData[year] = (double)year;
			//yData[year] = (double)totalPop;
		}
		
	}
}
