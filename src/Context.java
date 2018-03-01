import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Context {
    int rows;
    int columns;
    int numberOfVehicles;
    int numberOfRides;
    int perRideBonus;
    int numberOfSteps;
    List<Ride> rides = new ArrayList<Ride>();


    public Context(int rows, int columns, int numberOfVehicles, int numberOfRides, int perRideBonus, int numberOfSteps) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfRides = numberOfRides;
        this.perRideBonus = perRideBonus;
        this.numberOfSteps = numberOfSteps;
    }

    public void AddRide(int srow, int scolumn, int frow, int fcolumn, int earliestStart, int latestFinish) {
        rides.add(new Ride(srow,scolumn,frow,fcolumn,earliestStart,latestFinish));
    }

    @Override
    public String toString(){
        String msg = "Contexte : Ville "+rows+" x "+columns+", "+numberOfRides+" trajets à faire avec "+numberOfVehicles+" voitures en "+numberOfSteps+" steps.\n";
        for (Ride ride: rides) {
            msg+=ride.toDebugString()+"\n";
        }
        return msg;
    }
}
