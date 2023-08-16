/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecole_serveurrmi;

import DBAccess.AccessBD;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class EtudiantServeur extends UnicastRemoteObject implements Interfaces.IGestionEcole{

    public EtudiantServeur() throws RemoteException {
    }
    @Override
    public String resultatEtudiant(String _matricule, String _resultat) throws RemoteException {
         String req = "UPDATE t_etudiant SET resultat = '"+_resultat + "' WHERE matricule ='"+_matricule+"' "; //To change body of generated methods, choose Tools | Templates."
        int reponseBD=0;
        try {
            reponseBD = AccessBD.updateQuery(req);
            if (reponseBD ==1){
                return "Etudiant enregistré";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error de modification resultat etudiant";
    }
    @Override
    public String insererEtudiant(String matricule, String nomComplet, String tel, String promotion) throws RemoteException {
        String req = "INSERT INTO t_etudiant (matricule,nomComplet , tel, promotion, resultat) VALUES('"+matricule+"','"+nomComplet+"','"+tel+"','"+promotion+"', 0)"; //To change body of generated methods, choose Tools | Templates."
        int reponseBD=0;
        System.out.println("Nom: " + nomComplet  + ", Mat : " + matricule + ", Tel : " + tel + ", Promotion : "+ promotion);
        try {
            reponseBD = AccessBD.insertQuery(req);
            if (reponseBD ==1){
                return "Etudiant enregistré";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error d'enregistrement";
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String supprimerEtudiant(String matricule) throws RemoteException {
        String req1 = "DELETE FROM t_etudiant " + "WHERE matricule = '"+matricule+"'"; //To change body of generated methods, choose Tools | Templates.
               int reponseBD=0;
               try {
                   reponseBD = AccessBD.deleteQuery(req1);
                   if (reponseBD ==1){
                       return "Reservation enregistré";
                   }
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
               }
               return "Erreur de suppression";        
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modifierEtudiant(String matricule, String nomComplet, String tel, String promotion) throws RemoteException {
        String req = "UPDATE t_etudiant SET  nomComplet = '"+nomComplet + "', tel = '"+tel + "', promotion = '"+promotion + "'  WHERE matricule ='"+matricule+"' "; //To change body of generated methods, choose Tools | Templates."
        int reponseBD=0;
        try {
            reponseBD = AccessBD.updateQuery(req);
            if (reponseBD ==1){
                return "Etudiant modifier";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Erreur de modification";
    }

    @Override
    public ArrayList afficherEtudiants() throws RemoteException {
         ResultSet rep_BD = null;
         ArrayList<String> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM t_etudiant";//To change body of generated methods, choose Tools | Templates.
            rep_BD = AccessBD.afficherReq(req);
            while (rep_BD.next()){
                list.add(rep_BD.getString(3));
                //return "matricule :"+rep_BD.getString(1)+"\nnomComplet : "+rep_BD.getString(2)+"\nTel :"+rep_BD.getString(3)+"\nPromotion :"+rep_BD.getString(4);
            }
            return list;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list;
       
    }

    @Override
    public String detailsResultatEtudiant(String matricule) throws RemoteException {
        ResultSet rep_BD = null;
        try {
            //System.out.println("Matricule : "+matricule);
            String req = "SELECT * FROM t_etudiant e, t_frais f WHERE e.matricule = f.matriculeEtudiant AND e.matricule = '"+matricule+"'";//To change body of generated methods, choose Tools | Templates.
            rep_BD = AccessBD.afficherReq(req);
            while (rep_BD.next()){
                if(rep_BD.getString(8).equals("900")){
                    return "matricule :"+rep_BD.getString(2)+", nomComplet : "+rep_BD.getString(3)+" a reussi avec "+rep_BD.getString(6);
                }
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "Vous n'etes pas en ordre avec le frais academique";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String payeFraisAcademique(String matriculeEtudiant, String montantPaye) throws RemoteException {
        String req = "INSERT INTO t_frais (montantPaye,matriculeEtudiant) VALUES('"+montantPaye+"','"+matriculeEtudiant+"')"; //To change body of generated methods, choose Tools | Templates."
        int reponseBD=0;
        try {
            reponseBD = AccessBD.insertQuery(req);
            if (reponseBD ==1){
                return "Etudiant enregistré";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Operation echoue"; 
    }

    @Override
    public String objectPublieParServeur() throws RemoteException {
        return "-----------LISTE METHODES PUBLIEES----------------\n"
                + "1. Creer_Etudiant\n"
                + "2. Supprimer_Etudiant\n"
                + "3. Modifier_Etudiant\n"
                + "4. Afficher_les_etudiants\n"
                + "5. Payer_frais\n"
                + "6. Resultat_etudiant\n"
                + "7. Coter_etudiant\n"
                + "8. Methodes_publiees";
    }

  
    
}
