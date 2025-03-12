package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class neant extends immobile{
	
	protected ImageIcon neant;
	
	//méthodes
	public neant() {
		super();
	}
	
	public neant(int x, int y, int hauteur, int largeur) {
		super(x, y, hauteur, largeur);
		neant = new ImageIcon("../src/Sokoban/feum.png");
	}
	
	public int getType() {
		return 0;
	}

	
	public void dessiner(Graphics g) {
		g.drawImage(neant.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
	}
}
