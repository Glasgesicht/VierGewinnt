
public enum Richtung {
    LINKS(-1,0),RECHTS(1,0),UNTEN(0,-1),OBENLINKS(-1,+1),OBENRECHTS(+1,+1),UNTENLINKS(-1,-1),UNTENRECHTS(+1,-1);
    int horizontal, vertikal;
    Richtung(int h, int v){
        this.horizontal = h;
        this.vertikal = v;
    }
}
