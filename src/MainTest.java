import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
    
    private FourWinsLogic logic = new Spiel();

    @Test
    public void werfeSteinLinksUnten() {
        assertEquals(Ergebnis.UNBEKANNT, logic.throwChrip(Spieler.ROT, 0));
    }

}
