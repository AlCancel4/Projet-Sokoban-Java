package Sokoban;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class caisse extends mobile{
	
	//attribut
	protected boolean coloree = false;
	protected ImageIcon c;
	protected ImageIcon cm;
	
	//méthodes
	public caisse() {
		super();
		coloree = false;
	}
	
	public caisse(int x, int y, int hauteur, int largeur, boolean coloree) {
		super(x, y, hauteur, largeur);
		this.coloree = coloree;
		c = new ImageIcon("../src/Sokoban/caisse1.png");
		cm = new ImageIcon("../src/Sokoban/caisse.png");
	}
	
	public boolean getColoree() {
		return coloree;
	}
	
	public void setColoree(boolean coloree) {
		this.coloree = coloree;
	}
	
	public int getType() {
		if (!coloree) {
			return 1;
		}
		else {
			return 5;
		}
	}
	
	public void dessiner(Graphics g) {
		if (coloree) {
			g.drawImage(cm.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
		}
		else {
			g.drawImage(c.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
		}
	}
}
