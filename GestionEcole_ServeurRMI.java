/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecole_serveurrmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestionEcole_ServeurRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Registry annuaire = LocateRegistry.createRegistry(1955);
            EtudiantServeur objectDistant = new EtudiantServeur(){};
            annuaire.rebind("Creer_Etudiant", objectDistant);
            annuaire.rebind("Supprimer_Etudiant", objectDistant);
            annuaire.rebind("Afficher_les_etudiants", objectDistant);
            annuaire.rebind("Payer_frais", objectDistant);
            annuaire.rebind("Resultat_etudiant", objectDistant);
            annuaire.rebind("Coter_etudiant", objectDistant);
            annuaire.rebind("Modifier_Etudiant", objectDistant);
            annuaire.rebind("Methodes_publiees", objectDistant);
            
            System.out.println("Serveur est pret");
        } catch (RemoteException ex) {
            Logger.getLogger(GestionEcole_ServeurRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
