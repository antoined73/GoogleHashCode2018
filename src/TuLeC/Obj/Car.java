package TuLeC.Obj;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public Intersection position;
    public List<Ride> rides;

    public Car(){
        rides = new ArrayList<Ride>();
        position = new Intersection(0, 0);
    }

    public void moveTo(Intersection intersection){
        this.position = intersection;
    }

    public void addRide(Ride ride){
        rides.add(ride);
    }

    @Override
    public String toString(){
        if(rides.size() == 0) return "0";
        StringBuilder res = new StringBuilder(rides.size() + " ");
        for (Ride ride: rides) {
            res.append(ride.toString()).append(" ");
        }
        return res.toString();
    }
}
