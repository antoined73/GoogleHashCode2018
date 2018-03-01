package TuLeC.process;

import TuLeC.Obj.Car;
import TuLeC.Obj.Ride;

import java.util.Comparator;
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

        rides.sort(new Comparator<Ride>() {
            public int compare(Ride o1, Ride o2) {
                if (o1.earliestStart > o2.earliestStart){
                    return 1;
                } else if (o1.earliestStart == o2.earliestStart){
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (Ride ride : rides){
            cars.get(i++%cars.size()).addRide(ride);
        }
    }
}
