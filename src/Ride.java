import java.awt.*;

public class Ride {
    Point startPoint;
    Point endPoint;
    int earliestStart;
    int latestFinish;

    public Ride(int srow, int scolumn, int frow, int fcolumn, int earliestStart, int latestFinish) {
        this.startPoint = new Point(srow,scolumn);
        this.endPoint = new Point(frow,fcolumn);
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public String toDebugString() {
        return "à faire";
    }
}
