package Gui_2016.GUI_Mädn.model;

public class Figur {
	private Spieler spieler;
	
	public Figur(Spieler spieler) {
		this.spieler = spieler;
	}
	public Spieler spieler() {
		return spieler;
	}
	public Farbe getFarbe() {
		return spieler.getFarbe();
	}
}
