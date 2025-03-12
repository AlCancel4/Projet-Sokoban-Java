package Sokoban;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Jouer extends JDialog {
	
	private final PanelJouer contentPane;
	private ImageIcon fond;

	/**
	 * Create the dialog.
	 */
	public Jouer() {
		setBounds(100, 100, 600, 600);
		contentPane = new PanelJouer(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		fond = new ImageIcon("../src/Sokoban/img1.png");
		setTitle("Jouer");
		contentPane.setLayout(null);
		
		JButton btn_Niveau1 = new JButton("Niveau 1");
		btn_Niveau1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Niveaux DialogNiveaux;
	    		try {
					DialogNiveaux = new Niveaux(1);
					DialogNiveaux.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
		btn_Niveau1.setBounds(250, 25, 100, 30);
	    contentPane.add(btn_Niveau1);
	    
	    JButton btn_Niveau2 = new JButton("Niveau 2");
	    btn_Niveau2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Niveaux DialogNiveaux;
	    		try {
					DialogNiveaux = new Niveaux(2);
					DialogNiveaux.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
		btn_Niveau2.setBounds(250, 125, 100, 30);
	    contentPane.add(btn_Niveau2);
	    
	    JButton btn_Niveau3 = new JButton("Niveau 3");
	    btn_Niveau3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Niveaux DialogNiveaux;
	    		try {
					DialogNiveaux = new Niveaux(3);
					DialogNiveaux.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btn_Niveau3.setBounds(250, 225, 100, 30);
	    contentPane.add(btn_Niveau3);
	    
	    JButton btn_Niveau4 = new JButton("Niveau 4");
	    btn_Niveau4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Niveaux DialogNiveaux;
	    		try {
					DialogNiveaux = new Niveaux(4);
					DialogNiveaux.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btn_Niveau4.setBounds(250, 325, 100, 30);
	    contentPane.add(btn_Niveau4);
	    
	    JButton btn_Quitter = new JButton("Quitter");
	    btn_Quitter.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    	}
	    });
	    btn_Quitter.setBounds(250, 425, 100, 30);
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
