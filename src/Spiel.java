
/**
 * Vier-Gewinnt Logik
 * @author Philipp P�rling, Bernhardt Alexander Scheibner
 * 
 */
public class Spiel implements FourWinsLogic {
	/**
	 * Spielfeld initialisiseren und gesetzte Steine zu Beginn des Spiels auf 0 setzen
	 */
    Spieler spielfeld[][] = new Spieler[7][6];
    int gesetzteSteine = 0;

    /**
     *@author Philipp, Bernd
     *@param spieler: aktueller Spieler
     *@param spalte: In welche Spalte der Chip geworfen werden soll
     *@return gibt Status des Spiels aus Enum als Ergebnis zur�ck
     */
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
                gesetzteSteine++;
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
        
        if(gesetzteSteine == 6*7)
            return Ergebnis.UNENTSCHIEDEN;

        return Ergebnis.UNBEKANNT;
    }
    
    /**
     * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob der Spieler mit einem seiner Steine die Zeile in der Spalte belegt
     */
    private boolean isBesitzer(Spieler spieler, int spalte, int zeile) {
        return this.spielfeld[spalte][zeile] == spieler;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob Chip sich im Spielfeld befindet
     */
    private boolean inSpielfeld(int spalte, int zeile) {
        return (spalte < 7 && spalte >= 0 && zeile < 6 && zeile >= 0);
    }

    /**
     * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob der Spieler mit diesem Zug diagonal gewonnen hat
     */
    private boolean hatGewonnenDiagonal(Spieler spieler, int spalte, int zeile) {
	    if((countDir(spieler, spalte, zeile,Richtung.OBENLINKS) + countDir(spieler, spalte, zeile,Richtung.UNTENRECHTS)) > 4)
	        return true;
	    if((countDir(spieler, spalte, zeile,Richtung.OBENRECHTS) + countDir(spieler, spalte, zeile,Richtung.UNTENLINKS)) > 4)
	        return true;
	    return false;
	}
    
    /**
     * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @param dir: Richtung in welche gepr�ft werden soll
     * @return Gibt Anzahl von Chips ab einem Startpunkt in Abh�ngigkeit der Richtung und der Farbe des Spielers zur�ck
     */
    private int countDir(Spieler spieler, int spalte, int zeile, Richtung dir) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile)) 
            return 1 + countDir(spieler,spalte+dir.horizontal,zeile+dir.vertikal,dir);
        return 0;
    }
    /**
     * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob der Spieler mit diesem Zug vertikal gewonnen hat
     */
    private boolean hatGewonnenVertikal(Spieler spieler, int spalte, int zeile) {
        if(countDir(spieler, spalte, zeile,Richtung.UNTEN) > 3)
            return true;
        return false;
    }

    /**
       * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob der Spieler mit diesem Zug horizontal gewonnen hat
     */
    private boolean hatGewonnenHorizontal(Spieler spieler, int spalte, int zeile) {
        if((countDir(spieler, spalte, zeile,Richtung.LINKS) + countDir(spieler, spalte, zeile,Richtung.RECHTS)) > 4)
            return true;
        return false;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @return Gibt zur�ck ob Zug g�ltig ist
     */
    private boolean isGueltigerZug(int spalte) {
        if (spalte < 0 || spalte > 6) {
            return false;
        }
        return true;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob ausgew�hltes Feld aktuell belegt ist.
     */
    private boolean isFeldBelegt(int spalte, int zeile) {
        if (this.spielfeld[spalte][zeile] != null) {
            return true;
        }
        return false;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @return Gibt zur�ck ob ausgew�hlte Spalte voll ist
     */
    private boolean isSpalteVoll(int spalte) {
        if (isFeldBelegt(spalte, 5)) {
            return true;
        }
        return false;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @return Gibt die oberste Zeile der ausgew�hlten Spalte zur�ck
     */
    private int getZeile(int spalte) {
        for (int i = 0; i < 6; i++) {
            if (!isFeldBelegt(spalte, i)) {
                return i-1;
            }
        }
        return 5;
    }
}
