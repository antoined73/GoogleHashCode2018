import java.awt.*;

public class Ride {
    Intersection startPoint;
    Intersection endPoint;
    int earliestStart;
    int latestFinish;

    public Ride(int srow, int scolumn, int frow, int fcolumn, int earliestStart, int latestFinish) {
        this.startPoint = new Intersection(srow,scolumn);
        this.endPoint = new Intersection(frow,fcolumn);
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public String toDebugString() {
        return "Départ : "+startPoint+"/ Arrivée : "+endPoint+" | earliest: "+earliestStart+ " latest: "+latestFinish;
    }
}
