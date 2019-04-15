package sunday_roast;

import java.util.ArrayList;

class superSecretSundayRoast {

    private ArrayList<ingredient> ingredients = new ArrayList<ingredient>();
    ArrayList<String> guestList = new ArrayList<String>();

    public void addIngredient(ingredient i){
        if(guestList.contains(i.ingredientName)) {
            this.ingredients.add(i);
        }
        else {
            System.out.println("EXTERMINATE!");
        }
    }

    public ArrayList<ingredient> getIngredients(String password){
        if(password.equals("strongpassword123")) {
            return this.ingredients;
        }
        else
            return null;
    }
}

