package Sokoban;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class PanelGagner extends JPanel {
	
	 // Réference sur la Aide
    private Gagner maFenetreGagner;

   
    public PanelGagner(Gagner FenetreGagner) {
    	maFenetreGagner = FenetreGagner;
    }
    
   /**
    * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
    */
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       // On appel la méthode dessiner de la fenêtre principale...
       maFenetreGagner.dessiner(g);
   }
}
