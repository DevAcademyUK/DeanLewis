package animals;

import java.util.Scanner;

public class createAnimal {

    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        createAnimal create = new createAnimal();
        create.getAnimalType();
    }

    private void getAnimalType(){
        System.out.println("What animal would you like to create?");
        String animal = myScanner.nextLine();

        if(animal.equalsIgnoreCase("dog")){
            createDog();
        }
        else if(animal.equalsIgnoreCase("cat")){
            createCat();
        }
        else {
            System.out.println(animal + " is not an animal we can currently create, please try again.");
        }

    }

    private void createCat() {
        System.out.println("What is the cats name?");
        String name = myScanner.nextLine();
        System.out.println("How old is the cat?");
        int age = Integer.parseInt(myScanner.nextLine());
        System.out.println("What is the cats nature?");
        String nature = myScanner.nextLine();
        cat myCat = new cat(name, age, nature);

        System.out.println(myCat.stroke(age));
        System.out.println(myCat.speak(name));

        getAnimalType();
    }

    private void createDog() {
        System.out.println("What is the dogs name?");
        String name = myScanner.nextLine();
        System.out.println("How big is the dog?");
        String size = myScanner.nextLine();
        System.out.println("How old is the dog?");
        int age = Integer.parseInt(myScanner.nextLine());
        System.out.println("What breed is the dog?");
        String breed = myScanner.nextLine();
        dog myDog = new dog(name, size, age, breed);

        System.out.println(myDog.bark(size));
        System.out.println(myDog.play(breed));
        System.out.println(myDog.beHuman(name, age, breed));

        getAnimalType();
    }

}
