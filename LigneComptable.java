
import java.io.*;
import java.text.*;
import java.util.*;
public class LigneComptable implements Serializable {
	// déclaration des variables
	private double valeur;
	private String date;
	private String motif;
	private String mode;

	public LigneComptable() {
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = lectureClavier.nextDouble();
		motif = contrôleMotif();
			// utilisation de la méthode controleMode pour controler le mode
	    	mode = contrôleMode();
	    	// utilisation de la méthode controleDate pour controller la date
   	        date = contrôleDate();
	}
	
	private String contrôleDate() {
                Scanner lectureClavier = new Scanner(System.in);
		int nb = 0;
		Date d = null;
		SimpleDateFormat formatIn=new SimpleDateFormat("dd/MM/yyyy"); 
		String sdate;
		while (d == null){
	   	try {
	   		// obligation de saisir une date
       	          System.out.print("Entrer une date (jj/mm/aaaa): ");
	     	  d = formatIn.parse(lectureClavier.next());
                }
	    	catch( ParseException p) {
		    nb++;
		    if (nb  >= 3) d = new Date();
	     }
	   }
    	sdate = formatIn.format(d); 
    	return sdate;
	}
	
	private String contrôleMode() {
		// permet de controler la validité du mode de paiement
                Scanner lectureClavier = new Scanner(System.in);
		String tmpS = "";
		char tmpc ;
		do {
			System.out.print("Mode [C(B), N(° Cheque), V(irement ) ]  : ");
			tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'C' && tmpc != 'N' && tmpc != 'V');
		switch (tmpc) {
			case 'C' : tmpS = "CB";
			break;
			case 'N' : tmpS = "Cheque";
			break;
			case 'V' : tmpS = "Virement";
			break;		
		}
		return tmpS;
	}
	private String contrôleMotif() {
                Scanner lectureClavier = new Scanner(System.in);
		String tmpS = "";
		char tmpc ;
		do {
			// vérifie que la saisie du motif est bonne 
			System.out.print("Motif de l'operation [S(alaire),");
			System.out.print(" L(oyer), A(limenation), D(ivers)] : ");
			tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
		switch (tmpc) {
			case 'S' : tmpS = "Salaire";
			break;
			case 'L' : tmpS = "Loyer";
			break;
			case 'A' : tmpS = "Alimentation";
			break;		
			case 'D' : tmpS = "Divers";
			break;
		}
		return tmpS;
	}
	public double quelleValeur() {
		// retourner la valeur 
		return this.valeur ;
	}
	public String quelMotif(){
		// retourner le motif
		return this.motif ;
	}
	public String quelMode(){
		// retourner le mode 
		return this.mode ;
	}
	public String quelleDate(){
		// retourner la date
		return this.date ;
	}
	public void afficherLigne()  {
		// on vérifie que la ligne posssede une valeur supérieur à zéro
		if (this.valeur < 0) 
		System.out.print("Débiter : "+this.valeur);
		else
    	System.out.print("Créditer : "+this.valeur);
		System.out.println(" le : "+ this.date +" motif  : " +this.motif+ " mode : "+this.mode);
	}
}