package TuLeC.Reader;

import TuLeC.Obj.Context;

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
                String[] lineArray = myLine.split(" ");
                if(lineArray.length != 6) throw new Exception("La première ligne du fichier ne contient pas 6 chiffres séparés d'espaces.");
                int rows = Integer.parseInt(lineArray[0]);
                int columns = Integer.parseInt(lineArray[1]);
                int numberOfVehicles = Integer.parseInt(lineArray[2]);
                int numberOfRides = Integer.parseInt(lineArray[3]);
                int perRideBonus = Integer.parseInt(lineArray[4]);
                int numberOfSteps = Integer.parseInt(lineArray[5]);
                context = new Context(rows,columns,numberOfVehicles,numberOfRides,perRideBonus,numberOfSteps);
            }else{
                //Ajouter un ride
                String[] lineArray = myLine.split(" ");
                int Srow = Integer.parseInt(lineArray[0]);
                int Scolumn = Integer.parseInt(lineArray[1]);
                int Frow = Integer.parseInt(lineArray[2]);
                int Fcolumn = Integer.parseInt(lineArray[3]);
                int earliestStart = Integer.parseInt(lineArray[4]);
                int latestFinish = Integer.parseInt(lineArray[5]);
                context.AddRide (Srow, Scolumn, Frow, Fcolumn, earliestStart, latestFinish);
            }
            lineNumber++;

        }

    }

    public Context getContext() {
        return context;
    }
}
