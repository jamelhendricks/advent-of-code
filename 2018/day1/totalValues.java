import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class totalValues {

	private static int sumFrequenciesFromFile(String path){
		int freq = 0;

		try {
			File input = new File(path);
			Scanner readfile = new Scanner(input);

			readfile.useDelimiter("\n");

			while(readfile.hasNext()){
				String nextFreq = readfile.next();
				freq = freq + Integer.valueOf(nextFreq);
			}


		} catch(FileNotFoundException e) {
			System.out.printf("%s not found!\n", path);
			System.exit(1);
		}

		return freq;
	}


	public static void main(String[] args) {

		System.out.printf("Total Frequencies: %d\n", sumFrequenciesFromFile("input.txt"));
		
	}
}
