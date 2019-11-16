import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;


public class checkBoxID {

	private static int twoLetterIDs =0;
	private static int threeLetterIDs =0;

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



	public static void main(String[] args) {
		checkSumIDs("input.txt");
	}






}