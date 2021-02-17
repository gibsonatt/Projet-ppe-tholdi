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
public class Allee {
    String numAllee;
    String numQuai;
    private static Connection laConnexion = controle.Connexion.ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Allee> lesEnrg = new ArrayList();

    
    public Allee(String numAllee,String numQuai) {
        this.numAllee = numAllee;
        this.numQuai = numQuai;
    }
    
    
    public Allee(){
        lireRecup("");
    }
    
    
    public Allee(String quai){
        lireRecup(quai);
    }    

    public ArrayList<Allee> getLesEnrg() {
        return lesEnrg;
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
    
    
// Avec le numéro de l'allée on lit l'entrée ou on récupère une liste de toutes les allées
    private void lireRecup(String quai){
        try {
            //Lire la BDD et remplir le tab lesEnrg
            if (quai.equals("")){
                quai="%";//% pour que la requete envoi tout
            }
            String reqSQL ="SELECT * FROM Allee WHERE numquai LIKE '" + quai +"' ORDER BY numquai, numallee";
            //On vide les enregistrements
            lesEnrg.retainAll(lesEnrg);
            //On créé un statement
            Statement state = laConnexion.createStatement();
            //Executer la requete SQL
            ResultSet rs = state.executeQuery(reqSQL);
            //Parcourir les resultats et alimenter les enregistrements
            while(rs.next()){
                //recupere dans les variables du SELECT
                String unQuai = rs.getString("numquai");
                String uneAllee = rs.getString("numallee");
                //on ajoute le quai à la liste des entregistrements
                lesEnrg.add(new Allee(uneAllee,unQuai));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur : "+ex.getMessage(),"ALERTE",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    // Avec le numéro de l'allée et du quai associé on créer
    public void creer (String numallee, String numQuai){
       
            boolean ok = true;
            if (!lesEnrg.isEmpty()){
                ok = false;
                int i;
                i = -1;
                
                do{
                    i++;
                    
                }while(!lesEnrg.get(i).numQuai.equals(numQuai) && !lesEnrg.get(i).numAllee.equals(numallee) && i < lesEnrg.size());
                if(lesEnrg.get(i).numQuai.equals(numQuai) && lesEnrg.get(i).numAllee.equals(numallee)){
                    JOptionPane.showMessageDialog(null,"Insertion non éffectuée l'allée existe déjà ! ","PROBLEME",JOptionPane.ERROR_MESSAGE);
                }else{
                    ok = true;
                }
            }
           if(ok){
                String req = null;
                try {
                req = "INSERT INTO allee (numallee, numQuai) VALUES (?,?)";

                PreparedStatement prepare = laConnexion.prepareStatement(req);
                prepare.setString(1,numallee);
                prepare.setString(2,numQuai);
                prepare.execute();
                prepare.close();
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Insertion non éffectuée dans la BDD : "+ ex.getMessage(),"PROBLEME",JOptionPane.ERROR_MESSAGE);
                }
            }
    }

    /**
     *
     * @return
     */
   

    public void supprimer(String numallee, String quai) {
        Emplacement unEmplacement = new Emplacement(numallee, quai); 
        if(unEmplacement.getLesEnrg().isEmpty()){       
            try {
                String requete = "DELETE FROM allee WHERE numallee=? and numquai=?"; 
                PreparedStatement prepare = laConnexion.prepareStatement(requete);
                prepare.setString(1,numallee);
                prepare.setString(2, quai);
                prepare.execute();
                prepare.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Suppression non effectuée :" + ex.getMessage(),"PROBLEME",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            JOptionPane.showMessageDialog(null,"Suppression impossible, l'allée contient des emplacements","PROBLEME",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
}
