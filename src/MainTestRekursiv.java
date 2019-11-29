import static org.junit.Assert.*;

import org.junit.Test;

public class MainTestRekursiv {
    
    private FourWinsLogic logic = new SpielRekursiv();

    @Test
    public void werfeSteinLinksUnten() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
    }
    @Test
    public void werfeSteinLinksUnten2() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 0));
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
    public void GewinnVertikalRot() {
    	 assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 5));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.BLAU, 5));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 5));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 5));
         assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 5));
         assertEquals(Ergebnis.GEWINNT, logic.throwChrip(Spieler.ROT, 5));
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
