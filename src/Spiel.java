
/**
 * Vier-Gewinnt Logik
 * @author Philipp P�rling, Bernhardt Alexander Scheibner
 * 
 */
public class Spiel implements FourWinsLogic, TicTacToeLogic {
	/**
	 * Spielfeld initialisiseren und gesetzte Steine zu Beginn des Spiels auf 0 setzen
	 */
    
    
    private Spieler spielfeld[][];
    private int gesetzteSteine = 0;
    private int gewinntSteine;

    
    Spiel(String type){
        if(type.equals("FourWins")) {
            this.spielfeld = new Spieler[7][6];
            this.gewinntSteine = 4;
        } else if(type.equals("TicTacToe")) {
            this.spielfeld = new Spieler[3][3];
            this.gewinntSteine = 3;
        }
    }
    

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
        for (int i = 0; i < spielfeld[0].length; i++) {
            if (!isFeldBelegt(spalte, i)) {
                this.spielfeld[spalte][i] = spieler;
                gesetzteSteine++;
                break;
            }
        }
        if (hatGewonnenHorizontal(spieler, spalte,this.getZeile(spalte))   ||
           (hatGewonnenVertikal  (spieler, spalte, this.getZeile(spalte))) ||
           (hatGewonnenDiagonal  (spieler, spalte, this.getZeile(spalte)))) {
            return Ergebnis.GEWINNT;
        }
        
        if(gesetzteSteine == spielfeld[0].length*spielfeld.length)
            return Ergebnis.UNENTSCHIEDEN;

        return Ergebnis.UNBEKANNT;
    }
    
    
    /**)
     * @see TicTacToeLogic#setChip(Spieler, int, int)
     */
    @Override
    public Ergebnis setChip(Spieler spieler, int horizontal, int vertikal) {
        
        
        if(!this.inSpielfeld(horizontal, vertikal))
            return Ergebnis.FEHLER;
        
        //Spielfeld befüllen 
        if(!isFeldBelegt(horizontal, vertikal)) {
            this.spielfeld[horizontal][vertikal]=spieler;
            gesetzteSteine++;
        } else {
            return Ergebnis.FEHLER;
        }
        
        if (hatGewonnenHorizontal(spieler, horizontal,vertikal)   ||
                (hatGewonnenVertikal  (spieler, horizontal, vertikal)) ||
                (hatGewonnenDiagonal  (spieler, horizontal, vertikal))) {
                 return Ergebnis.GEWINNT;
             }
        if(gesetzteSteine == spielfeld[0].length*spielfeld.length)
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
        return (spalte < spielfeld.length && spalte >= 0 && zeile < spielfeld[0].length && zeile >= 0);
    }

    /**
     * @param spieler: Zur Zeit ausgew�hlter Spieler
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @param zeile: Zeile in der der Chip landet
     * @return Gibt zur�ck ob der Spieler mit diesem Zug diagonal gewonnen hat
     */
    private boolean hatGewonnenDiagonal(Spieler spieler, int spalte, int zeile) {
	    if((countDir(spieler, spalte, zeile,Richtung.OBENLINKS)  + countDir(spieler, spalte, zeile,Richtung.UNTENRECHTS)) > gewinntSteine ||
	      ((countDir(spieler, spalte, zeile,Richtung.OBENRECHTS) + countDir(spieler, spalte, zeile,Richtung.UNTENLINKS))  > gewinntSteine))
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
        if(countDir(spieler, spalte, zeile,Richtung.UNTEN) > gewinntSteine-1)
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
        if((countDir(spieler, spalte, zeile,Richtung.LINKS) + countDir(spieler, spalte, zeile,Richtung.RECHTS)) > gewinntSteine)
            return true;
        return false;
    }

    /**
     * @param spalte: Spalte in die der Chip geworfen wurde
     * @return Gibt zur�ck ob Zug g�ltig ist
     */
    private boolean isGueltigerZug(int spalte) {
        if (spalte < 0 || spalte > spielfeld[0].length) {
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
        for (int i = 0; i < spielfeld[0].length; i++) {
            if (!isFeldBelegt(spalte, i)) {
                return i-1;
            }
        }
        return 5;
    }
}
