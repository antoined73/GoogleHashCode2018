public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("ressources/a_example.in");
        try {
            parser.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parser.getContext().toDebugString());
    }
}
