import TuLeC.Obj.Context;
import TuLeC.Reader.FileParser;
import TuLeC.Writer.FileWriter;
import TuLeC.process.SimpleProcess;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public final String INPUT_FOLDER = "ressources/inputs/";
    public final String OUTPUT_FOLDER = "ressources/outputs/";

    public void runAll(boolean verbose) {
        List<String> results = new ArrayList<String>();

        File[] files = new File(INPUT_FOLDER).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".in")) {
                results.add(file.getName());
            }
        }
        //run all
        for(String file : results){
            run(file,verbose);
        }
    }

    private void run(String inputFilename, boolean verbose) {
        FileParser parser = new FileParser(INPUT_FOLDER +inputFilename);
        try {
            parser.exec();
            Context context = parser.getContext();
            SimpleProcess proc = new SimpleProcess(context.getCars(),context.getRides());
            proc.process();
            FileWriter fileWriter = new FileWriter(context.getCars());
            fileWriter.exec(OUTPUT_FOLDER +inputFilename.replace(".in",".out"));

            if(verbose) {
                System.out.println(context.toString());
                System.out.println(parser.getContext().toDebugString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
