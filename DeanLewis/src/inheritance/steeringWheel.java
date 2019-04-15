package inheritance;

public class steeringWheel extends vehicle{

    public void steer(String dir){
        System.out.println("I can turn " + dir +
                " by spinning the steering wheel to the " +
                dir + ", no leaning required!");
    }
}
