
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccessBD {
     public static Connection etablirConnexion() throws ClassNotFoundException, SQLException {
        //chargement des pilotes
        Class.forName("com.mysql.jdbc.Driver");
        //chaine de connexion a la base de donnees
        String chaineConnexion="jdbc:mysql://localhost:3306/bdgestionecole";
        //creation de la connexion 
        Connection con=DriverManager.getConnection(chaineConnexion, "root", "");
        return con;
    }
    
    public static ResultSet afficherReq(String req) throws ClassNotFoundException, SQLException{
        Statement state=etablirConnexion().createStatement();
        ResultSet resultat =state.executeQuery(req);
        
        return resultat;
    }
    
    public static int insertQuery(String req) throws ClassNotFoundException, SQLException{
        Statement state=etablirConnexion().createStatement();
        int reponse=state.executeUpdate(req);
        
        return reponse;
    }
    
    public static int updateQuery(String req) throws ClassNotFoundException, SQLException{
        Statement state=etablirConnexion().createStatement();
        int reponse=state.executeUpdate(req);
        
        return reponse;
    }
    
      
    public static int deleteQuery(String req) throws ClassNotFoundException, SQLException{
        Statement state=etablirConnexion().createStatement();
        int reponse=state.executeUpdate(req);
        
        return reponse;
    }
}
