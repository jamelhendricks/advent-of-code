import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public class totalValues {

	private static HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();

	private static boolean checkMatch(int frequency){

		if (seen.containsKey(frequency)){
			return true;
		} else {
			return false;
		}

	}

	private static int findMatchingFrequency(String path){
		int freq = 0;
		boolean foundMatch = false;

		// creates new scanners when reached end of input file
		while (!foundMatch){

			try {
				File input = new File(path);
				Scanner readfile = new Scanner(input);

				readfile.useDelimiter("\n");

				while(readfile.hasNext()){
					String nextFreq = readfile.next();
					freq = freq + Integer.valueOf(nextFreq);
					
					if(checkMatch(freq)){
						System.out.println("First match was " + freq);
						return freq;
					} 

					seen.put(freq, true);
				}

			} catch(FileNotFoundException e) {
				System.out.printf("%s not found!\n", path);
				System.exit(1);
			}
		}

		return freq;
	}


	public static void main(String[] args) {

		findMatchingFrequency("input.txt");
		
	}
}
