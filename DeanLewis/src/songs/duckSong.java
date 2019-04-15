package songs;

import java.util.Scanner;

public class duckSong {

    public static void main(String[] args){

        duckSong duckies = new duckSong();
        duckies.sing();

    }

    private void sing() {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many ducks are there?");
        int numOfDucks = myScanner.nextInt();

        String word = "ducks";
        for(int i =  numOfDucks; i > 0; i--){
            System.out.println(i + " little " + word + " went swimming one day,");
            System.out.println("Over the hills and far away,");
            System.out.println("Mother duck said Quack, Quack, Quack, Quack,");
            int newDuckNum = i - 1;
            if(newDuckNum > 1){
                System.out.println("But only " + newDuckNum + " little " + word + " came back");
            }
            else if(newDuckNum == 1){
                word = "Duck";
                System.out.println("But only " + newDuckNum + " little " + word + " came back");
            }
            else
                System.out.println("and all of her little ducks came back");
        }

    }


}
