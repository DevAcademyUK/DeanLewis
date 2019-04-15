package animals;

public class cat {

    private String name;
    private String nature;
    private int age;


    public cat(String name, int age, String nature){
        this.name = name;
        this.age = age;
        this.nature = nature;
    }

    public String stroke(int age){
        String reaction;
        if(age <= 2){
            reaction = "Let's Play!";
        }
        else if(age < 5){
           reaction = "purr purr";
        }
        else {
            reaction = "Bring that hand any closer and I will make you bleed!";
        }
        return reaction;
    }

    public String speak(String name){
        return "Hello human slave, i'm " + name + ", your malevolent owner, now feed me!. " +
                "Oh, and there is a present for you to clean up in the kitchen.";
    }


}
