package TuLeC.Helper;

import TuLeC.Obj.Car;
import TuLeC.Obj.Intersection;
import TuLeC.Obj.Ride;

public class Helper {

    public static int getCarTimeToFinishRide(Car car, Ride ride){
        return getCarTimeToBeginRide(car, ride) + ride.startPoint.getDistanceFrom(ride.endPoint);
    }

    public static int getCarTimeToBeginRide(Car car, Ride ride){
        return car.getCurrentFinalTurn() + car.getCurrentFinalPosition().getDistanceFrom(ride.startPoint);
    }

    public static int getTimeFromStart(Ride ride){
        return ride.startPoint.getDistanceFrom(new Intersection(0, 0)) - ride.earliestStart;
    }
}
