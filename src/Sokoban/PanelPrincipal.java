package Sokoban;

import javax.swing.JPanel;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel {

	// Réference sur la fenêtre principale
	private FenetrePrincipale maFenetrePrincipale;
	
	/**
	 * Create the panel.
	 */
	public PanelPrincipal(FenetrePrincipale FenetrePrincipale) {
		maFenetrePrincipale = FenetrePrincipale;
	}
	
	/**
    * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
    */
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       // On appel la méthode dessiner de la fenêtre principale...
       maFenetrePrincipale.dessiner(g);
   } 
}