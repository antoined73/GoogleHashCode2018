package TuLeC.Obj;

public class Ride {
    public Intersection startPoint;
    public Intersection endPoint;
    public int earliestStart;
    public int latestFinish;
    public int id;

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
