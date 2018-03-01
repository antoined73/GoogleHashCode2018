package TuLeC.process;

import TuLeC.Obj.Car;
import TuLeC.Obj.Ride;

import java.util.List;

public class SimpleProcess {
    private List<Car> cars;
    private List<Ride> rides;

    public SimpleProcess(List<Car> cars, List<Ride> rides){
        this.cars = cars;
        this.rides = rides;
    }

    public void process(){
        int i = 0;
        for (Ride ride : rides){
            cars.get(i++%cars.size()).addRide(ride);
        }
    }
}
