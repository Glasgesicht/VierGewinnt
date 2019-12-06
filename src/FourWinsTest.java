import static org.junit.Assert.*;

import org.junit.Test;

public class FourWinsTest {
    
    private FourWinsLogic logic = new Spiel("FourWins");

    @Test
    public void werfeSteinLinksUnten() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
    }
    @Test
    public void werfeSteinRechtsUnten2() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
    }
    @Test
    public void werfeSteinRechtsDanaben() {
        assertEquals(Ergebnis.FEHLER, logic.throwChrip(Spieler.ROT, 7));
    }
    @Test
    public void werfeSteinLinksDaneben() {
    	assertEquals(Ergebnis.FEHLER, logic.throwChrip(Spieler.ROT, -1));
    }
    
    @Test
    public void befuelleLinkeSpalte() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
        assertEquals(Ergebnis.FEHLER, logic.throwChrip(Spieler.BLAU, 0));
    }
    
    @Test
    public void befuelleRechteSpalte() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
        assertEquals(Ergebnis.FEHLER, logic.throwChrip(Spieler.BLAU, 6));
    }
    
    @Test
    public void spieleUnentschieden() {

        for(int i = 0; i<6;i+=2) {
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+0));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+0));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+0));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+0));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+0));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+0));
            
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+1));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+1));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, i+1));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+1));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+1));
            assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, i+1));
    }
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
        assertEquals(Ergebnis.UNENTSCHIEDEN, logic.throwChrip(Spieler.BLAU, 6));    
    }
    
    
    @Test
    public void GewinnVertikalRot() {
    	 assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  0));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  0));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  0));
         assertEquals(Ergebnis.GEWINNT, logic.throwChrip(Spieler.ROT,    0));
    }
    
    @Test
    public void GewinnVertikalRot2() {
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 6));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  6));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  6));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT,  6));
         assertEquals(Ergebnis.GEWINNT, logic.throwChrip(Spieler.ROT,    6));
    }
    
    @Test
    public void GewinnHorizontalBlau() {
    	 assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 6));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 1));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 1));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 3));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
         assertEquals(Ergebnis.GEWINNT, logic.throwChrip(Spieler.BLAU, 2));
    }
    @Test
    public void GewinntDiagonalBlau() {
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 1));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 2));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 3));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 1));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 2));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 3));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 2));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 1));
    	assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 3));
    	assertEquals(Ergebnis.GEWINNT, logic.throwChrip(Spieler.BLAU, 3));
    }
}
