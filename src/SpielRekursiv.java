
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

    /*
     * //Versuch einer iterativen Lösung, funktioniert so nicht. private boolean
     * hatGewonnenDiagonal(Spieler spieler, int spalte, int zeile) {
     * if(spalte>=0&&spalte<=3) { if(zeile>=0&&zeile<=2) {
     * if((this.spielfeld[spalte-1][zeile-1]==spieler)&&(this.spielfeld[spalte-2][
     * zeile-2]==spieler)&&(this.spielfeld[spalte-3][zeile-3]==spieler)) { return
     * true; } } }
     * //if((this.spielfeld[0][0]==spieler)&&(this.spielfeld[1][1]==spieler)&&(this.
     * spielfeld[2][2]==spieler)&&(this.spielfeld[3][3]==spieler)) { // return true;
     * //} return false; }
     */
    
    private boolean isBesitzer(Spieler spieler, int spalte, int zeile) {
        return this.spielfeld[spalte][zeile] == spieler;
    }

    private boolean inSpielfeld(int spalte, int zeile) {
        return (spalte < 7 && spalte >= 0 && zeile < 6 && zeile >= 0);
    }

    private boolean hatGewonnenDiagonal(Spieler spieler, int spalte, int zeile) {
	    if((countTopLeft(spieler, spalte, zeile) + countBottomRight(spieler, spalte, zeile)) > 4)
	        return true;
	    if((countTopRight(spieler, spalte, zeile) + countBottomLeft(spieler, spalte, zeile)) > 4)
	        return true;
	    return false;
	}

    private int countTopLeft(Spieler spieler, int spalte, int zeile) {
	    if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile)) 
	        return 1 + countTopLeft(spieler,spalte-1,zeile+1);
	    return 0;
	}
    private int countTopRight(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countTopRight(spieler,spalte+1,zeile+1);
        return 0;
    }
    private int countBottomLeft(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countBottomLeft(spieler,spalte-1,zeile-1);
        return 0;
    }
    private int countBottomRight(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countBottomRight(spieler,spalte+1,zeile-1);
        return 0;
    }

    private boolean hatGewonnenVertikal(Spieler spieler, int spalte, int zeile) {
        if((countTop(spieler, spalte, zeile) + countBottom(spieler, spalte, zeile)) > 4)
            return true;
        return false;
    }
    
    private int countLeft(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countLeft(spieler,spalte-1,zeile);
        return 0;
    }
    private int countRight(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countRight(spieler,spalte+1,zeile);
        return 0;
    }

    private boolean hatGewonnenHorizontal(Spieler spieler, int spalte, int zeile) {
        if((countLeft(spieler, spalte, zeile) + countRight(spieler, spalte, zeile)) > 4)
            return true;
        return false;
    }
    
    private int countTop(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countTop(spieler,spalte,zeile+1);
        return 0;
    }
    
    private int countBottom(Spieler spieler, int spalte, int zeile) {
        if(inSpielfeld(spalte, zeile) && isBesitzer(spieler, spalte, zeile))
            return 1 + countBottom(spieler,spalte,zeile-1);
        return 0;
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
