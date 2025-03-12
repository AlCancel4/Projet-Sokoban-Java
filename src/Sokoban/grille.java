package Sokoban;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class grille {
	
	//attributs
	protected int dim;
	protected int hauteur;
	protected int largeur;
	public ArrayList<immobile> grille;
	public ArrayList<mobile> grilleM;
	private ArrayList<Integer> entiers;
	
	
	//méthodes
	public grille() {
		hauteur = 18;
		largeur = 20;
		for (int i = 0; i<hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				grille.add(new mur(i,j, 50, 50));
			}
		}
	}
	
	
	public grille(String nomfile) throws FileNotFoundException{
		entiers = new ArrayList<Integer>();
		try (Scanner scan = new Scanner(new File(nomfile))) {
			while (scan.hasNextInt()) {
				entiers.add(scan.nextInt());
			}
			hauteur = entiers.get(0);
			largeur = entiers.get(1);
			dim = entiers.get(2);
			grille = new ArrayList<immobile>();
			grilleM = new ArrayList<mobile>();
			int cpt = 3;
			int num;
			for (int j=0; j <hauteur;j++) {
				for (int i=0; i<largeur; i++) {
					num = entiers.get(cpt);
					cpt+=1;
					switch(num) {
						case 0 :
							grille.add(new neant(i,j,30,30));
							break;
						case 1 : 
							grille.add(new mur(i,j,30,30));
						break;
						case 2 :
							grille.add(new Casevide(i,j,30,30, false));
							break;
						case 3 : 
							grille.add(new Casevide(i,j,30,30, true));
							break;
						case 4 :
							grille.add(new Casevide(i,j,30,30, false));
							grilleM.add(new personnage(i,j,30,30));
							break;
						case 5 : 
							grille.add(new Casevide(i,j,30,30, false));
							grilleM.add(new caisse(i,j,30,30, false));
							break;
						case 6 :
							grille.add(new Casevide(i,j,30,30, true));
							grilleM.add(new caisse(i,j,30,30, true));
							break;
					}
				}
			}
		}
	}	
	
	public int getJoueur_gM() {
		for (int i=0; i<dim; i++) {
			if (grilleM.get(i).getType() == 2) {
				return i;
			}
		}
		return -1;
	}
	
	public int getJoueur_g() {
		int jx, jy;
		int val = getJoueur_gM();
		jx = grilleM.get(val).getX();
		jy = grilleM.get(val).getY();
		for (int i=0; i < (hauteur*largeur); i++) {
			if((grille.get(i).getX() == jx) && (grille.get(i).getY() == jy)){
	            return i;
	        }
		}
		return -1;
	}
	
	public int getVoisine(int voisine){
	    int val2 = getJoueur_g();
	    for(int i=0;i<dim;i++){
	        if((grille.get(val2+voisine).getX()==grilleM.get(i).getX()) && (grille.get(val2+voisine).getY()==grilleM.get(i).getY())){
	            return i;
	        }
	    }
	    return -1;
	}
	
	public int getLibre(int voisine){
	    int test = 0;
	    int val2 = getJoueur_g();
	    int val3 = getVoisine(voisine);
	    int val4 = getVoisine(voisine*2);
	    if((grille.get(val2+(voisine*2)).getType() != 4) && (!(val4!=-1) || !(grilleM.get(val4).getType()==1 || grilleM.get(val4).getType()==5))){
	        if((val3!=-1) && (grilleM.get(val3).getType()==1 || grilleM.get(val3).getType()==5 )){
	            test = 1;
	        }
	    }
	    if((grille.get(val2+voisine).getType() != 4) && ((val3==-1) || !(grilleM.get(val3).getType()!=3 || grilleM.get(val3).getType()!=5))){
	        test = 2;
	    }
	    return test;
	}
	
	public void dessiner(Graphics g) {
		for (int i=0; i<hauteur*largeur;i++) {
			grille.get(i).dessiner(g);
		}
		for (int i=0; i<dim; i++) {
			grilleM.get(i).dessiner(g);
		}
	}
}
