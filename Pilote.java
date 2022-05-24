package TestMenuBar;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.ZoneId;

import com.mysql.jdbc.Messages;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pilote
{
	private static String url = "jdbc:mysql://localhost:3306/banque";
	private static String login = "root";
	private static String passwd = "";
	private static Connection cn =null;
	
	
	
	
	
	
	
public static Boolean AjouterCompte(Compte compte)  {
	
	boolean reponse = false;
	
		
		
		try
		{
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			// preparation d'un statement 
			
			java.sql.PreparedStatement st1 = cn.prepareStatement("INSERT INTO compte(NumCompte,Datenaiss,Nom,Prenom,solde,codesecret,mail,Iban) Values(?,?,?,?,?,?,?,?)");
			
			/*
			 * Remplissage des paramètres de la requête grâce aux méthodes
			 * setXXX() mises à disposition par l'objet PreparedStatement.
			 */
			st1.setInt( 1, compte.getnumcompte() );
			
			st1.setString( 2,  compte.getDatenaiss().toString());
			st1.setString( 3, compte.getNom());
			st1.setString( 4, compte.getPrenom());
			st1.setInt( 5, compte.getsolde());
			st1.setString( 6, compte.getcode());
			st1.setString( 7, compte.getmail());
			st1.setString( 8, compte.getIban());
			
			
			
			
		      		
		      
		      int statut = st1.executeUpdate();
		    if (statut  !=  0)
		    {
		    	reponse = true;
		    	
		    }
		    else
		    {
		    	reponse = false;
		    }
		}
		catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} finally {
				try {
					//Etape 5 : libérer ressources de la memoire.
					cn.close();
					
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		return reponse;
	}

	public static Boolean AjouterBeneficiaire(Beneficiaire beneficiaire)
	{
		
		boolean reponse = false;
		
		
		try
		{
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			// Création d'un statement 
			
			java.sql.PreparedStatement st1 = cn.prepareStatement("INSERT INTO Beneficiaire(Nom,Prenom,Iban,idDonnant) Values(?,?,?,?)");
			
		     
			/*
			 * Remplissage des paramètres de la requête grâce aux méthodes
			 * setXXX() mises à disposition par l'objet PreparedStatement.
			 */
			((PreparedStatement) st1).setString(1,beneficiaire.getnom());
			st1.setString(2,beneficiaire.getprenom());
			st1.setString(3,beneficiaire.getIban());
			st1.setInt(4,beneficiaire.getidDonnant());
			
			
			
			
			
			
		      		
		      
		      int statut = st1.executeUpdate();
		    if (statut  !=  0)
		    {
		    	reponse = true;
		    	
		    }
		    else
		    {
		    	reponse = false;
		    }
		}
		catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} finally {
				try {
					//Etape 5 : libérer ressources de la memoire.
					cn.close();
					
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		
		return reponse;
	}
	
	
	public static Component AfficherLesBeneficiaire( int numC)
	{
		
	
		
		
		try
		{
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			// Création d'un statement 
			Statement st1 = cn.createStatement();
			ResultSet resultat =  st1.executeQuery("Select ID, nom, prenom,IBAN from Beneficiaire where idDonnant = " + numC);
			
		      
		    if (resultat.first() == true)
		    {
		    	
		    	System.out.println("Voilà les bénéficiaire");
		    	//System.out.println(resultat.getRow());
		    	//System.out.println(resultat.last());
		    	
		    	       String str="";
		    			while(resultat.next())
			    		{
			    			// accorder les valeurs au variables 
		    				int id = resultat.getInt("ID");
			    			String nom = resultat.getString("nom");
			    			String prenom = resultat.getString("prenom");
			    			String IBAN= resultat.getString("IBAN");
			    			
			    			 str=str+resultat.getString("nom")+ resultat.getString("prenom") +  resultat.getString("IBAN") + "|" ;
			    		
			    			
			    		}
			    	
		    		}
		    	
		    		
		    else
		    {
		    	System.out.print("Vous n'avez aucun bénéficiaire Ajoutez en un !!");
		    	
		    	
		    }
		   
		  
		}
		catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} finally {
				try {
					//Etape 5 : libérer ressources de la memoire.
					cn.close();
					
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		return null;
		
		
	}
	
	public  static Boolean FaireunVirement( Virement v)
	{
		
		Boolean insertionok = false;
		
		
		try
		{
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			// Création d'un statement 
			Statement st1 = cn.createStatement();
			java.sql.PreparedStatement preparedStatement = cn.prepareStatement("INSERT INTO virement(motif,montant,Iban,idDonnant,DateVirement) Values(?,?,?,?,?)");
			preparedStatement.setString( 1, v.getmotif() );
			preparedStatement.setInt( 2, v.getmontant() );
			preparedStatement.setInt( 3, v.getIban());
			preparedStatement.setInt( 4, v.getidDonnant());
			preparedStatement.setTimestamp( 5, v.getDatevirement());
		     
			
			
			
			
			
			
			int statut = preparedStatement.executeUpdate();
			
		      		
		      
		      
		    if (statut  != 0)
		    {
		    	
		    	insertionok = true;
		    	
		    	
		    	
		    	
		    		
		    	
		    	
		    	
		    }
		    else
		    {
		    	insertionok = false;
		    }
		}
		catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} finally {
				try {
					//Etape 5 : libérer ressources de la memoire.
					cn.close();
					
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		return insertionok;
		
	}
	
	// on vérifie le solde du compte pour voir si le solde est bon pour réaliser des virement ou des dépots
	public static  boolean  VerifierLeSolde( int numc)
	{
		
	
		
		boolean soldebon = false;	
		try
		{
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			// Création d'un statement 
			Statement st1 = cn.createStatement();
			ResultSet resultat =  st1.executeQuery("Select solde from Compte where solde > 50 and NumCompte =  " +  numc);
			 
			
			// On vérifie si une ligne s'affciche sinon cela veut dire qu'il y'a un défaut de provision dans le compte
			// Si il n'a aucune ligne de retourné alors resultat.last() = false
		    if (resultat.last() == true)
		    {
		    	
		    	
		    	soldebon = true;
		    	
		    
		    	
		    	
		    		//while(resultat.next())
		    		//{
		    			// accorder les valeurs au variables 
		    			//String nom = resultat.getString("nom");
		    			//String prenom = resultat.getString("prenom");
		    			//int IBAN= resultat.getInt("IBAN");
		    			
		    			//String message = "Nom :  " + nom  + "\n\r"
			    				//+ "Prenom :" + prenom +  "\\n\\r" 
		    					//+ "IBAN : " + IBAN;
		    		//}
		    	
		    	
		    	
		    }
		    else
		    {
		    	
		    	soldebon = false;
		    }
		    
		   
		}
		catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} finally {
				try {
					//Etape 5 : libérer ressources de la memoire.
					cn.close();
					
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		
		
		return soldebon;
		}
	
	// on vérifie le solde du compte pour voir si le solde est bon pour réaliser des virement ou des dépots
		public static  boolean  VerifierMontant( int montant, int numc)
		{
			
		
			
			boolean montantbon = false;	
			try
			{
				// Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url,login,passwd);
				// Création d'un statement 
				Statement st1 = cn.createStatement();
				ResultSet resultat =  st1.executeQuery("Select solde from compte where NumCompte = " + numc + " And (solde - " + montant + ") > 50");
				 
				
				// On vérifie si une ligne s'affciche sinon cela veut dire qu'il y'a un défaut de provision dans le compte
			    if (resultat.last() == true)
			    {
			    	
			    
			    	montantbon = true;
			    	
			    
			    	
			    	
			    		//while(resultat.next())
			    		//{
			    			// accorder les valeurs au variables 
			    			//String nom = resultat.getString("nom");
			    			//String prenom = resultat.getString("prenom");
			    			//int IBAN= resultat.getInt("IBAN");
			    			
			    			//String message = "Nom :  " + nom  + "\n\r"
				    				//+ "Prenom :" + prenom +  "\\n\\r" 
			    					//+ "IBAN : " + IBAN;
			    		//}
			    	
			    	
			    	
			    }
			    else
			    {
			    	
			    	montantbon = false;
			    }
			    
			   
			}
			catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				} finally {
					try {
						//Etape 5 : libérer ressources de la memoire.
						cn.close();
						
						
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			
			
			return montantbon;
			}
	
		public static void AfficherLeBeneficiaire( int numB, int numc)
		{
			
		
			
			
			try
			{
				// Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url,login,passwd);
				// Création d'un statement 
				Statement st1 = cn.createStatement();
				ResultSet resultat =  st1.executeQuery("Select nom, prenom,IBAN from Beneficiaire where ID = " + numB + " and IdDonnant = " + numc);
				
			     
				
				
				
				
				
				
				
				
			      		
			      
			      // Si une ligne à été retourné
			    if (resultat.getRow() == 0)
			    {
			    	System.out.println("insertion réussi");
			    	
			    	
			    		while(resultat.next())
			    		{
			    			// accorder les valeurs au variables 
			    			String nom = resultat.getString("nom");
			    			String prenom = resultat.getString("prenom");
			    			int IBAN= resultat.getInt("IBAN");
			    			
			    			String message = "Vous voulez réalisez un virement sur le compte de Monsieur  :  " + nom  + " "
				+ prenom +  "\\n\\r";
			    			System.out.println(message);
			    		}
			    	
			    	
			    	
			    }
			    else
			    {
			    	System.out.println("Le numéro saisie est incorect");
			    }
			}
			catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				} finally {
					try {
						//Etape 5 : libérer ressources de la memoire.
						cn.close();
						
						
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			
		}
	
		// on vérifie le solde du compte pour voir si le solde est bon pour réaliser des virement ou des dépots
				public static  boolean  VerifierBeneficiaire( String nom,  String prenom, int numc)
				{
					
				
					
					boolean BeficiaireExist = false;	
					try
					{
						// Chargement du driver
						Class.forName("com.mysql.jdbc.Driver");
						cn = DriverManager.getConnection(url,login,passwd);
						// Création d'un statement 
						Statement st1 = cn.createStatement();
						ResultSet resultat =  st1.executeQuery("Select * from Beneficiaire where nom = " + nom + "and prenom = " + prenom + "and idDonnant = " + numc);
						
						
						// On vérifie si une ligne s'affciche sinon cela veut dire qu'il y'a un défaut de provision dans le compte
					    if (resultat.next() == true)
					    {
					    	
					    
					    	BeficiaireExist = true;
					    	
					    
					    	
					    	
					    		//while(resultat.next())
					    		//{
					    			// accorder les valeurs au variables 
					    			//String nom = resultat.getString("nom");
					    			//String prenom = resultat.getString("prenom");
					    			//int IBAN= resultat.getInt("IBAN");
					    			
					    			//String message = "Nom :  " + nom  + "\n\r"
						    				//+ "Prenom :" + prenom +  "\\n\\r" 
					    					//+ "IBAN : " + IBAN;
					    		//}
					    	
					    	
					    	
					    }
					    else
					    {
					    	
					    	BeficiaireExist = false;
					    }
					    
					   
					}
					catch (SQLException e) {
					e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						} finally {
							try {
								//Etape 5 : libérer ressources de la memoire.
								cn.close();
								
								
							} catch (SQLException e) 
							{
								e.printStackTrace();
							}
						}
					
					
					return BeficiaireExist;
					}
				
				public  static void FaireunDepot( Depot d)
				{
					
				
					
					
					try
					{
						// Chargement du driver
						Class.forName("com.mysql.jdbc.Driver");
						cn = DriverManager.getConnection(url,login,passwd);
						// Création d'un statement 
						Statement st1 = cn.createStatement();
						java.sql.PreparedStatement preparedStatement = cn.prepareStatement("INSERT INTO Depot(justificatif,montantDepot,IdCompte,DateDepot) Values(?,?,?,?)");
						preparedStatement.setString( 1, d.getjustificatif());
						preparedStatement.setInt( 2, d.getmontantDepot() );
						preparedStatement.setInt( 3, d.getnumc());
						preparedStatement.setTimestamp( 5, d.getDateDepot());
					     
						
						
						
						
						
						
						int statut = preparedStatement.executeUpdate();
						
					      		
					      
					      
					    if (statut  != 0)
					    {
					    	
					    	
					    	
					    	System.out.println("Le virement à bien été réalisé ");
					    	
					    	
					    		
					    	
					    	
					    	
					    }
					    else
					    {
					    	System.out.println("Le Depot n'a malheureusement pas marché ");
					    }
					}
					catch (SQLException e) {
					e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						} finally {
							try {
								//Etape 5 : libérer ressources de la memoire.
								cn.close();
								
								
							} catch (SQLException e) 
							{
								e.printStackTrace();
							}
						}
					
				}
				
				public static  boolean  CompteExiste( String numero, String mdp)
				{
					
				
					
					boolean CompteExist = false;	
					try
					{
						// Chargement du driver
						Class.forName("com.mysql.jdbc.Driver");
						cn = DriverManager.getConnection(url,login,passwd);
						// Création d'un statement 
						Statement st1 = cn.createStatement();
						ResultSet resultat =  st1.executeQuery("Select NumCompte, Nom,Prenom,solde,codesecret,Datenaiss from compte where codesecret = " + "'" + mdp + "'" + "and NumCompte = " + numero);
						 
						
						// On vérifie si une ligne s'affciche sinon cela veut dire qu'il y'a un défaut de provision dans le compte
						// Si il n'a aucune ligne de retourné alors resultat.last() = false
					    if (resultat.last() == true)
					    {
					    	
					    	
					    	CompteExist = true;
					    	
					    
					    	
					    	
					    		//while(resultat.next())
					    		//{
					    			// accorder les valeurs au variables 
					    			//String nom = resultat.getString("nom");
					    			//String prenom = resultat.getString("prenom");
					    			//int IBAN= resultat.getInt("IBAN");
					    			
					    			//String message = "Nom :  " + nom  + "\n\r"
						    				//+ "Prenom :" + prenom +  "\\n\\r" 
					    					//+ "IBAN : " + IBAN;
					    		//}
					    	
					    	
					    	
					    }
					    else
					    {
					    	
					    	CompteExist = false;
					    }
					    
					   
					}
					catch (SQLException e) {
					e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						} finally {
							try {
								//Etape 5 : libérer ressources de la memoire.
								cn.close();
								
								
							} catch (SQLException e) 
							{
								e.printStackTrace();
							}
						}
					
					
					return CompteExist;
					}
				
			
}

