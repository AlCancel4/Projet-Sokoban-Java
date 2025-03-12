package Sokoban;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class PanelAide extends JPanel {
	
	 // Réference sur la Aide
    private Aide maFenetreAide;

   
    public PanelAide(Aide FenetreAide) {
    	maFenetreAide = FenetreAide;
    }
    
   /**
    * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
    */
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       // On appel la méthode dessiner de la fenêtre principale...
       maFenetreAide.dessiner(g);
   }
}
