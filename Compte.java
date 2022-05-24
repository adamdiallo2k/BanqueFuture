package TestMenuBar;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;


// constructeur de la classe
public class Compte {
	private int numcompte; 
	private String Nom;
	private String Prenom;
	private String codeSecret;
	private int solde;
	private LocalDate datenaiss;
	private String mail;
	private String Iban;
	

	
	public Compte(int numcompte, String nom, String Prenom, String codeSecret, int solde, LocalDate datenaiss, String mail, String Iban)
	{
		
		 this.setnumCompte(numcompte);
		 this.setNom(nom);
		 this.setprenom(Prenom);
		 this.setcodeSecret(codeSecret);
		this.setsolde(solde);
		 this.setcodeSecret(codeSecret);
		 this.setdatenaiss(datenaiss);
		 this.setmail(mail);
		 this.setIban(Iban);
		  	
		  
	}
	// getters
	
	public String getNom()
	{
		return this.Nom;
	}
	
	public String getPrenom()
	{
		return this.Prenom;
	}
	
	public String getcode()
	{
		return this.codeSecret;
	}
	
	
	public int getsolde()
	{
		return this.solde;
	}
	
	public LocalDate getDatenaiss()
	{
		return this.datenaiss;
	}
	
	public int getnumcompte()
	{
		return this.numcompte;
	}
	
	public String getmail()
	{
		return this.mail;
	}
	
	public String getIban()
	{
		return this.Iban;
	}
	
	// setter
	
	public void setNom(String nom)
	{
		this.Nom = nom;
	}
	
	public void setIban(String Iban)
	{
		this.Iban = Iban;
	}
	
	public void setnumCompte(int num)
	{
		this.numcompte = num;
	}
	
	public void setprenom(String prenom)
	{
		this.Prenom = prenom;
	}
	
	public void setcodeSecret(String codeS)
	{
		this.codeSecret = codeS;
	}
	
	public void setsolde(int solde)
	{
		this.solde = solde;
	}
	
	public void setdatenaiss(LocalDate datenaiss)
	{
		this.datenaiss = datenaiss;
	}
	
	public void setmail(String mail)
	{
		this.mail = mail;
	}
	
	
	
	
	
	
	
}
