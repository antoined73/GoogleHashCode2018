import TuLeC.Reader.FileParser;

public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("ressources/e_high_bonus.in");
        try {
            parser.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parser.getContext().toDebugString());
    }
}
