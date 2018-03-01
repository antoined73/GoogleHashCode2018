import TuLeC.Obj.Context;
import TuLeC.Reader.FileParser;
import TuLeC.Writer.FileWriter;
import TuLeC.process.SimpleProcess;

public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("ressources/a_example.in");
        try {
            parser.exec();
            Context context = parser.getContext();
            SimpleProcess proc = new SimpleProcess(context.getCars(),context.getRides());
            proc.process();

            FileWriter fileWriter = new FileWriter(context.getCars());
            fileWriter.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
