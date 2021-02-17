/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Packard Bell
 */
public class Taille {
     String taillcode;	
     String taillong;
     String taillarg;
     String tailhaut;
    private static Connection laConnexion = controle.Connexion.ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Taille> lesEnrg = new ArrayList();

    public String getTaillcode() {
        return taillcode;
    }

    public String getTaillong() {
        return taillong;
    }

    public String getTaillarg() {
        return taillarg;
    }

    public String getTailhaut() {
        return tailhaut;
    }

    public ArrayList<Taille> getLesEnrg() {
        return lesEnrg;
    }

    public void setTaillcode(String taillcode) {
        this.taillcode = taillcode;
    }

    public void setTaillong(String taillong) {
        this.taillong = taillong;
    }

    public void setTaillarg(String taillarg) {
        this.taillarg = taillarg;
    }

    public void setTailhaut(String tailhaut) {
        this.tailhaut = tailhaut;
    }

    public Taille(String taillcode, String taillong, String taillarg, String tailhaut) {
        this.taillcode = taillcode;
        this.taillong = taillong;
        this.taillarg = taillarg;
        this.tailhaut = tailhaut;
    }
    
    public Taille(String modele){
        lireRecup(modele);
    }
    
    
    
       private void lireRecup(String modele){
        try {
           
            String reqSQL ="SELECT * FROM taille Join contener on (taillcode=conttaille) WHERE conttype="+modele;
            //On vide les enregistrements
            lesEnrg.retainAll(lesEnrg);
            //On créé un statement
            Statement state = laConnexion.createStatement();
            //Executer la requete SQL
            ResultSet rs = state.executeQuery(reqSQL);
            //Parcourir les resultats et alimenter les enregistrements
            while(rs.next()){
                //recupere dans les variables du SELECT
                String untaillcode = rs.getString("taillcode");
                String untaillong = rs.getString("taillong");
                String untaillarg = rs.getString("taillarg");
                String untailhaut = rs.getString("tailhaut");
                //on ajoute le quai à la liste des entregistrements
                lesEnrg.add(new Taille(untaillcode, untaillong, untaillarg, untailhaut));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur : "+ex.getMessage(),"ALERTE",JOptionPane.ERROR_MESSAGE);
        }
    } 
    
}
	



