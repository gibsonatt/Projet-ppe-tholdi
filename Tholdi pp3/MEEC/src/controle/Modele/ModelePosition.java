/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.Modele;

import entite.Position;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miguel GUTIEREZ
 */
public class ModelePosition extends AbstractTableModel{
    Position instancePosition;
    private ArrayList<Position> lesDonnees;
    private final String[] lesTitres= {"Etage", "N°Conteneur"};
    
    public ModelePosition(String Quai, String Allee, String Emplacement, boolean vide) {
        this.instancePosition= new Position(Emplacement, Quai,Allee,vide);
        this.lesDonnees = instancePosition.getLesEnrg(); 
    }

    @Override
    public int getRowCount() {
        return lesDonnees.size(); // Donne la taille de la collection LesDonnees
    }

    @Override
    public int getColumnCount() {
            return lesTitres.length; // Donne le nombre de colonne dans le modèle
    }

    @Override
    public String getColumnName(int columnIndex){
        return lesTitres[columnIndex]; 
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return lesDonnees.get(rowIndex).getNumEtage();
            case 1: return lesDonnees.get(rowIndex).getNumCont();
            default : return null; 
        }
    }
    
}
