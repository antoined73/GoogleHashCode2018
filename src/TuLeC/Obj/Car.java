package TuLeC.Obj;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public Intersection position;
    public List<Ride> rides;
    public int turn;

    public Car() {
        rides = new ArrayList<Ride>();
        position = new Intersection(0, 0);
    }

    public void moveTo(Intersection intersection) {
        this.position = intersection;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    /**
     * @return the position where the car will be after completing its rides
     */
    public Intersection getCurrentFinalPosition() {
        if (rides.isEmpty()) {
            return new Intersection(0, 0);
        }
        return rides.get(rides.size() - 1).endPoint;
    }

    /**
     * @return the turn at which the car will be available again after all its rides
     */
    public int getCurrentFinalTurn() {
        int total = 0;
        Intersection position = new Intersection(0, 0);
        for (Ride r : rides) {
            if(position.getDistanceFrom(r.startPoint) + total < r.earliestStart){
                total += (r.earliestStart - total) + r.startPoint.getDistanceFrom(r.endPoint);
            }
            else{
                total += position.getDistanceFrom(r.startPoint) + r.startPoint.getDistanceFrom(r.endPoint);
            }
            position = r.endPoint;
        }
        return total;
    }

    @Override
    public String toString() {
        if (rides.size() == 0) return "0";
        StringBuilder res = new StringBuilder(rides.size() + " ");
        for (Ride ride : rides) {
            res.append(ride.toString()).append(" ");
        }
        return res.toString();
    }

    public void addRide(Ride ride, int currentTurn){
        this.addRide(ride);
        this.turn = currentTurn
                + this.position.getDistanceFrom(ride.startPoint)
                + ride.startPoint.getDistanceFrom(ride.endPoint);
    }
}
