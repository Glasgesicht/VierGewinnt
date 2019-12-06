import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeTest {
    
    private TicTacToeLogic logic = new Spiel("TicTacToe");

    @Test
    public void setzeSteinLinksOben() {
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 0));
    }
    
    @Test
    public void setzeSteinAufBelegtesFeld() {
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 1, 2));
        assertEquals(Ergebnis.FEHLER, logic.setChip(Spieler.BLAU, 1, 2));
    }
    
    @Test
    public void setzeSteineDaneben() {
        assertEquals(Ergebnis.FEHLER, logic.setChip(Spieler.BLAU, 3, 3));
        assertEquals(Ergebnis.FEHLER, logic.setChip(Spieler.BLAU, -1, -1));
    }
    
    @Test
    public void gewinneHorizontal() {
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT,  0, 1));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 2, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT , 1, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 2));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT,  1, 1));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 2, 2));
        assertEquals(Ergebnis.GEWINNT,   logic.setChip(Spieler.ROT,  2, 1));
    }
    
    @Test
    public void gewinneVertikal() {
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT,  1, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 1));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT , 1, 1));
        assertEquals(Ergebnis.GEWINNT, logic.setChip(Spieler.BLAU, 0, 2));
    }
    
    @Test
    public void gewinneDiagonal() {
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 0, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT,  1, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 2, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT , 0, 1));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.BLAU, 1, 1));
        assertEquals(Ergebnis.UNBEKANNT, logic.setChip(Spieler.ROT,  2, 1));
        assertEquals(Ergebnis.GEWINNT,   logic.setChip(Spieler.BLAU, 2, 2));
    }
    
    @Test
    public void Unentschieden() {
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.BLAU, 1, 0));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.ROT,  2, 2));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.BLAU, 2, 1));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.ROT , 1, 1));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.BLAU, 0, 0));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.ROT,  2, 0));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.BLAU, 0, 2));
        assertEquals(Ergebnis.UNBEKANNT,     logic.setChip(Spieler.ROT,  0, 1));
        assertEquals(Ergebnis.UNENTSCHIEDEN, logic.setChip(Spieler.BLAU, 1, 2));
    }
    
}
