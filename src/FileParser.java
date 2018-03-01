import java.io.*;

public class FileParser {
    private final String filePath;
    private Context context;

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
                if(array1.length != 6) throw new Exception("La première ligne du fichier ne contient pas 6 chiffres séparés d'espaces.");
                int rows = Integer.parseInt(array1[0]);
                int columns = Integer.parseInt(array1[1]);
                int numberOfVehicles = Integer.parseInt(array1[2]);
                int numberOfRides = Integer.parseInt(array1[3]);
                int perRideBonus = Integer.parseInt(array1[4]);
                int numberOfSteps = Integer.parseInt(array1[5]);
                context = new Context(rows,columns,numberOfVehicles,numberOfRides,perRideBonus,numberOfSteps);
            }else{
                //Ajouter un ride
                context.AddRide (ingredients);
            }
            lineNumber++;

        }

    }

    public Context getContext() {
        return context;
    }
}
