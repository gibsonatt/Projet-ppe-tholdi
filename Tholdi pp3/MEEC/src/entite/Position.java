/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Packard Bell
 */
public class Position {
    
    String numPosition;
    String numEmplacement;
    String numAllee;
    String numQuai;
    String numEtage;
    String numCont;
    private static Connection laConnexion = controle.Connexion.ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Position> lesEnrg = new ArrayList();

   

    public String getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(String numPosition) {
        this.numPosition = numPosition;
    }

    public String getNumEmplacement() {
        return numEmplacement;
    }

    public void setNumEmplacement(String numEmplacement) {
        this.numEmplacement = numEmplacement;
    }

    public String getNumAllee() {
        return numAllee;
    }

    public void setNumAllee(String numAllee) {
        this.numAllee = numAllee;
    }

    public String getNumQuai() {
        return numQuai;
    }

    public void setNumQuai(String numQuai) {
        this.numQuai = numQuai;
    }

    

    public String getNumEtage() {
        return numEtage;
    }

    public void setNumEtage(String numEtage) {
        this.numEtage = numEtage;
    }

    public String getNumCont() {
        return numCont;
    }

    public void setNumCont(String numCont) {
        this.numCont = numCont;
    }
    
      public ArrayList<Position> getLesEnrg() {
        return lesEnrg;
    }
    
    public Position(String numPosition, String numEmplacement, String numQuai, String numAllee,  String numEtage, String numCont) {
        this.numPosition = numPosition;
        this.numEmplacement = numEmplacement;
        this.numQuai = numQuai;
        this.numAllee = numAllee;
        this.numEtage = numEtage;
        this.numCont = numCont;
    }

  

    public Position(){
        
    }
    
    public Position(String numemplacement, String numquai, String numallee,  boolean vide) {
        
        lireRecup("", numemplacement, numallee, numquai, "", "", vide);
        
    }
    
    public Position(String numemplacement, String numquai, String numallee) {
        
        lireRecup("", numemplacement, numallee, numquai, "", "", false);
        
    }
    
    public Position(String numemplacement, String numquai, String numallee, String etage, boolean vide) {
        
        lireRecup("", numemplacement, numallee, numquai,etage, "", vide);
        
    }
    
    public Position(String numcont, boolean vide){
        lireRecup("", "", "", "", "", numcont, vide); 
    }
    
    
    
    
    
    public void creer(String numposition, String numemplacement,String numquai,  String numallee, String numetage, String numcont) {
        
    String requete = null ;
    Position unePosition = new Position();
    try {
             requete = "INSERT INTO Position (numposition, numemplacement, numallee, numquai, numetage, numcont) VALUES (?, ?, ?, ?, ?, ?)";
             PreparedStatement prepare ;
             prepare = laConnexion.prepareStatement(requete);
             prepare.setString(1, numposition);
             prepare.setString(2, numemplacement);
             prepare.setString(3, numallee);
             prepare.setString(4, numquai);
             prepare.setString(5, numetage);
             prepare.setString(6, numcont);
             prepare.execute();
             prepare.close();
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Création impossible :" + ex.getMessage(), "PROBLEME", JOptionPane.ERROR_MESSAGE);
        }
    
    
        }
    
    
 
        private void lireRecup(String numposition, String numemplacement, String numallee, String numquai, String numetage, String numcont, boolean vide){
        try {
            //Lire la BDD et remplir le tab lesEnreg
            if (numposition.equals("")){
                numposition="%";//% pour que la requete envoi tout
            }
            if (numemplacement.equals("")){
                numemplacement="%";//% pour que la requete envoi tout
            }
            if (numallee.equals("")){
                numallee="%";//% pour que la requete envoi tout
            }
            if (numquai.equals("")){
                numquai="%";//% pour que la requete envoi tout
            }
            if (!numetage.equals("")){
                numetage="  AND numetage LIKE '" + numetage + "' ";//% pour que la requete envoi tout
            }
            if (numcont.equals("")){
                numcont="%";//% pour que la requete envoi tout
            }
            String requeteFin = null;
            
            if(vide){
                
                requeteFin = " AND numcont is NULL";
                
            }else{ 
                requeteFin = " AND numcont Is not null";
            }
            
            String reqSQL ="SELECT * FROM position where numposition LIKE '"+ numposition + "' and numemplacement LIKE '" + numemplacement + "' and numallee LIKE '"  + numallee + "' and  numquai LIKE '" + numquai  +"' "+ requeteFin  +" order by numquai, numallee, " + " numemplacement, numetage";
            //On vide les enregistrements
            lesEnrg.retainAll(lesEnrg);
            //On créé un statement
            Statement state = laConnexion.createStatement();
            //Executer la requete SQL
            ResultSet rs = state.executeQuery(reqSQL);
            //Parcourir les resultats et alimenter les enregistrements
            while(rs.next()){
                //recupere dans les variables du SELECT
                String numpos = rs.getString("numposition");
                String unCont = rs.getString("numcont");
                String uneAllee = rs.getString("numallee");
                String unQuai = rs.getString("numquai");
                String unEtage = rs.getString("numetage");
                String unEmplacement = rs.getString("numemplacement");
                //on ajoute le quai à la liste des entregistrements
                lesEnrg.add(new Position(numpos,unEmplacement,uneAllee,unQuai,unEtage,unCont));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problème sur les enregistrements","Resultat",JOptionPane.ERROR_MESSAGE);
        }
    }
}
