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
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Gagner extends JDialog {

	private PanelGagner contentPane;
	private ImageIcon fond;
	private int niv;
	private int compteur;
	private JTextField pseudo;
	
	/**
	 * Create the dialog.
	 */
	public Gagner(int niv, int compteur) {
		this.niv = niv;
		this.compteur = compteur;
	    setBounds(100, 100, 600, 600);
	    contentPane = new PanelGagner(this);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
		fond = new ImageIcon("../src/Sokoban/img1.png");
		setTitle("Gagner");
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gagner!!! Nombre de coup : "+String.valueOf(compteur));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(150, 50, 200, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de coup : "+String.valueOf(compteur));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(200, 50, 200, 100);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_Quitter = new JButton("Quitter");
		btn_Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Quitter.setBounds(250, 355, 100, 30);
		contentPane.add(btn_Quitter);
		
		JButton btn_Restart = new JButton("Restart");
		btn_Restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Niveaux DialogNiveaux;
				try {
					DialogNiveaux = new Niveaux(niv);
					DialogNiveaux.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Restart.setBounds(250, 150, 100, 30);
		contentPane.add(btn_Restart);
		
		JButton btn_Continuer = new JButton("Continuer");
		btn_Continuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (niv == 4) {
					dispose();
				}
				else {
					dispose();
					Niveaux DialogNiveaux;
					try {
						DialogNiveaux = new Niveaux(niv+1);
						DialogNiveaux.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_Continuer.setBounds(250, 250, 100, 30);
		contentPane.add(btn_Continuer);
		
		pseudo = new JTextField();
		contentPane.add(pseudo);
		pseudo.setBounds(250, 450, 100, 20);
		pseudo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pseudo");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_3.setBounds(250, 400, 100, 20);
		contentPane.add(lblNewLabel_3);
	}
	
	public void dessiner(Graphics gr) {
		Graphics bufferImage;
		Image offscreen;
		offscreen = createImage(this.getContentPane().getWidth(), this.getContentPane().getHeight());
		bufferImage = offscreen.getGraphics();
		bufferImage.drawImage(fond.getImage(), 0, 0, 610, 610,this);
		gr.drawImage(offscreen,0,0,null);
	}
	
	public void appelBDD(String nom, int niv, int compteur) {
		String BDD = "Sokoban";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stm=conn.createStatement();
            System.out.println("Connecter");
            String query = "INSERT INTO resultat (`Pseudo`,`Niveau`, `NbCoups`) " + "VALUES ('"+nom+"',"+String.valueOf(niv)+","+String.valueOf(compteur)+")";
	        stm.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
	}

}
