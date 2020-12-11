import java.util.*;
import java.io.*;

public class AdventTools {
    
    private static long startTime;
    private static long endTime;
    private static long elapsedTime;

    public static <E> void print(E item){
        System.out.println(item);
    }

    public static <E> void printList(ArrayList<E> list){
        for (E item : list){
            System.out.println(item);
        }
    }

    public static <E> void printArray(E[] array){
        for (E item : array){
            System.out.println(item);
        }
    }

    public static ArrayList<String> loadInput(int day){
        ArrayList<String> input = new ArrayList<String>();
        String filepath = "day" + String.valueOf(day) + ".txt";

        File inputFile = new File(filepath);

        try {
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()){
                String token = reader.nextLine();
                input.add(token);
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Couldn't load input file.");
        }

        return input;

    }

    public AdventTools() {

    }


}