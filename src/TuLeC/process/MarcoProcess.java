package TuLeC.process;

import TuLeC.Helper.Helper;
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
                //Etre arrivé quand ça commence
                if (Helper.getCarTimeToBeginRide(car, ride) <= ride.earliestStart) {
                    car.rides.add(ride);
                    isAdded = true;
                    break;
                }
            }
            //Si on ne peut pas
            if (!isAdded) {
                SortCars(cars);
                for(Car car : cars) {
                    if (Helper.getCarTimeToFinishRide(car, ride) <= ride.latestFinish) {
                        car.rides.add(ride);
                        break;
                    }
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
        rides.add(new Ride(0, 1, 2, 3, 3, 5, 8));
        rides.add(new Ride(1, 2, 2, 5, 6, 7, 10));
        rides.add(new Ride(2, 0, 2, 3, 1, 2, 6));
        MarcoProcess marcoProcess = new MarcoProcess(cars, rides);
        System.out.println(marcoProcess.process());
    }
}
