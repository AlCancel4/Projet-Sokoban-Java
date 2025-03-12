package Sokoban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aide extends JDialog {
	
	private PanelAide contentPane;
	private ImageIcon fond;

	/**
	 * Create the dialog.
	 */
	public Aide() {
	    setBounds(100, 100, 600, 600);
	    contentPane = new PanelAide(this);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
		fond = new ImageIcon("../src/Sokoban/img1.png");
		setTitle("Aide");
		contentPane.setLayout(null);
		
		JButton btn_Quitter = new JButton("Quitter");
		btn_Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Quitter.setBounds(250, 355, 100, 30);
		contentPane.add(btn_Quitter);
		
		JLabel lblNewLabel_1 = new JLabel("Les règles sont simples : ");
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 50, 250, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-Vous êtes Spiderman et votre but est de déplacer toutes les caisses sur les diamants");
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(50, 75, 550, 100);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-Pour effectuer votre mission,vous pourrez vous déplacer dans 4 direction : le haut,");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(50, 100, 550, 100);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("le bas, la gauche et la droite grâce aux flèches directionnelles de votre clavier.");
		lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(50, 125, 550, 100);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("BON COURAGE");
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_4.setBounds(50, 150, 400, 100);
		contentPane.add(lblNewLabel_4);
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