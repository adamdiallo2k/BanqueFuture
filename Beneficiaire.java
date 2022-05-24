package TestMenuBar;
import java.sql.ResultSet;
import java.util.Scanner;

public class Beneficiaire {
	private String nom;
	private String prenom;
	private String IBAN;
	private int idDonnant;
	
	
	public Beneficiaire( String nom, String prenom, String IBAN, int numd )
	{
		this.setnom(nom);
		this.setprenom(prenom);
		this.setIban(IBAN);
		this.setidDonnant(numd);
		  
	}
	
	
	
	public String getnom()
	{
		return this.nom;
	}
	
	public String getprenom()
	{
		return this.prenom;
	}
	
	public String getIban()
	{
		return this.IBAN;
	}
	
	public int getidDonnant()
	{
		return this.idDonnant;
	}

	public void setnom(String nom)
	{
		this.nom = nom;
	}
	
	public void setprenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	public void setIban(String Iban)
	{
		this.IBAN = Iban;
	}
	
	public void setidDonnant(int IDdonnant)
	{
		this.idDonnant = idDonnant;
	}
	
	
}
