import java.io.*;

public class FileParser {
    private final String filePath;
    private  Pizza pizza;

    public FileParser(String s) {
        filePath = s;
    }

    public void exec() throws Exception {
        FileReader input = null;
        input = new FileReader(filePath);
        BufferedReader bufRead = new BufferedReader(input);

        String myLine = null;
        int lineNumber = 0;
        String[][] ingredients = null;
        while ( (myLine = bufRead.readLine()) != null)
        {
            if(lineNumber==0){
                String[] array1 = myLine.split(" ");
                if(array1.length != 4) throw new Exception("La première ligne du fichier ne contient pas chiffres séparés d'espaces.");
                int rows = Integer.parseInt(array1[0]);
                int columns = Integer.parseInt(array1[1]);
                int min = Integer.parseInt(array1[2]);
                int max = Integer.parseInt(array1[3]);
                pizza = new Pizza(rows,columns,min,max);
            }else{
                if(ingredients==null){
                    ingredients = new String[pizza.rows][pizza.columns];
                }
                ingredients[lineNumber-1] = myLine.split(" ");
            }
            lineNumber++;

        }
        pizza.AddIngredients(ingredients);
    }

    public Pizza getPizza() {
        return pizza;
    }
}
