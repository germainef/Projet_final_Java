/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Date;
import java.util.ArrayList;


public interface IGestionEcole extends java.rmi.Remote{
    public String insererEtudiant(String matricule, String nomComplet, String tel, String promotion)throws java.rmi.RemoteException;
    public String supprimerEtudiant(String matricule)throws java.rmi.RemoteException;
    public String modifierEtudiant(String matricule, String nomComplet, String tel, String promotion) throws java.rmi.RemoteException;
    public ArrayList afficherEtudiants() throws java.rmi.RemoteException;
    public String detailsResultatEtudiant(String matricule) throws java.rmi.RemoteException;
    public String payeFraisAcademique(String montantPaye, String matriculeEtudiant) throws java.rmi.RemoteException;
    public String objectPublieParServeur()throws java.rmi.RemoteException;
    public String resultatEtudiant(String _matricule, String _resultat) throws java.rmi.RemoteException;
}
