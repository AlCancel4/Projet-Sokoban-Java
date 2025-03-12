package Sokoban;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")

class PanelJouer extends JPanel {
	
   // Réference sur la fenêtre principale
   private Jouer maFenetreJouer;
   
   public PanelJouer(Jouer FenetreJouer) {
	   maFenetreJouer = FenetreJouer;
   }
   /**
    * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
    */
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       // On appel la méthode dessiner de la fenêtre principale...
       maFenetreJouer.dessiner(g);
   } 
}