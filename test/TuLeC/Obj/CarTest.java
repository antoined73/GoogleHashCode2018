package TuLeC.Obj;

import org.junit.Assert;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @org.junit.Before
    public void setUp() throws Exception {
        car = new Car();
        car.addRide(new Ride(0, 0, 0, 3, 3, 0, 10));
        car.addRide(new Ride(1, 3, 3, 7, 6, 4, 15));
        car.addRide(new Ride(2, 7, 6, 4, 2, 6, 20));
        car.addRide(new Ride(3, 5, 3, 7, 3, 23, 24));
    }

    @org.junit.Test
    public void getCurrentFinalPosition() {
        Assert.assertEquals(car.getCurrentFinalPosition().x, 4);
        Assert.assertEquals(car.getCurrentFinalPosition().y, 2);
    }

    @org.junit.Test
    public void getCurrentFinalTurn() {
        Assert.assertEquals(25, car.getCurrentFinalTurn());
    }
}