package inheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class vehicleController {

    Scanner myScanner = new Scanner(System.in);
    ArrayList<vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        vehicleController vc = new vehicleController();
        vc.menu();
    }

    private void menu(){
        System.out.println("Which vehicle would you like to create today?");
        System.out.println("1 - Car");
        System.out.println("2 - Bus");
        System.out.println("3 - Truck");
        System.out.println("4 - Train");
        System.out.println("5 - Motorbike");
        System.out.println("6 - Bicycle");
        int input = Integer.parseInt(myScanner.nextLine());
        System.out.println();

        switch(input){
            case 1:
                createCar();
                break;

            case 2:
                createBus();
                break;

            case 3:
                createTruck();
                break;

            case 4:
                createTrain();
                break;

            case 5:
                createMotorbike();
                break;

            case 6:
                createBicycle();
                break;

            default:
                System.out.println("Incorrect input provided, please try again.");
                menu();
        }

    }

    private void createBicycle() {

    }

    private void createMotorbike() {

    }

    private void createTrain() {

    }

    private void createTruck() {

    }

    private void createBus() {

    }

    private void createCar() {
        car c = new car((short)5, (short)4);
        vehicles.add(c);
        c.changeGear(1);
        c.accelerate();
        c.changeGear(3);
        c.accelerate();



    }

    private void userActionMenu(){

        System.out.println("What would you like to do?");


    }

}
