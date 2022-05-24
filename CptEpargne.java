package TestMenuBar;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;





public class InterfaceB extends JFrame {
	
	JLabel L1;
	private BufferedImage image;
	public InterfaceB()
	{
		
    	
		
		/*Initialisation du JFrame*/
		
		JPanel panelCentre;
    	
		
		/*Création des JPanel avec leur Layout Manager*/
    	
    	panelCentre = new JPanel(new GridLayout(10,30));
    			
		
		
    	Container contenu = this.getContentPane();
	JFrame f = new JFrame("BanqueFuture");
	JMenuBar mb = new JMenuBar();
	JMenu Menu = new JMenu("Menu");
		JMenuItem i1 = new JMenuItem("Acceuil");
		JMenuItem i2 = new JMenuItem("Inscription");
		JMenuItem i3 = new JMenuItem("Connexion");
		
		
		Menu.add(i1);
		Menu.add(i2);
		Menu.add(i3);
	
		mb.add(Menu);
		
		i2.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	panelCentre.removeAll();
		    	
		    	JLabel Nom = new JLabel("Nom");
		    	
		    	JLabel Prenom = new JLabel("Prenom");
		    	JLabel Mail = new JLabel("Mail");
		    	JLabel Datenaiss = new JLabel("Date de naissance");
		    	
		    	JButton valider = new JButton("Valider");
		    	
		    	
		    	
		    	// Textes à saisir 
		    	
		    	JTextField textNom = new JTextField();
		    	JTextField textPrenom = new JTextField();
		    	JTextField textMail= new JTextField();
		    	JTextField textDatenaiss = new JTextField();
		       	JTextField textIban = new JTextField();
		    	
		    	// Image de fond
		    	ImageIcon icon = new ImageIcon("interface.jpg");
		    	
		    

		    	/*Récupération du ContentPane*/
		    	

		    	
		    		
		    	JPanel panelInscription = new JPanel();


		    	
		    	    f.add(panelCentre, BorderLayout.CENTER);

		    	    /*Ajout du formulaire de connexion à panelCentre*/
		    	    panelCentre.setBorder(new TitledBorder("Inscription"));
		    	   
		    	    panelCentre.add(Nom);
		    	    panelCentre.add(textNom);
		    	    panelCentre.add(Prenom);
		    	    panelCentre.add(textPrenom);
		    	    panelCentre.add(Mail);
		    	    panelCentre.add(textMail);
		    	    panelCentre.add(Datenaiss);   
		    	    panelCentre.add(textDatenaiss);
		    	    
		    	  
		    	    panelCentre.add(valider);
		    	    
		    	    
		    	    
		    	    panelCentre.setPreferredSize(new Dimension(500,500));
		    	    
		    	
		    		
		    		
		    		
			    	//On ne pourra pas agrandir la fenetre intitulée.
			    	f.setResizable (false);
		    	    f.setVisible(true);
		    	    
 valider.addActionListener(new ActionListener() {
		    			
		    		    public void actionPerformed(ActionEvent ev) {
		    		    	if(textNom.getText().isEmpty())
		            		  {
		            			  JOptionPane.showMessageDialog(null,"Le nom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);  
		            		  }
		            		  else if(textPrenom.getText().isEmpty())
		              		  {
		            			  
		              			JOptionPane.showMessageDialog(null,"Le prénom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              		  }
		    		    	
		            		  else if(textDatenaiss.getText().isEmpty())
		              		  {
		            			  
		              			JOptionPane.showMessageDialog(null,"La date de naissance n'a  pas été saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              		  }
		    		    	
		            		
		            		  else if(textMail.getText().isEmpty())
		              		  {
		            			  
		              			JOptionPane.showMessageDialog(null,"Le mail n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              		  }
		    		    	
		    		    	
		    		    	
		    		    	
		    		    	
		    		    	
		              		  else
		              		  {
		              			DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		              			        .appendPattern("dd/MM/uuuu")
		              			        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
		              			        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
		              			        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
		              			        .toFormatter();
		              			  LocalDate Date = LocalDate.parse(textDatenaiss.getText(),formatter);
		              			  
		              			  Compte c = new Compte(GeneratenuméroClient(),textNom.getText(),textPrenom.getText(),AleaMdp(),0,Date,textMail.getText(),GenerateIban());
		              			  
		              			  if(pilote.AjouterCompte(c) == true)
		              					  {
		              				JOptionPane.showMessageDialog(null,"Bravo le compte a été ajouter avec succes","Succes", JOptionPane.PLAIN_MESSAGE);  	
		       
		              					  }
		              			  else 
		              			  {
		              				JOptionPane.showMessageDialog(null,"Votre compte n'a pas été ajouté","Succes", JOptionPane.PLAIN_MESSAGE);  	 
		              			  }
		              		  }
		              		  

		    		    	
		    		    }
		   
	    });
		   
	    }
	});
		
		
		i3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	panelCentre.removeAll();
		    	
		    	JLabel login = new JLabel("Numéro Compte");
		    	JLabel password = new JLabel("Mot de passe");
		    	JButton valider = new JButton("Valider");
		    	JButton annuler = new JButton("Annuler");
		    	JTextField textlogin = new JTextField();
		    	JTextField textmdp = new JTextField();
		    	ImageIcon icon = new ImageIcon("interface.jpg");
		    	
		    

		    	/*Récupération du ContentPane*/
		    	

		    	
		    			
		    		
		    	JPanel panelConnexion = new JPanel();


		    	
		    	    f.add(panelCentre, BorderLayout.CENTER);

		    	    /*Ajout du formulaire de connexion à panelCentre*/
		    	    panelCentre.setBorder(new TitledBorder("Connexion"));
		    	    panelCentre.add(panelConnexion);
		    	    panelCentre.add(login);
		    	    panelCentre.add(textlogin);
		    	    panelCentre.add(password);   
		    	    panelCentre.add(textmdp);
		    	    panelCentre.add(valider);
		    	    panelCentre.add(annuler);
		    	    
		    	    
		    	    panelCentre.setPreferredSize(new Dimension(500,500));
		    	    
		    	
		    		f.setTitle("Connexion");
		    		
		    		
			    	//On ne pourra pas agrandir la fenetre intitulée.
			    	f.setResizable (false);
		    	    f.setVisible(true);
		    	    valider.addActionListener(new ActionListener() {
		    			
		    		    public void actionPerformed(ActionEvent ev) {
		    		    	if(textlogin.getText().isEmpty())
		            		  {
		            			  JOptionPane.showMessageDialog(null,"Le login n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);  
		            		  }
		            		  else if(textmdp.getText().isEmpty())
		              		  {
		            			  
		              			JOptionPane.showMessageDialog(null,"Le mot de passe de passe n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              		  }
		              		  else
		              		  {
		              			  
		              			  if(pilote.CompteExiste(textlogin.getText(), textmdp.getText()) == true)
		              					  {
		              				  int num = textlogin.getText();
		              				  
		              				  // une fois connécté
		              				JOptionPane.showMessageDialog(null,"Bienvenu","Success", JOptionPane.PLAIN_MESSAGE);  
		              				panelCentre.removeAll();
		              				Menu.removeAll();
		              				JMenuItem i1 = new JMenuItem("Ajouter un bénéficiaire");
		              				JMenuItem i2 = new JMenuItem("Faire un virement");
		              				JMenuItem i3 = new JMenuItem("Faire un dépot");
		              				Menu.add(i1);
		              				Menu.add(i2);
		              				Menu.add(i3);
		              				
		              				// Page Ajouter un Bénéficiaire
		              				i1.addActionListener(new ActionListener() {
		              					 public void actionPerformed(ActionEvent ev) {
		              						JLabel Nom = new JLabel("Nom");
		              				    	
		              				    	JLabel Prenom = new JLabel("Prenom");
		              				    	
		              				    	JLabel Iban = new JLabel("Iban");
		              				    	
		              				    	JButton valider = new JButton("Valider");
		              				    	JButton annuler = new JButton("Annuler");
		              				    	
		              				    	
		              				    	// Textes à saisir 
		              				    	
		              				    	JTextField textNom = new JTextField();
		              				    	JTextField textPrenom = new JTextField();
		              				       	JTextField textIban = new JTextField();
		              				    	
		              				    	
		              				    
		              				       	

		              				    	
		              				    		
		              				    	JPanel panelInscription = new JPanel();


		              				    	
		              				    	    f.add(panelCentre, BorderLayout.CENTER);

		              				    	    /*Ajout du formulaire de connexion à panelCentre*/
		              				    	    panelCentre.setBorder(new TitledBorder("Ajouter un bénéficiaire"));
		              				    	   
		              				    	    panelCentre.add(Nom);
		              				    	    panelCentre.add(textNom);
		              				    	    panelCentre.add(Prenom);
		              				    	    panelCentre.add(textPrenom);
		              				    	    panelCentre.add(Iban);   
		              				    	    panelCentre.add(textIban);
		              				    	    panelCentre.add(valider);
		              				    	    panelCentre.add(annuler);
		              				    	    
		              				    	  
		              				    	    panelCentre.add(valider);
		              				    	    
		              				    	    
		              				    	    
		              				    	    panelCentre.setPreferredSize(new Dimension(500,500));
		              				    	    
		              				    	
		              				    		
		              				    		
		              				    		
		              					    	//On ne pourra pas agrandir la fenetre intitulée.
		              					    	f.setResizable (false);
		              				    	    f.setVisible(true);
		              				    	    
		              				    	  valider.addActionListener(new ActionListener() {
		              			    			
		              			    		    public void actionPerformed(ActionEvent ev) {
		              			    		    	
		              			    		    	if(textNom.getText().isEmpty())
		              			            		  {
		              			            			  JOptionPane.showMessageDialog(null,"Le nom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);  
		              			            		  }
		              			            		  else if(textPrenom.getText().isEmpty())
		              			              		  {
		              			            			  
		              			              			JOptionPane.showMessageDialog(null,"Le prénom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              			              		  }
		              			    		    	
		              			            		  else if(textIban.getText().isEmpty())
		              			              		  {
		              			            			  
		              			              			JOptionPane.showMessageDialog(null,"L'Iban n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              			              		  }
		              			    		    	
		              			    		    	 
		              			    		    	 
		              			            		  else if(textIban.getText().length() < 20 || textIban.getText().matches("[0-9]") == false )
		              			            		  {
		              			            			JOptionPane.showMessageDialog(null,"Le format de l'iban n'est pas bon","echec",JOptionPane.PLAIN_MESSAGE);
		              			            		  }
		              			            		
		              			            		 
		              			    		    	
		              			    		    	
		              			    		    	
		              			    		    	
		              			    		    	
		              			              		  else
		              			              		  {
		              			              			
		              			              			  
		              			              			 
		              			              			  Beneficiaire b = new Beneficiaire(textNom.getText(),textNom.getText(),textIban.getText(),num);
		              			              			  if(pilote.AjouterBeneficiaire(b) == true)
		              			              					  {
		              			              				JOptionPane.showMessageDialog(null,"Bravo le Bénéficiaire a été ajouter avec succes","Succes", JOptionPane.PLAIN_MESSAGE);  	
		              			       
		              			              					  }
		              			              			  else 
		              			              			  {
		              			              				JOptionPane.showMessageDialog(null,"Votre compte n'a pas été ajouter malheureusement","Echec ", JOptionPane.PLAIN_MESSAGE);  	 
		              			              			  }
		              			              		  }
		              			              		  

		              			    		    	
		              			    		    }
		              			   
		              		    });
		              				    	    
		              				    	    
		              					 }
		              					 
		              					
		              				});
		              				
		              				// Faire un virement
		              				i2.addActionListener(new ActionListener() {
		              					 public void actionPerformed(ActionEvent ev) {
		              						JLabel Nom = new JLabel("Nom du bénéficiaire");
		              				    	
		              				    	JLabel Prenom = new JLabel("Prenom du bénéficiaire");
		              				    	JLabel Montant = new JLabel("Montant du virement");
		              				    	JLabel Iban = new JLabel("Iban du bénéficiaire");
		              				    	JLabel Beneficiaires = new JLabel("Voici vos Bénéficiare :");
		              				    	
		              				    	JButton valider = new JButton("Valider");
		              				    	JButton annuler = new JButton("Annuler");
		              				    	JLabel Motif = new JLabel("Motifs :");
		              				     
		              				    	
		              				    	// Textes à saisir 
		              				    	
		              				    	JTextField textNom = new JTextField();
		              				    	JTextField textPrenom = new JTextField();
		              				       	JTextField textIban = new JTextField();
		              				       	JTextField textMontant = new JTextField();
		              				       	JTextField textMotif = new JTextField();
		              				    	
		              				    	
		              				    
		              				       	

		              				    	
		              				    		
		              				    	JPanel panelInscription = new JPanel();

		              				    	
		              				    	
		              				    	    f.add(panelCentre, BorderLayout.CENTER);

		              				    	    /*Ajout du formulaire de connexion à panelCentre*/
		              				    	    panelCentre.setBorder(new TitledBorder("Ajouter un bénéficiaire"));
		              				    	    panelCentre.add(Beneficiaires);
		              				    	    panelCentre.add(pilote.AfficherLesBeneficiaire(num));
		              				    	    panelCentre.add(Nom);
		              				    	    panelCentre.add(textNom);
		              				    	    panelCentre.add(Prenom);
		              				    	    panelCentre.add(textPrenom);
		              				    	    panelCentre.add(Iban);   
		              				    	    panelCentre.add(textIban);
		              				    	    panelCentre.add(Montant);   
		              				    	    panelCentre.add(textMontant);
		              				    	    panelCentre.add(Motif);
		              				    	    panelCentre.add(textMotif);
		              				    	    panelCentre.add(valider);
		              				    	    panelCentre.add(annuler);
		              				    	    
		              				    	  
		              				    	  
		              				    	    
		              				    	    
		              				    	    
		              				    	    panelCentre.setPreferredSize(new Dimension(500,500));
		              				    	    
		              				    	
		              				    		
		              				    		
		              				    		
		              					    	//On ne pourra pas agrandir la fenetre intitulée.
		              					    	f.setResizable (false);
		              				    	    f.setVisible(true);
		              				    	   // Une fois le bouton valider cliqué
		              				    	  valider.addActionListener(new ActionListener() {
		              			    			
		              			    		    public void actionPerformed(ActionEvent ev) {
		              			    		    	
		              			    		    	if(textNom.getText().isEmpty())
		              			            		  {
		              			            			  JOptionPane.showMessageDialog(null,"Le nom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);  
		              			            		  }
		              			            		  else if(textPrenom.getText().isEmpty())
		              			              		  {
		              			            			  
		              			              			JOptionPane.showMessageDialog(null,"Le prénom n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              			              		  }
		              			    		    	
		              			            		  else if(textIban.getText().isEmpty())
		              			              		  {
		              			            			  
		              			              			JOptionPane.showMessageDialog(null,"L'Iban n'est pas saisi","echec",JOptionPane.PLAIN_MESSAGE);
		              			              		  }
		              			    		    	
		              			    		    	 
		              			    		    	 
		              			            		  else if(pilote.VerifierBeneficiaire(textNom.getText(), textPrenom.getText(), Integer.parseInt(textIban.getText())) == false)
		              			            		  {
		              			            			JOptionPane.showMessageDialog(null,"Les valeures saisies sont incorects","echec",JOptionPane.PLAIN_MESSAGE);
		              			            		  }
		              			            		
		              			            		 
		              			            		  else if(pilote.VerifierMontant(Integer.parseInt(textMontant.getText()), num) == true)
		              			            		  {
		              			            			JOptionPane.showMessageDialog(null,"montant trop élevé","echec",JOptionPane.PLAIN_MESSAGE);
		              			            		  }
		              			    		    	
		              			            		  else if(pilote.VerifierLeSolde(num) == true)
		              			            		  {
		              			            			JOptionPane.showMessageDialog(null,"Défaut de provision","echec",JOptionPane.PLAIN_MESSAGE);
		              			            		  }
		              			            		  
		              			    		    	
		              			    		    	
		              			    		    	
		              			    		    	
		              			              		  else
		              			              		  {
		              			              			
		              			              			  
		              			              			 
		              			              			Virement v = new Virement(textMotif.getText(),Integer.parseInt(textMontant.getText()),num,Integer.parseInt(textIban.getText()));
		              			              			  if(pilote.FaireunVirement(v) == true)
		              			              					  {
		              			              				JOptionPane.showMessageDialog(null,"Bravo votre virement à bien été réaliser","Succes", JOptionPane.PLAIN_MESSAGE);  	
		              			       
		              			              					  }
		              			              			  else 
		              			              			  {
		              			              				JOptionPane.showMessageDialog(null,"Malheuresement votre virement n'a pas été réaliser","Echec ", JOptionPane.PLAIN_MESSAGE);  	 
		              			              			  }
		              			              		  }
		              			              		  

		              			    		    	
		              			    		    }

												private boolean ParseInt(String text) {
													// TODO Auto-generated method stub
													return false;
												}
		              			   
		              		    });
		              				    	    
		              				    	    
		              					 }
		              					 
		              					
		              				});
		              				
		              				
		              				
		              				
		              				
		              					  }
		              			  else
		              			  {
		              				JOptionPane.showMessageDialog(null,"Votre mot de passe ou votre login est incorect","echec", JOptionPane.PLAIN_MESSAGE); 
		              				
		              				
		              			  }
		              		  }
		    		    			
		              		  

		    		    	
		    		    }
		   
	    });
		    }
	});
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\alpha-mal\\Downloads\\interface.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back

		f.setContentPane(new JLabel(imageIcon));
		f.setLayout(new FlowLayout());
		L1 = new JLabel();
		f.add(L1);
		
		
		// Ajoute la menu bar dans la frame
		f.setJMenuBar(mb);
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	// Générer aléatoirement un numéro de client
	public int GeneratenuméroClient() {
	
	      int min = 100000;
	      int max = 999999;
	        
	      //Generate random int value from 50 to 100 
	      
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      return random_int;
	      
	    
	}
	// générer aléatoirement L'iban
	public String GenerateIban() 
	{
		String Iban = "FR7630012000";
		   
	       int min = 10000000; 
	      int max = 99999999;
	        
	      //Genère un nombre aléatoire qui sera ensuite ajouter à L'iban
	      
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      Iban += Integer.toString(random_int);
	      return Iban;
	      
	    
	}
	// Générer aléatoirement un mot de Passe
	public static  String AleaMdp()
	{
		int length = 8;
		String symbol = "-/.^&*_!@%=+>)"; 
		String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String small_letter = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 
		String finalString = cap_letter + small_letter + 
		numbers + symbol; 
		Random random = new Random(); 
		char[] password = new char[length]; 
		for (int i = 0; i < length; i++) 
		{ 
			password[i] = finalString.charAt(random.nextInt(finalString.length())); 
		} 
		String result = String.valueOf(password);
			
			return result;
		
	}
	
	public static void main(String[] args)
	{
		new InterfaceB();
		
		
		
		
		
	}
}
