import TuLeC.Obj.Context;
import TuLeC.Reader.FileParser;
import TuLeC.process.SimpleProcess;

public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("ressources/a_example.in");
        try {
            parser.exec();
            Context context = parser.getContext();
            SimpleProcess proc = new SimpleProcess(context.getCars(),context.getRides());
            proc.process();

            System.out.println(context.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parser.getContext().toDebugString());
    }
}
