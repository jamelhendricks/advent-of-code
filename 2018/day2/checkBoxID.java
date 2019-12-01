import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class checkBoxID {

	private static int twoLetterIDs =0;
	private static int threeLetterIDs =0;
	private static ArrayList<String> oneOffStrings = new ArrayList<String>();
	private ArrayList<String> idList = new ArrayList<String>();


	public static void checkMatches(String input){

		HashMap<Character, Integer> currentString = new HashMap<Character, Integer>();


		// tally up all the characters in the input string
		for (int i = 0; i < input.length(); i++){

			if(!currentString.containsKey(input.charAt(i))){
				currentString.put(input.charAt(i), 1);
			} else {
				currentString.replace(input.charAt(i), currentString.get(input.charAt(i)) + 1);
			}

		}

		if (currentString.containsValue(2)){
			twoLetterIDs++;
		}

		if (currentString.containsValue(3)){
			threeLetterIDs++;
		}
	}


	public static void checkSumIDs(String path){

		try{

			File infile = new File(path);
			Scanner readfile = new Scanner(infile);
			readfile.useDelimiter("\n");

			while(readfile.hasNext()){
				checkMatches(readfile.next());
			}

			int checkSum = twoLetterIDs * threeLetterIDs;
			System.out.printf("The checksum for this list is %d\n", checkSum);


		} catch(FileNotFoundException e){
			System.out.printf("%s not found!", path);
		}
	}

	/*
	public static void findCorrectIDs(String path){

		try{

			File infile = new File(path);
			Scanner readfile = new Scanner(infile);
			readfile.useDelimiter("\n");


			// input file has lines, thus 250 IDs
			// do this for every line
			for (int i = 0; i < 250; i++){
				String line = readfile.next();

				for (int j = 0; j < 250; j++){

					// must create a new file reference to open and close
					// to avoid FNF exception of too many open files!

					File comparisonFile = new File(path);
					Scanner compscanner = new Scanner(comparisonFile);
					compscanner.useDelimiter("\n");

					String compline = "";

					// get the line we need
					for (int k = 0; k <= j; k++){
						compline = compscanner.next();

					}

					int differenceCount = 0;

					// find out how many differences the string has
					for (int h = 0; h < line.length(); h++){

						if (differenceCount >= 2){
							break;
						}

						if(line.charAt(h) !=  compline.charAt(h)){
							differenceCount++;
						} 
					}


					if (differenceCount == 1){
						// its a pair string
						System.out.println("found a one off!");
						oneOffStrings.add(compline);
					}

					compscanner.close();				
				}


			}


		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.printf("%s not found!", path);
		}
	}
	*/

	public static ArrayList<String> populateList(String filepath){
		
		ArrayList<String> boxIDs = new ArrayList<String>();

		try {

			File infile = new File(filepath);
			Scanner readfile = new Scanner(infile);
			readfile.useDelimiter("\n");

			while( readfile.hasNext() ){
				boxIDs.add(readfile.next());
			}

		} catch (Exception e){
			e.printStackTrace();
		}

		// error
		return boxIDs;
	}

	public static ArrayList<String> findOneOffPair(ArrayList<String> catalog){

		ArrayList<String> oneOffPair = new ArrayList<String>();
		/* 

		ASSUMPTION: There is only one pair of one off strings!!
		
		*/

		// for each element
		for(int i = 0; i < catalog.size(); i++){

			String sourceID = catalog.get(i);


			// compare to the remaining IDs
			for(int h = i+1; h < catalog.size(); h++){

				String compID = catalog.get(h);
				int differenceCount = 0;

				// iterate through the two IDs
				for (int j = 0; j < sourceID.length(); j++){

					if (differenceCount > 1){
						break;
					}

					if (sourceID.charAt(j) != compID.charAt(j)){
						differenceCount++;
					}

				}

				if (differenceCount == 1){
					oneOffPair.add(sourceID);
					oneOffPair.add(compID);
					return oneOffPair;
				}

			}



		}

		return oneOffPair;

	}


	public static void main(String[] args) {


		System.out.println(findOneOffPair(populateList("input.txt")));
	}

}




