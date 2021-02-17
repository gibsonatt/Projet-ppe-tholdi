/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Charles
 */
public class Quai {
    private String numQuai;
    private static Connection laConnexion = controle.Connexion.ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Quai> lesEnrg = new ArrayList();

    public String getNumQuai() {
        return numQuai;
    }

    public void setNumQuai(String numQuai) {
        this.numQuai = numQuai;
        
        
    }
    public static Connection getLaConnexion(){
        return laConnexion;
    }

    public ArrayList<Quai> getLesEnrg() {
        return lesEnrg;
    }

  public Quai(){
      lireRecup("");
  }
  public Quai(String numQ){
      numQuai=numQ;
  }
  
  private void lireRecup(String numQ){
        try {
            //Lire la base de donnée et remplir le tableau lesEnrg
            if (numQ.equals("")){
                numQ="%";
            }
            String reqSQL ="SELECT * FROM quai WHERE numquai LIKE '"+ numQ + "'";
            // on vide les enregistrements
            lesEnrg.retainAll(lesEnrg);
            // creer statement
            Statement state = laConnexion.createStatement();
            // executer la requete SQL
            ResultSet rs= state.executeQuery(reqSQL);
            // precourir les resultat et alimente lesEnrg
            while(rs.next()){
                //recupere dans des variables le resultat SELECT
                String unQuai = rs.getString("numquai");
                
                lesEnrg.add( new Quai(unQuai));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Probleme sur les enregistrement ","Resultat", JOptionPane.ERROR_MESSAGE);
        }
        
        
      
      
  }
  public boolean modifier(String oldQ, String newQ){
      
        boolean bmodifier = false;
        String requete = null;
      try{
        requete="UPDATE quai set numquai=? Where numquai = ?";
        PreparedStatement prepare = laConnexion.prepareStatement(requete);
        prepare.setString(1,newQ);
        prepare.setString(2, oldQ);
        prepare.executeUpdate();
        bmodifier=true;
      }catch (SQLException ex){
          
          JOptionPane.showMessageDialog(null,"Modification rencontrée, probleme rencontreé","Probleme",JOptionPane.ERROR_MESSAGE);
      }
      return bmodifier;
      }
  
  public boolean supprimer(String numQ){
      
      boolean bsupprimer = false;
      String req = null;
      try{
          
        Allee uneAllee = new Allee(numQ);
        if(uneAllee.getLesEnrg().size() == 0){
        req="DELETE FROM Quai WHERE numquai=?";
        PreparedStatement prepare = laConnexion.prepareStatement(req);
        prepare.setString(1,numQ);
        prepare.execute();
        prepare.close();
        bsupprimer = true;
        }else{
            JOptionPane.showMessageDialog(null, "Le quai ne peut pas être supprimé, il y a encore des allées", "ALERTE", JOptionPane.INFORMATION_MESSAGE);
        }
      }catch (SQLException ex){
          JOptionPane.showMessageDialog(null,"Modification rencontrée, probleme rencontreé","Probleme",JOptionPane.ERROR_MESSAGE); 
      }   
      return bsupprimer;
  }
  
  public boolean creer(String newQ)
  {
      boolean bcreer= false;
      String req =null;
      try{
        req = "INSERT INTO quai VALUES (?)";
        PreparedStatement prepare = laConnexion.prepareStatement(req);
        prepare.setString(1,newQ);
        prepare.execute();
        prepare.close();
        bcreer=true;
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"ajout non effectuée","Probleme",JOptionPane.ERROR_MESSAGE);        
      }
      
      return bcreer;
      }
  
  
  }  
     
  
