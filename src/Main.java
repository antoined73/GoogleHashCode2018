import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("ressources/medium.in");
        try {
            parser.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parser.getPizza());
    }
}
