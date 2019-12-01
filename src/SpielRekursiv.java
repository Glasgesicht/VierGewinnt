
public class SpielRekursiv implements FourWinsLogic {

    Spieler spielfeld[][] = new Spieler[7][6];

    // hallo Phill
    @Override
    public Ergebnis throwChrip(Spieler spieler, int spalte) {
        if (!isGueltigerZug(spalte)) {
            return Ergebnis.FEHLER;
        }
        if (isSpalteVoll(spalte)) {
            return Ergebnis.FEHLER;
        }
        // setze Chrip
        for (int i = 0; i < 6; i++) {
            if (!isFeldBelegt(spalte, i)) {
                this.spielfeld[spalte][i] = spieler;
                break;
            }
        }
        if (hatGewonnenHorizontal(spieler, spalte,this.getZeile(spalte))) {
            return Ergebnis.GEWINNT;
        }
        if (hatGewonnenVertikal(spieler, spalte, this.getZeile(spalte))) {
            return Ergebnis.GEWINNT;
        }
        if (hatGewonnenDiagonal(spieler, spalte, this.getZeile(spalte))) {
            return Ergebnis.GEWINNT;
        }

        return Ergebnis.UNBEKANNT;
    }
    
    private boolean isBesitzer(Spieler spieler, int spalte, int zeile) {
        return this.spielfeld[spalte][zeile] == spieler;
    }

    private boolean inSpielfeld(int spalte, int zeile) {
        return (spalte < 7 && spalte >= 0 && zeile < 6 && zeile >= 0);
    }

    private boolean hatGewonnenDiagonal(Spieler spieler, int spalte, int zeile) {
	    if((countDir(spieler, spalte, zeile,Richtung.OBENLINKS) + countDir(spieler, spalte, zeile,Richtung.UNTENRECHTS)) > 4)
	        return true;
	    if((countDir(spieler, spalte, zeile,Richtung.OBENRECHTS) + countDir(spieler, spalte, zeile,Richtung.UNTENLINKS)) > 4)
	        return true;
	    return false;
	}
    
    private int countDir(Spieler spieler, int spalte, int zeile, Richtung dir) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile)) 
            return 1 + countDir(spieler,spalte+dir.horizontal,zeile+dir.vertikal,dir);
        return 0;
    }
    private boolean hatGewonnenVertikal(Spieler spieler, int spalte, int zeile) {
        if(countDir(spieler, spalte, zeile,Richtung.UNTEN) > 3)
            return true;
        return false;
    }

    private boolean hatGewonnenHorizontal(Spieler spieler, int spalte, int zeile) {
        if((countDir(spieler, spalte, zeile,Richtung.LINKS) + countDir(spieler, spalte, zeile,Richtung.RECHTS)) > 4)
            return true;
        return false;
    }

    private boolean isGueltigerZug(int spalte) {
        if (spalte < 0 || spalte > 6) {
            return false;
        }
        return true;
    }

    private boolean isFeldBelegt(int spalte, int zeile) {
        if (this.spielfeld[spalte][zeile] != null) {
            return true;
        }
        return false;
    }

    private boolean isSpalteVoll(int spalte) {
        if (isFeldBelegt(spalte, 5)) {
            return true;
        }
        return false;
    }

    private int getZeile(int spalte) {
        for (int i = 0; i < 6; i++) {
            if (!isFeldBelegt(spalte, i)) {
                return i-1;
            }
        }
        return 5;
    }
}
