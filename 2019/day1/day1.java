/*

Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.

*/
import java.lang.Math;
import java.io.*;
import java.util.*;

public class day1{

	private static ArrayList<Integer> fuelModules = new ArrayList<Integer>(); 

	private static int getFuelRequirement(int moduleMass){
		int fuelReq = (moduleMass / 3) - 2;
		return fuelReq;
	}

	private static int getFuelForFuel(int addedFuel){
		int extraFuel = 0;
		while(addedFuel > 5){
			extraFuel = extraFuel + getFuelRequirement(addedFuel);
			System.out.println("+ " + getFuelRequirement(addedFuel));
			addedFuel = getFuelRequirement(addedFuel);
		}

		return extraFuel;
	}

	private static void loadInput(String filename){
		AdventTools toolkit = new AdventTools();
		fuelModules = toolkit.getInputInteger("input.txt");
	}

	private static int getTotalRequiredFuel(){
		int totalReq = 0;

		loadInput("input.txt");
		for(int fuelMass : fuelModules){
			int fuelReq = getFuelRequirement(fuelMass);
			int addedFuel = (fuelReq + getFuelForFuel(fuelReq));
			totalReq = totalReq + addedFuel;
		}

		return totalReq;
	}

	public static void main(String[] args) {
		System.out.println(getTotalRequiredFuel() + "\n---------------\nTotal Fuel Required");

		System.out.println(getFuelRequirement(1969) + getFuelForFuel(getFuelRequirement(1969)));
	}
}