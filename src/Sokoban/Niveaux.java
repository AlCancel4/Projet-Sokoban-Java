package Sokoban;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Niveaux extends JDialog {

	private final PanelNiveaux contentPanel;
	
	public int niveau;
	public int compteur;
	private grille g;
	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public Niveaux(int niveau) throws IOException {
		setTitle("Niveau "+ String.valueOf(niveau));
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				fromKeyPressed(e);
			}
		});
		contentPanel = new PanelNiveaux(this);
		contentPanel.setFocusable(false);
		this.niveau= niveau;
		g = new grille("../src/Sokoban/nivo"+String.valueOf(niveau)+".txt");
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_Quitter = new JButton("Quitter");
				btn_Quitter.setFocusable(false);
				btn_Quitter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_Quitter.setActionCommand("OK");
				buttonPane.add(btn_Quitter);
				getRootPane().setDefaultButton(btn_Quitter);
			}
			{
				JButton btn_Restart = new JButton("Restart");
				btn_Restart.setFocusable(false);
				btn_Restart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Niveaux DialogNiveaux;
						try {
							DialogNiveaux = new Niveaux(niveau);
							DialogNiveaux.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btn_Restart.setActionCommand("Restart");
				buttonPane.add(btn_Restart);
			}
		}
	}
	
	public void dessiner(Graphics graph) {
		Graphics bufferImage;
		Image offscreen;
		offscreen = createImage(this.getContentPane().getWidth(), this.getContentPane().getHeight());
		bufferImage = offscreen.getGraphics();
		g.dessiner(bufferImage);
		graph.drawImage(offscreen,0,0,null);
	}


	public boolean testerSiGagner() {
		int compteur = 0;
		for (int i=0; i < g.dim; i++) {
			if (g.grilleM.get(i).getType() == 5) {
				compteur += 1;
			}
		}
		if (compteur == g.dim-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void estGagner(){
	    if (testerSiGagner() == true){
	        dispose();
	        Gagner DialogGagner = new Gagner(niveau, compteur);
	        DialogGagner.setVisible(true);
	    }
	}
	
	public void fromKeyPressed(java.awt.event.KeyEvent evt) {
		int val = -1;
		int val2 = -1;
		int val3 = -1;
		int voisine = -1;
		val = g.getJoueur_gM();
		val2 = g.getJoueur_g();
		//Gauche
		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			voisine = -1;
            val3 = g.getVoisine(voisine);
            if (g.getLibre(voisine) == 1){
                g.grilleM.get(val3).deplacer(-1,0);
                g.grilleM.get(val).deplacer(-1,0);
                if(g.grille.get(val2+voisine*2).getType()==3){
                    g.grilleM.get(val3).setColoree(false);
                }
                if(g.grille.get(val2+voisine*2).getType()==6){
                    g.grilleM.get(val3).setColoree(true);
                }
            }
            else if (g.getLibre(voisine) == 2){
                g.grilleM.get(val).deplacer(-1,0);
            }
            compteur += 1;
		}
		//Droite
		else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			voisine = 1;
            val3 = g.getVoisine(voisine);
            if (g.getLibre(voisine) == 1){
            	g.grilleM.get(val3).deplacer(1,0);
            	g.grilleM.get(val).deplacer(1,0);
                if(g.grille.get(val2+voisine*2).getType()==3){
                	g.grilleM.get(val3).setColoree(false);
                }
                if(g.grille.get(val2+voisine*2).getType()==6){
                    g.grilleM.get(val3).setColoree(true);
                }
            }
            else if (g.getLibre(voisine) == 2){
            	g.grilleM.get(val).deplacer(1,0);
            }
            compteur += 1;
		}
		//Haut
		else if (evt.getKeyCode() == KeyEvent.VK_UP) {
			voisine = -20;
            val3 = g.getVoisine(voisine);
            if (g.getLibre(voisine) == 1){
            	g.grilleM.get(val3).deplacer(0,-1);
            	g.grilleM.get(val).deplacer(0,-1);
                if(g.grille.get(val2+voisine*2).getType()==3){
                	g.grilleM.get(val3).setColoree(false);
                }
                if(g.grille.get(val2+voisine*2).getType()==6){
                    g.grilleM.get(val3).setColoree(true);
                }
            }
            else if (g.getLibre(voisine) == 2){
            	g.grilleM.get(val).deplacer(0,-1);
            }
            compteur += 1;
		}
		//Bas
		else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
			voisine = 20;
            val3 = g.getVoisine(voisine);
            if (g.getLibre(voisine) == 1){
            	g.grilleM.get(val3).deplacer(0,1);
            	g.grilleM.get(val).deplacer(0,1);
                if(g.grille.get(val2+voisine*2).getType()==3){
                	g.grilleM.get(val3).setColoree(false);
                }
                if(g.grille.get(val2+voisine*2).getType()==6){
                    g.grilleM.get(val3).setColoree(true);
                }
            }
            else if (g.getLibre(voisine) == 2){
            	g.grilleM.get(val).deplacer(0,1);
            }
            compteur += 1;
		}
		this.repaint();
		
		estGagner();
	}
}