package TuLeC.process;

import TuLeC.Obj.Car;
import TuLeC.Obj.Ride;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LuluProcess {
    private List<Car> cars;
    private List<Ride> rides;

    public LuluProcess(List<Car> cars, List<Ride> rides){
        this.cars = cars;
        this.rides = rides;
    }

    public void process(){
        int turn = 0;

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

        while(!rides.isEmpty()){
            List<Ride> toRemove = new ArrayList<>();
            for(Ride ride : rides){
                if(ride.latestFinish <= turn){
                    toRemove.add(ride);
                } else {
                    List<Car> availableCars = getAvailable(this.cars,turn);

                    if (!availableCars.isEmpty()) {
                        availableCars.sort(new Comparator<Car>() {
                            @Override
                            public int compare(Car o1, Car o2) {
                                if (o1.getCurrentFinalPosition().getDistanceFrom(ride.startPoint)
                                        >
                                        o2.getCurrentFinalPosition().getDistanceFrom(ride.startPoint)) {
                                    return 1;
                                } else if (o1.getCurrentFinalPosition().getDistanceFrom(ride.startPoint)
                                        <
                                        o2.getCurrentFinalPosition().getDistanceFrom(ride.startPoint)) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }});

                        availableCars.get(0).addRide(ride,turn);
                        toRemove.add(ride);
                    }
                }
            }
            rides.removeAll(toRemove);
            turn++;
        }
    }

    public List<Car> getAvailable(List<Car> cars, int currentTurn){
        List<Car> available = new ArrayList<>();

        for (Car car : cars){
            if(car.turn >= currentTurn){
                available.add(car);
            }
        }

        return available;
    }
}
