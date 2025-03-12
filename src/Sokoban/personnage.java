package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class personnage extends mobile{
	
	protected ImageIcon personnage;
	//méthodes
	public personnage() {
		super();
	}
	
	public personnage(int x, int y, int hauteur, int largeur) {
		super(x, y, hauteur, largeur);
		personnage = new ImageIcon("../src/Sokoban/spider.png");
	}
	
	public int getType() {
		return 2;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(personnage.getImage(), p.getX()*30,p.getY()*30,largeur, hauteur, null);
	}

	@Override
	public void setColoree(boolean coloree) {
		// TODO Auto-generated method stub
		
	}
}
