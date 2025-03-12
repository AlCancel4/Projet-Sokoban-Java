package Sokoban;

import java.awt.Graphics;

public abstract class mobile {
	
	//attributs
	protected coordonnees p;
	protected int hauteur;
	protected int largeur;
	
	//méthodes
	public mobile() {
		p = new coordonnees();
		hauteur = 0;
		largeur = 0;
	}
	
	public mobile(int x, int y, int hauteur, int largeur) {
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
	
	public void deplacer(int dx, int dy) {
		p.setX(p.getX() + dx);
		p.setY(p.getY() + dy);
	}
	
	public abstract int getType(); 
	public abstract void dessiner(Graphics g);
	public abstract void setColoree(boolean coloree);
}
