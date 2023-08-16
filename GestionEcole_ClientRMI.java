/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecole_clientrmi;

import Interfaces.IGestionEcole;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;


public class GestionEcole_ClientRMI {

    /**
     * @param args the command line arguments
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException  {
        //recuperation de la reference de l'objet distant
        IGestionEcole refObjetDistant =(IGestionEcole) Naming.lookup("rmi://localhost:1955/Methodes_publiees");
        System.out.println(refObjetDistant.objectPublieParServeur());
        Scanner clavier = new Scanner(System.in);
        System.out.println("Votre choix: ");
        String objetDistant = clavier.next();
            
      IGestionEcole ref_objet_distant = (IGestionEcole) Naming.lookup("rmi://localhost:1955/"+objetDistant);
        
      if(objetDistant.equals("Creer_Etudiant")){
          System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
        System.out.print("Saisir Nom complet :");
        String _nomComplet = clavier.next();
        System.out.print("");
        System.out.print("Saisir Phone :");
        String _tel = clavier.next();
        System.out.print("Saisir Promotion :");
        String _promotion = clavier.next();
        System.out.println(refObjetDistant.insererEtudiant(_matricule, _nomComplet, _tel, _promotion));
      }else if(objetDistant.equals("Supprimer_Etudiant")){
          System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
          System.out.println(refObjetDistant.supprimerEtudiant(_matricule));
      }else if(objetDistant.equals("Coter_etudiant")){
          System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
          System.out.print("Saisir resultat :");
        String _resultat = clavier.next();
          System.out.println(refObjetDistant.resultatEtudiant(_matricule, _resultat));
      }else if(objetDistant.equals("Payer_frais")){
          System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
          System.out.print("Saisir frais :");
        String _frais = clavier.next();
          System.out.println(refObjetDistant.payeFraisAcademique(_matricule, _frais));
      }else if(objetDistant.equals("Resultat_etudiant")){
          System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
    
          System.out.println(refObjetDistant.detailsResultatEtudiant(_matricule));
    
      }else if(objetDistant.equals("Afficher_les_etudiants")){
          int compt = 0;
          while(compt < refObjetDistant.afficherEtudiants().size()){
              compt++;
              System.out.println("Etudiant "+compt+": "+refObjetDistant.afficherEtudiants().get(compt-1));
              
          }
      }
      else if(objetDistant.equals("Modifier_Etudiant")){
         System.out.print("Saisir Matricule :");
        String _matricule = clavier.next();
        System.out.print("Saisir Nom complet :");
        String _nomComplet = clavier.next();
        System.out.print("");
        System.out.print("Saisir Phone :");
        String _tel = clavier.next();
        System.out.print("Saisir Promotion :");
        String _promotion = clavier.next();
        
        System.out.println(refObjetDistant.modifierEtudiant(_matricule, _nomComplet, _tel, _promotion));
      }
        
    }
    
}
