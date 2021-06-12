/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - Comprendre l'héritage
#	Fichier  : CpteEpargne.java
#	Class    : CpteEpargne
*/
import java.util.*;
public class CpteEpargne extends Compte {
	private double  taux ; 
	public CpteEpargne() {
		// le type du compte saisie dans le controleur vient de l'attribu type compte qui a pour valeur "Epargne"
		super("Epargne");
		this.taux = contrôleTaux();
	 }
	private double contrôleTaux() {
		// permet de saisir le taux de placement et de bien vérifiez que la valeur est supérieur à 0
		double tmp;
                Scanner lectureClavier = new Scanner(System.in);
		do {
			System.out.print("Taux de placement :");
			tmp = lectureClavier.nextDouble();
		} while (tmp < 0);
		return tmp;
	}
	public  void afficherCpte()   {
		// permet d'afficher un compte
		super.afficherCpte();
		System.out.println(" Taux d'epargne du compte :  " + this.taux);
	}
	public double quelTaux()	{
		// permet d'afficher le taux
		return this.taux;
	}
}