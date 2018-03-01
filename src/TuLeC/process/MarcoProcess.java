package TuLeC.process;

import TuLeC.Obj.Car;
import TuLeC.Obj.Ride;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MarcoProcess {
    private List<Car> cars;
    private List<Ride> rides;

    public MarcoProcess(List<Car> cars, List<Ride> rides){
        this.cars = cars;
        this.rides = rides;
    }

    public List<Car> process(){
        Collections.sort(rides, new Comparator<Ride>() {
            public int compare(Ride o1, Ride o2) {
                return o1.earliestStart - o2.earliestStart;
            }
        });
        for(Ride ride : rides) {
            boolean isAdded = false;
            for(Car car : cars) {
                if (car.getCurrentFinalTurn() + car.getCurrentFinalPosition().getDistanceFrom(ride.startPoint)<= ride.earliestStart) {
                    car.rides.add(ride);
                    isAdded = true;
                    break;
                }
                if (!isAdded) {
                    SortCars(cars);
                    cars.get(0).rides.add(ride);
                }
            }

        }

        return cars;
    }

    public void SortCars(List<Car> cars) {
        Collections.sort(cars, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                return o1.getCurrentFinalTurn() - o2.getCurrentFinalTurn();
            }
        });
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car());
        cars.add(new Car());
        List<Ride> rides = new ArrayList<Ride>();
        rides.add(new Ride(0, 0, 0, 0, 0, 5, 0));
        rides.add(new Ride(1, 0, 0, 0, 0, 7, 0));
        rides.add(new Ride(2, 0, 0, 0, 0, 2, 0));
        MarcoProcess marcoProcess = new MarcoProcess(cars, rides);
        System.out.println(marcoProcess.process());
    }
}
