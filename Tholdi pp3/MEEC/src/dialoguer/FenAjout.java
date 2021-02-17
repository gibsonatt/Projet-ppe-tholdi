/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialoguer;

import entite.Allee;
import entite.Emplacement;
import entite.ModeleConteneur;
import entite.Quai;
import entite.Taille;
import java.awt.Toolkit;

/**
 *
 * @author Packard Bell
 */
public class FenAjout extends javax.swing.JFrame {

    private void complementGUI(){
        //Affiche le logo
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo/Tholdisimplepetit.png")));
        //Affiche le nom
     setTitle("MEEC");
    }
    public FenAjout() {
        initComponents();
        complementGUI();
        listeQuai();
        listeModeleConteneur();   
    }

    


private void listeModeleConteneur(){
    
    int i;
    ModeleConteneur unmodele = new ModeleConteneur();
    jCombo_Type.removeAllItems();
    jCombo_Type.addItem("");
    for(i=0;i<unmodele.getLesEnrg().size();i++){
        jCombo_Type.addItem(unmodele.getLesEnrg().get(i).getTypelibel());
    }
}
        private void listeTaille(String modele){
        int i;
        Taille uneTaille = new Taille(modele);
        jCombo_Taille.removeAllItems();
        jCombo_Taille.addItem("");
        for(i=0;i<uneTaille.getLesEnrg().size();i++){  
        jCombo_Taille.addItem(uneTaille.getLesEnrg().get(i).getTaillong()+"-"+uneTaille.getLesEnrg().get(i).getTaillarg()+"-"+uneTaille.getLesEnrg().get(i).getTailhaut());
    }
        
    }
    
    private void listeAllee(String unQuai){
        int i;
        Allee uneAllee = new Allee(unQuai);
        jComboAllee.removeAllItems();
        jComboAllee.addItem("");
        for(i=0;i<uneAllee.getLesEnrg().size();i++){
            jComboAllee.addItem(uneAllee.getLesEnrg().get(i).getNumAllee());
        
    }
        
    }
     private void listeQuai(){
        int i;
        Quai unQuai = new Quai();
        jComboQuai.removeAllItems();
        jComboQuai.addItem("");
        for(i=0;i<unQuai.getLesEnrg().size();i++){
        jComboQuai.addItem(unQuai.getLesEnrg().get(i).getNumQuai());
    }
        
    }
     private void listeEmplacement(String unQuai, String uneAllee){
        int i;
        Emplacement unEmplacement = new Emplacement(unQuai, uneAllee);
        jComboEmplacement.removeAllItems();
        jComboEmplacement.addItem("");
        for(i=0;i<unEmplacement.getLesEnrg().size();i++){
            jComboEmplacement.addItem(unEmplacement.getLesEnrg().get(i).getNumemplacement());
        
    }
        
      
     }
     private void videEmplacement(){
         jComboEmplacement.removeAllItems();
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLab_cont = new javax.swing.JLabel();
        jLab_Type = new javax.swing.JLabel();
        jLab_taille = new javax.swing.JLabel();
        jTextField_NumCont = new javax.swing.JTextField();
        jComboQuai = new javax.swing.JComboBox<>();
        jButtonRetour = new javax.swing.JButton();
        jCombo_Type = new javax.swing.JComboBox<>();
        jCombo_Taille = new javax.swing.JComboBox<>();
        jComboEmplacement = new javax.swing.JComboBox<>();
        jTextField_EtageCont = new javax.swing.JTextField();
        jLab_Quai = new javax.swing.JLabel();
        jComboAllee = new javax.swing.JComboBox<>();
        jLab_Allee = new javax.swing.JLabel();
        jLab_etage = new javax.swing.JLabel();
        jLab_emplacement = new javax.swing.JLabel();
        jBut_Ajouter = new javax.swing.JButton();
        jBut_Quitter = new javax.swing.JButton();
        jLab_Titre = new javax.swing.JLabel();
        jLab_Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLab_cont.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_cont.setText("Numero du conteneur");
        getContentPane().add(jLab_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 180, 40));

        jLab_Type.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_Type.setText("Type du conteneur");
        getContentPane().add(jLab_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 170, -1));

        jLab_taille.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_taille.setText("Taille du conteneur");
        getContentPane().add(jLab_taille, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 160, -1));
        getContentPane().add(jTextField_NumCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 200, 40));

        jComboQuai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboQuaiItemStateChanged(evt);
            }
        });
        jComboQuai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboQuaiActionPerformed(evt);
            }
        });
        getContentPane().add(jComboQuai, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 200, 30));

        jButtonRetour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRetour, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 90, 50));

        jCombo_Type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCombo_Type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombo_TypeItemStateChanged(evt);
            }
        });
        getContentPane().add(jCombo_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 200, 30));

        jCombo_Taille.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCombo_Taille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombo_TailleItemStateChanged(evt);
            }
        });
        getContentPane().add(jCombo_Taille, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 200, 30));

        jComboEmplacement.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboEmplacementItemStateChanged(evt);
            }
        });
        jComboEmplacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmplacementActionPerformed(evt);
            }
        });
        getContentPane().add(jComboEmplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 200, 30));
        getContentPane().add(jTextField_EtageCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 200, 30));

        jLab_Quai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_Quai.setText("Quai");
        getContentPane().add(jLab_Quai, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jComboAllee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboAlleeItemStateChanged(evt);
            }
        });
        jComboAllee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAlleeActionPerformed(evt);
            }
        });
        getContentPane().add(jComboAllee, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 200, 30));

        jLab_Allee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_Allee.setText("Allee");
        getContentPane().add(jLab_Allee, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jLab_etage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_etage.setText("Etage");
        getContentPane().add(jLab_etage, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        jLab_emplacement.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLab_emplacement.setText("Emplacement");
        getContentPane().add(jLab_emplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jBut_Ajouter.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jBut_Ajouter.setText("Ajouter");
        jBut_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_AjouterActionPerformed(evt);
            }
        });
        getContentPane().add(jBut_Ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, 40));

        jBut_Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accueil/quitter1.png"))); // NOI18N
        jBut_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(jBut_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, 50));

        jLab_Titre.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLab_Titre.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Titre.setText("MEEC");
        getContentPane().add(jLab_Titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 40));

        jLab_Fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fond.jpg"))); // NOI18N
        getContentPane().add(jLab_Fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        MenuPrincipale uneFenetre = new MenuPrincipale();
        uneFenetre.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    private void jBut_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBut_QuitterActionPerformed

    private void jComboQuaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboQuaiItemStateChanged
        if(jComboQuai.getSelectedIndex() > 0) {
            listeAllee(jComboQuai.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboQuaiItemStateChanged

    private void jComboQuaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboQuaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboQuaiActionPerformed

    private void jComboAlleeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboAlleeItemStateChanged
        if(jComboAllee.getSelectedIndex() > 0 && jComboQuai.getSelectedIndex() > 0){
            listeEmplacement(jComboQuai.getSelectedItem().toString(), jComboAllee.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboAlleeItemStateChanged

    private void jComboAlleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlleeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAlleeActionPerformed

    private void jComboEmplacementItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboEmplacementItemStateChanged

    }//GEN-LAST:event_jComboEmplacementItemStateChanged

    private void jComboEmplacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmplacementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmplacementActionPerformed

    private void jCombo_TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombo_TypeItemStateChanged
       if(jCombo_Type.getSelectedIndex() > 0) {
            listeTaille(String.valueOf(jCombo_Type.getSelectedIndex()));
    }//GEN-LAST:event_jCombo_TypeItemStateChanged
    }
    private void jCombo_TailleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombo_TailleItemStateChanged

    }//GEN-LAST:event_jCombo_TailleItemStateChanged

    private void jBut_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_AjouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBut_AjouterActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenAjout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenAjout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenAjout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenAjout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenAjout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBut_Ajouter;
    private javax.swing.JButton jBut_Quitter;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JComboBox<String> jComboAllee;
    private javax.swing.JComboBox<String> jComboEmplacement;
    private javax.swing.JComboBox<String> jComboQuai;
    private javax.swing.JComboBox<String> jCombo_Taille;
    private javax.swing.JComboBox<String> jCombo_Type;
    private javax.swing.JLabel jLab_Allee;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_Quai;
    private javax.swing.JLabel jLab_Titre;
    private javax.swing.JLabel jLab_Type;
    private javax.swing.JLabel jLab_cont;
    private javax.swing.JLabel jLab_emplacement;
    private javax.swing.JLabel jLab_etage;
    private javax.swing.JLabel jLab_taille;
    private javax.swing.JTextField jTextField_EtageCont;
    private javax.swing.JTextField jTextField_NumCont;
    // End of variables declaration//GEN-END:variables
}
