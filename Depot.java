package TestMenuBar;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Scanner;

public class Depot {
	private int numC;
	private Timestamp DateDepot;
	private int montantDepot;
	private String justificatif;
	
	

	public Depot( int numC,int montantDepot)
	{
		this.setnumc(numC);
		this.setmontant(montantDepot);
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		this.DateDepot = date;
		this.setjustificatif(null);
		
		  
		
	}
	
	// Au cas ou le Depot est supérieur ou égal 8000 euro
	public Depot( int numC,int montantDepot, String justificatif)
	{
		this.setnumc(numC);
		this.setmontant(montantDepot);
		this.setmontant(montantDepot);
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		this.DateDepot = date;
		this.setjustificatif(justificatif);
		  
		
	}
	
	
	public int getmontantDepot()
	{
		return this.montantDepot;
	}
	
	public String getjustificatif()
	{
		return this.justificatif;
	}
	
	public int getnumc()
	{
		return this.numC;
	}
	
	
	// setters
	public void setmontant(int montant)
	{
		this.montantDepot = montant;
		
	}
	
	public void setjustificatif(String justificatif)
	{
		this.justificatif = justificatif;
	}
	
	public void setnumc(int numc)
	{
		this.numC = numc;
	}
	
	
}
