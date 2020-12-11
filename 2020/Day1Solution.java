import java.util.*;
import java.io.*;

public class Day1Solution {

    private static AdventTools kit = new AdventTools();
    public static ArrayList<String> input = new ArrayList<String>();

    // naive solution for part one
    // nested for loop to find the combination
    public static int naiveSol1(){
        input = kit.loadInput(1);
        int numberOne = 0;
        int numberTwo = 0;
        int sum = 0;

        for (int i = 0; i < input.size(); i++){
            numberOne = Integer.valueOf(input.get(i));


            for (int h = 0; h < input.size(); h++){
                numberTwo = Integer.valueOf(input.get(h));
                sum = numberOne + numberTwo;

                if (sum == 2020){
                    kit.print("Number One: " + numberOne);
                    kit.print("Number Two: " + numberTwo);
                    return numberOne * numberTwo;
                }
            }
        }

        kit.print("Could not find the pair!");
        return -1;
    }

    // naive solution for part two
    // nested for loop to find the combination
    public static int naiveSol2(){
        input = kit.loadInput(1);
        int numberOne = 0;
        int numberTwo = 0;
        int numberThree = 0;
        int sum = 0;

        for (int i = 0; i < input.size(); i++){
            numberOne = Integer.valueOf(input.get(i));


            for (int h = 0; h < input.size(); h++){
                numberTwo = Integer.valueOf(input.get(h));

                for (int g = 0; g < input.size(); g++){
                    numberThree = Integer.valueOf(input.get(g));
                    sum = numberOne + numberTwo + numberThree;

                    if (sum == 2020){
                        kit.print("Number One: " + numberOne);
                        kit.print("Number Two: " + numberTwo);
                        kit.print("Number Three: " + numberThree);
                        return numberOne * numberTwo * numberThree;
                    }
                }


            }
        }

        kit.print("Could not find the pair!");
        return -1;
    }

    public static void optimizedSol(){

    }






    public static void main(String[] args) {
        kit.print("Naive Solution Part One: " + naiveSol1());
        kit.print("Naive Solution Part Two: " + naiveSol2());
        
    }
}
