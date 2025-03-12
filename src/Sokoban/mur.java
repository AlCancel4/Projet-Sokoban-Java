package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class mur extends immobile{
	
	protected ImageIcon mur;
	
	//méthodes
	public mur() {
		super();
	}
	
	public mur(int x, int y, int hauteur, int largeur) {
		super(x, y, hauteur, largeur);
		mur = new ImageIcon("../src/Sokoban/mur.png");
	}
	
	public int getType() {
		return 4;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(mur.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
	}
}
