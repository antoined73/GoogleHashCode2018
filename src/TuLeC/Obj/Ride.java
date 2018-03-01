package TuLeC.Obj;

public class Ride {
    Intersection startPoint;
    Intersection endPoint;
    int earliestStart;
    int latestFinish;
    int id;

    public Ride(int id, int srow, int scolumn, int frow, int fcolumn, int earliestStart, int latestFinish) {
        this.id = id;
        this.startPoint = new Intersection(srow,scolumn);
        this.endPoint = new Intersection(frow,fcolumn);
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    @Override
    public String toString(){
        return String.valueOf(id);
    }

    public String toDebugString() {
        return "Départ : "+startPoint+"/ Arrivée : "+endPoint+" | earliest: "+earliestStart+ " latest: "+latestFinish;
    }
}
