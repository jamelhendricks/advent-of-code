import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class sliceFabric{
	
	public static void main(String[] args) {

		ArrayList<String> claimlist = new ArrayList<String>();

		try{
			File inputfile = new File("input.txt");
			Scanner readfile = new Scanner(inputfile);

			readfile.useDelimiter("\n");

			while(readfile.hasNext()){
				claimlist.add(readfile.next());
			}

		} catch (FileNotFoundException e){
			System.out.printf("input.txt not found!\n");
		}

		for( String claims : claimlist){
			System.out.println(claims);
		}




	}
}
