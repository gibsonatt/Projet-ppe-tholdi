/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.Connexion;

import entite.Parametres;
import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miguel GUTIEREZ
 */
public abstract class ControleConnexion {
    static Parametres lesParametres;
    static boolean etatConnexion;
    static Connection laConnectionStatique; 
    static{
        
        boolean ok = true; 
        lesParametres = new Parametres();
        try {
            Class.forName(lesParametres.getDriverSGBD());
            etatConnexion = true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Classe non trouvée pour le chargement du pilote JDBC", "ALERTE",JOptionPane.ERROR_MESSAGE);
            ok = false;
            etatConnexion = false;
        }
        // etablir la connexion
        
        if(ok){
            try {
                    String urlBD = lesParametres.getServeurBD();
                    String nomUtilisateur = lesParametres.getNomUtilisateur();
                    String mDP = lesParametres.getMotDePasse();
                    laConnectionStatique = (Connection) DriverManager.getConnection(urlBD, nomUtilisateur, mDP);
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Impossible de se connecter à la base de données", "ALERTE", JOptionPane.ERROR_MESSAGE);
                etatConnexion = false;
            }
            
        }
    }

    public static boolean isEtatConnexion() {
        return etatConnexion;
    }

    public static Connection getLaConnectionStatique() {
        return laConnectionStatique;
    }
    
    // Fonction controle USER MDP
    
    public static boolean control(String nom, String mdp){
        boolean verification;
        if(nom.equals(lesParametres.getNomUser()) && mdp.equals(lesParametres.getMdpUser())){
            verification= etatConnexion;
        }else{
            JOptionPane.showMessageDialog(null,"Vérifiez votre saisie", "ALERTE", JOptionPane.ERROR_MESSAGE);
            verification = false;
        }
        return verification; 
    }

    public static void fermetureSession(){
        try {
            laConnectionStatique.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Fermeture de la connexion impossible","ALERTE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
