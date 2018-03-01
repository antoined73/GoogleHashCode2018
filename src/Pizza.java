import java.util.Arrays;

public class Pizza {
    int rows;
    int columns;
    int minIngredientsPerSlice;
    int maxIngredientPerSlice;
    String[][] ingredients;


    public Pizza(int rows, int columns, int min, int max) {
        this.rows = rows;
        this.columns = columns;
        this.minIngredientsPerSlice = min;
        this.maxIngredientPerSlice = max;
    }

    public void AddIngredients(String[][] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString(){
        String msg = "Pizza "+rows+" x "+columns+". "+minIngredientsPerSlice+" ingrédients min, "+maxIngredientPerSlice+" ingredients max.\n";
        msg+= Arrays.deepToString(ingredients);
        return msg;
    }
}
