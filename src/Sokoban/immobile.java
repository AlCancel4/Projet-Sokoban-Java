package Sokoban;

import java.awt.Graphics;

public abstract class immobile {
	
	//attributs
	protected coordonnees p;
	protected int hauteur;
	protected int largeur;
	
	//méthodes
	public immobile() {
		p = new coordonnees();
		hauteur = 0;
		largeur = 0;
	}
	
	public immobile(int x, int y, int hauteur, int largeur) {
		coordonnees c = new coordonnees(x,y);
		p = c;
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public int getX() {
		return p.getX();
	}
	
	public int getY() {
		return p.getY();
	}
	
	public abstract int getType(); 
	public abstract void dessiner(Graphics g);
}
