package TuLeC.Writer;

import TuLeC.Obj.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
    List<Car> cars;

    public FileWriter(List<Car> cars){
        this.cars = new ArrayList<Car>(cars);
    }

    public void exec(){
        try{
            PrintWriter writer = new PrintWriter("output.out", "UTF-8");

            for (Car car : cars){
                writer.println(car.toString());
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
