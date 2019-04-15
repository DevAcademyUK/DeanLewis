package sunday_roast;

import java.util.ArrayList;
import java.util.Scanner;

public class makeRoast {

    superSecretSundayRoast roast = new superSecretSundayRoast();

    public static void main(String[] args) {
        makeRoast mr = new makeRoast();
        mr.addIngredients();
        mr.checkIngredients();
    }

    private void addIngredients(){
        roast.addIngredient(new ingredient("Chicken", 12));
        roast.addIngredient(new ingredient("Roast Potatoes", 200));
        roast.addIngredient(new ingredient("Broccoli", 4));
        roast.addIngredient(new ingredient("Cauliflower", 4));
        roast.addIngredient(new ingredient("Peas", 7000));
        roast.addIngredient(new ingredient("Carrots", 75));
        roast.addIngredient(new ingredient("Cabbages", 4));
        roast.addIngredient(new ingredient("Parsnips", 2));
        roast.addIngredient(new ingredient("Brussel Sprouts", -1));

        roast.addIngredient((new ingredient("Secret Ingredient", 1)));
    }

    private void checkIngredients(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("So, you want to view the ingredients eh? password first!");
        String password = myScanner.nextLine();
        ArrayList<ingredient> ingredients = roast.getIngredients(password);
        if(ingredients != null) {
            for (ingredient i : ingredients) {
                System.out.println("Ingredient: " + i.ingredientName +
                        ", Amount: " + i.ingredientQuantity);
            }
        }
        else
            System.out.println("Caught you!");
    }
}

