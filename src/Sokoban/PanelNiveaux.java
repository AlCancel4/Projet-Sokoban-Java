package Sokoban;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")

class PanelNiveaux extends JPanel {
	
   // Réference sur la fenêtre principale
   private Niveaux maFenetreNiveau;
   
   public PanelNiveaux(Niveaux FenetreNiveau) {
	   maFenetreNiveau = FenetreNiveau;
   }
   /**
    * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
    */
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       // On appel la méthode dessiner de la fenêtre principale...
       maFenetreNiveau.dessiner(g);
   } 
}