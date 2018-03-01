public class Intersection {
    public int x;    // x-coordinate
    public int y;    // y-coordinate

    // point initialized from parameters
    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistanceFrom(Intersection i2){
        return Math.abs(x - i2.x) + Math.abs(y - i2.y);
    }

}
