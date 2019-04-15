package inheritance;

import java.util.Scanner;

public class vehicle {

    public short numberOfSeats;
    public short numberOfWheels;
    public int currentGear;
    public int maxSpeed;
    public String colour;

    Scanner myScanner = new Scanner(System.in);

    public void accelerate() {
        System.out.println("I accelerate by turning my wheels!");
        System.out.println("What speed would you like to go?");
        int speed = Integer.parseInt(myScanner.nextLine());
        if(speed <= maxSpeed){
            System.out.println("You are now travelling at " + speed);
        }
        else {
            System.out.println("You can't go that fast in this gear!");
        }
    }

    public void brake(){
        System.out.println("I brake by applying pressure to brake discs on my wheels");
    }

    public void steer(String dir){}

    public void changeGear(int gear){
        this.currentGear = gear;
        maxSpeed = (short)gear * (short)20;
    }


}
