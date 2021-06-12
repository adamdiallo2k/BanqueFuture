/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 - 11 : Fichiers communs au projet
#	Section  : Projet
#	Fichier  : Compte.java
#	Class    : Compte
*/
import java.util.*;
import java.io.*;
public class Compte implements Serializable	{
	// déclaration des variables
 private String typeCpte ;
 protected double val_courante;
 private String numéroCpte ;
 private LigneComptable []ligne;
 // constante qui a pour valeur 10 
 public static final int NBLigne = 10 ;
 private int nbLigneRéel ;  
 public Compte () 	{ 
        Scanner lectureClavier = new Scanner(System.in);
        // fonction qui permet de controller et de saisir le type d'un compte
	this.typeCpte = contrôleType();
	System.out.print("Numéro du compte : ");
	this.numéroCpte = lectureClavier.next();
	this.val_courante = contrôleValinit();  
	this.ligne = new LigneComptable[NBLigne];
	this.nbLigneRéel = -1;
 }

 public  Compte( String type)  {
        Scanner lectureClavier = new Scanner(System.in);
        // Si le c'est un compte éparne on demande la valeur courante
	if (type.equalsIgnoreCase("Epargne")) {
		this.typeCpte = type;
		System.out.print("Numéro du compte : ");
		this.numéroCpte = lectureClavier.next();
		this.val_courante = contrôleValinit();   
		this.ligne = new LigneComptable[NBLigne];
		this.nbLigneRéel = -1;
   	}
 }
 public LigneComptable quelleLigne(int n)	{
		return ligne[n];
 }
	
 public int combienLignes() {
		return this.nbLigneRéel;
 }

 public String quelTypeDeCompte() 	{
	 // retourne le type du compte
		return this.typeCpte;
 }
 public String quelNuméroDeCompte()	{
	 // retourne le numéro du compte
		return this.numéroCpte;
 }
 public double quelleValeurCourante()	{
	 // retourne la valeur courante
		return this.val_courante;
 }
 private String contrôleType()		{
                Scanner lectureClavier = new Scanner(System.in);
		char tmpc;
		String tmpS = "";
		do {
			// saisie du type de compte si valeur incorect la boucle s'active et renvoie la même question
				System.out.print("Type du compte [Types possibles :" ); 
				System.out.print("C(ourant), J(oint)] : ");
				tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'C' && tmpc != 'J' );
		switch (tmpc) {
			case 'C' : tmpS = "Courant";
			break;
			case 'J' : tmpS = "Joint";
			break;
		}
		return tmpS;
 }
 private double contrôleValinit()	 {
	 // permet de saisir et de vérifier la valeur initiale d'un compte
                Scanner lectureClavier = new Scanner(System.in);
		double tmp, tmpval;
		do {
			System.out.print("Valeur initiale du compte : ");
			tmpval= lectureClavier.nextDouble();  
		} while ( tmpval <= 0);
		return tmpval;
 }
 public void créerLigne() {
		nbLigneRéel++;
		// tant que le nombre de ligne ne dépasse pas 10 , créer un compte
		if (this.nbLigneRéel < NBLigne) 
			this.ligne [this.nbLigneRéel] = new LigneComptable();
		else {
			//sinon on décale toutes les lignes vers le haut et la nouvelle ligne comptable apparait à la dernière position
			this.nbLigneRéel--;
			décalerLesLignes();
			this.ligne [this.nbLigneRéel] = new LigneComptable();
		}
		this.val_courante =this.val_courante + ligne[this.nbLigneRéel].quelleValeur();
 }
 private void décalerLesLignes() {
	 // permet de changer la position des lignes 
		for(int i = 1; i < NBLigne ; i++)
		this.ligne[i-1] = this.ligne[i];
 }
 public  void afficherCpte() {
	 // permet d'afficher les valeurs d'un compte
		System.out.print("Le compte n° : " + this.numéroCpte );
		System.out.println(" est un compte "+typeCpte);
		if (nbLigneRéel >=0) {
			for (int i = 0; i <= this.nbLigneRéel; i++) ligne[i].afficherLigne();
		}
		System.out.println("Valeur courante : " + val_courante);
		if (this.val_courante < 0) System.out.println("Attention compte débiteur ... !!!");
 }
}