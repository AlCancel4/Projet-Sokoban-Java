package Sokoban;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FenetrePrincipale extends JFrame {
	
	private PanelPrincipal contentPane;
	private ImageIcon fond;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 600, 600);
	    contentPane = new PanelPrincipal(this);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    fond = new ImageIcon("../src/Sokoban/img1.png");
	    setTitle("SOKOBAN");
	    contentPane.setLayout(null);
	    
	    JButton btn_Jouer = new JButton("Jouer");
	    btn_Jouer.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Jouer DialogJouer;
				DialogJouer = new Jouer();
				DialogJouer.setVisible(true);
	    	}
	    });
	    btn_Jouer.setBounds(250, 155, 100, 30);
	    contentPane.add(btn_Jouer);
	    
	    JButton btn_Aide = new JButton("Aide");
	    btn_Aide.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Aide DialogAide;
				DialogAide = new Aide();
				DialogAide.setVisible(true);
	    	}
	    });
	    btn_Aide.setBounds(250, 255, 100, 30);
	    contentPane.add(btn_Aide);
	    
	    JButton btn_Quitter = new JButton("Quitter");
	    btn_Quitter.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    	}
	    });
	    btn_Quitter.setBounds(250, 355, 100, 30);
	    contentPane.add(btn_Quitter);
	}
	
	public void dessiner(Graphics gr) {
		Graphics bufferImage;
		Image offscreen;
		offscreen = createImage(this.getContentPane().getWidth(), this.getContentPane().getHeight());
		bufferImage = offscreen.getGraphics();
		bufferImage.drawImage(fond.getImage(), 0, 0, 610, 610,this);
		gr.drawImage(offscreen,0,0,null);
	}
}
