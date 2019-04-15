package songs;

import java.util.Scanner;

public class singSong {
//add a random comment

    public static void main(String[] args){
        singSong singing = new singSong();
        singing.sing();
    }

    private void sing(){

        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many bottles of beer are there on the wall?");
        int bottles = myScanner.nextInt();

        String word = "bottles"; //a random comment
        for(int i = bottles; i > 0; i--){
            System.out.println(i + " " + word + " of beer on the wall.");
            System.out.println(i + " " + word + " of beer.");
            System.out.println("Take one down.");
            System.out.println("Pass it around.");
            if(i == 1){
                System.out.println("No more bottles of beer on the wall.");
            }
            else{
                int newNum = i - 1;
                if(newNum == 1){
                    word = "bottle";
                }
                System.out.println(newNum + " " + word + " of beer on the wall.");
                System.out.println();
            }
        }
    }
}
