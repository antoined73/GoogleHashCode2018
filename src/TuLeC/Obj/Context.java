package TuLeC.Obj;

import java.util.ArrayList;
import java.util.List;

public class Context {
    int rows;
    int columns;
    int numberOfVehicles;
    int numberOfRides;
    int perRideBonus;
    int numberOfSteps;
    int id;
    List<Ride> rides = new ArrayList<Ride>();


    public Context(int rows, int columns, int numberOfVehicles, int numberOfRides, int perRideBonus, int numberOfSteps) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfRides = numberOfRides;
        this.perRideBonus = perRideBonus;
        this.numberOfSteps = numberOfSteps;
        id = 0;
    }

    public void AddRide(int srow, int scolumn, int frow, int fcolumn, int earliestStart, int latestFinish) {
        rides.add(new Ride(id++, srow,scolumn,frow,fcolumn,earliestStart,latestFinish));
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Ride ride: rides) {
            res.append(ride.toString());
        }
        return res.toString();
    }

    public String toDebugString(){
        StringBuilder msg = new StringBuilder("Contexte : Ville " + rows + " x " + columns + ", "
                + numberOfRides + " trajets à faire avec " + numberOfVehicles + " voitures en " + numberOfSteps + " steps.\n");
        for (Ride ride: rides) {
            msg.append(ride.toDebugString());
            msg.append("\n");
        }
        return msg.toString();
    }
}
