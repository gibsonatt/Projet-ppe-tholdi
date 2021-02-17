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
public class ModeleConteneur {
    
     String typecode;	
     String typelibel;
     String phototype;
    private static Connection laConnexion = controle.Connexion.ControleConnexion.getLaConnectionStatique();
    private final ArrayList<ModeleConteneur> lesEnrg = new ArrayList();

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypelibel() {
        return typelibel;
    }

    public void setTypelibel(String typelibel) {
        this.typelibel = typelibel;
    }

    public String getPhototype() {
        return phototype;
    }

    public void setPhototype(String phototype) {
        this.phototype = phototype;
    }

    public ArrayList<ModeleConteneur> getLesEnrg() {
        return lesEnrg;
    }

    public ModeleConteneur(String typecode, String typelibel, String phototype) {
        this.typecode = typecode;
        this.typelibel = typelibel;
        this.phototype = phototype;
    }
       
    public ModeleConteneur(){
        lireRecup();
    }
    
    
    
       private void lireRecup(){
        try {
           
            String reqSQL ="SELECT * FROM modele ";
            //On vide les enregistrements
            lesEnrg.retainAll(lesEnrg);
            //On créé un statement
            Statement state = laConnexion.createStatement();
            //Executer la requete SQL
            ResultSet rs = state.executeQuery(reqSQL);
            //Parcourir les resultats et alimenter les enregistrements
            while(rs.next()){
                //recupere dans les variables du SELECT
                String untypecode = rs.getString("typecode");
                String untypelibel = rs.getString("typelibel");
                String unphototype = rs.getString("phototype");
                //on ajoute le quai à la liste des entregistrements
                lesEnrg.add(new ModeleConteneur(untypecode, untypelibel, unphototype));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur : "+ex.getMessage(),"ALERTE",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    // ajouter le create
    // ajouter update
    // ajouter delete
    
    
    
    
    
}



