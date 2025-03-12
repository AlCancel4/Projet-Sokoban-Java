package Sokoban;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Casevide extends immobile{
	
	//attribut
	protected boolean marquee;
	protected ImageIcon c;
	protected ImageIcon cm;
	
	//méthodes
	public Casevide() {
		super();
		marquee = false;
	}
	
	public Casevide(int x, int y, int hauteur, int largeur, boolean marquee) {
		super(x, y, hauteur, largeur);
		this.marquee = marquee;
		c = new ImageIcon("../src/Sokoban/plancher.png");
		cm = new ImageIcon("../src/Sokoban/diam.png");
	}
	
	public int getType() {
		if (!marquee) {
			return 3;
		}
		else {
			return 6;
		} 
	}
	
	public void dessiner(Graphics g) {
		if (marquee) {
			g.drawImage(cm.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
		}
		else {
			g.drawImage(c.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
		}
	}
}
