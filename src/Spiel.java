
public class Spiel implements FourWinsLogic {

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
		if (hatGewonnenHorizontal(spieler, spalte)) {
			return Ergebnis.GEWINNT;
		}
		if (hatGewonnenVertikal(spieler, spalte, this.getChripVertikal(spalte))) {
			return Ergebnis.GEWINNT;
		}

		return Ergebnis.UNBEKANNT;
	}

	private boolean hatGewonnenVertikal(Spieler spieler, int spalte, int zeile) {
		if (spalte >= 3) {
			if (this.spielfeld[spalte - 1][zeile] == spieler && this.spielfeld[spalte - 2][zeile] == spieler
					&& this.spielfeld[spalte - 3][zeile] == spieler) {
				return true;
			}
		}
		if (spalte >= 2 && spalte < 6) {
			if (this.spielfeld[spalte - 1][zeile] == spieler && this.spielfeld[spalte - 2][zeile] == spieler
					&& this.spielfeld[spalte + 1][zeile] == spieler) {
				return true;
			}
		}
		if (spalte >= 1 && spalte <5) {
			if (this.spielfeld[spalte - 1][zeile] == spieler && this.spielfeld[spalte + 1][zeile] == spieler
					&& this.spielfeld[spalte + 2][zeile] == spieler) {
				return true;
			}
		}
		if (spalte < 4) {
			if (this.spielfeld[spalte + 1][zeile] == spieler && this.spielfeld[spalte + 2][zeile] == spieler
					&& this.spielfeld[spalte + 3][zeile] == spieler) {
				return true;
			}
		}
		return false;
	}

	private boolean hatGewonnenHorizontal(Spieler spieler, int spalte) {
		// 1. Fall 0=x,1=x,2=x,3=x
		if ((this.spielfeld[spalte][0] == spieler) && (this.spielfeld[spalte][1] == spieler)
				&& (this.spielfeld[spalte][2] == spieler) && (this.spielfeld[spalte][3] == spieler)) {
			return true;
		}
		// 2. Fall 1=x,2=x,3=x,4=x
		if ((this.spielfeld[spalte][1] == spieler) && (this.spielfeld[spalte][2] == spieler)
				&& (this.spielfeld[spalte][3] == spieler) && (this.spielfeld[spalte][4] == spieler)) {
			return true;
		}
		// 3. Fall 2=x,3=x,4=x,5=x
		if ((this.spielfeld[spalte][2] == spieler) && (this.spielfeld[spalte][3] == spieler)
				&& (this.spielfeld[spalte][4] == spieler) && (this.spielfeld[spalte][5] == spieler)) {
			return true;
		}
		// 4. Fall 3=x,4=x,5=x,6=x
		if ((this.spielfeld[spalte][3] == spieler) && (this.spielfeld[spalte][4] == spieler)
				&& (this.spielfeld[spalte][5] == spieler) && (this.spielfeld[spalte][6] == spieler)) {
			return true;
		}
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

	private int getChripVertikal(int spalte) {
		for (int i = 0; i < 6; i++) {
			if (isFeldBelegt(spalte, i)) {
				System.out.println(i);
				return i;
			}
		}
		return 0;
	}
}
