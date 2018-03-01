import java.util.Arrays;

public class Context {
    int rows;
    int columns;
    int numberOfVehicles;
    int numberOfRides;
    int perRideBonus;
    int numberOfSteps;
    String[][] ingredients;


    public Context(int rows, int columns, int numberOfVehicles, int numberOfRides, int perRideBonus, int numberOfSteps) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfRides = numberOfRides;
        this.perRideBonus = perRideBonus;
        this.numberOfSteps = numberOfSteps;
    }

    public void AddRide(String[][] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString(){
        String msg = "A implementer";
        return msg;
    }
}
