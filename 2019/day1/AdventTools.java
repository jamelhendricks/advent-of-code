import java.io.*;
import java.util.*;

public class AdventTools {

	// All input-getter methods assume data input file is in the same directory **


	protected ArrayList<String> getInputString(String filename){
		ArrayList<String> inputData = new ArrayList<String>();

		try{
			File infile = new File("input.txt");
			Scanner reader = new Scanner(infile);

			while (reader.hasNext()){
				inputData.add(reader.nextLine());
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found!");
		}

		return inputData;
	}

	protected ArrayList<Integer> getInputInteger(String filename){
		ArrayList<Integer> inputData = new ArrayList<Integer>();

		try{
			File infile = new File("input.txt");
			Scanner reader = new Scanner(infile);

			while (reader.hasNext()){
				inputData.add(reader.nextInt());
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found!");
		}

		return inputData;
	}
}