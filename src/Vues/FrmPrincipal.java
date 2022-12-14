/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vues;

import Controlers.CtrlEleve;
import Tools.ConnexionBDD;

/**
 *
 * @author ninou
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */

    public FrmPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitre = new javax.swing.JLabel();
        lblChoixDeConnexion = new javax.swing.JLabel();
        btnMoniteur = new javax.swing.JButton();
        btnEleve = new javax.swing.JButton();
        btnAdministrateur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblTitre.setText("LeRebours-auto");

        lblChoixDeConnexion.setText("Vous voulez vous connecter en tant que  :");

        btnMoniteur.setText("Moniteur");
        btnMoniteur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoniteurMouseClicked(evt);
            }
        });

        btnEleve.setText("Elève");
        btnEleve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEleveMouseClicked(evt);
            }
        });
        btnEleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEleveActionPerformed(evt);
            }
        });

        btnAdministrateur.setText("Administrateur ");
        btnAdministrateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdministrateurMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblChoixDeConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdministrateur)
                    .addComponent(btnMoniteur, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitre)
                .addGap(28, 28, 28)
                .addComponent(lblChoixDeConnexion)
                .addGap(18, 18, 18)
                .addComponent(btnEleve)
                .addGap(18, 18, 18)
                .addComponent(btnMoniteur)
                .addGap(18, 18, 18)
                .addComponent(btnAdministrateur)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEleveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEleveActionPerformed

    private void btnEleveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEleveMouseClicked
        // TODO add your handling code here:
        
               FrmEleveConnexion frm = new FrmEleveConnexion();
               frm.setVisible(true);
    }//GEN-LAST:event_btnEleveMouseClicked

    private void btnMoniteurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoniteurMouseClicked
         FrmMoniteurConnexion frm = new FrmMoniteurConnexion();
         frm.setVisible(true);
    }//GEN-LAST:event_btnMoniteurMouseClicked

    private void btnAdministrateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdministrateurMouseClicked
         FrmAdministrateurConnexion frm = new FrmAdministrateurConnexion();
         frm.setVisible(true);
    }//GEN-LAST:event_btnAdministrateurMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
                
                System.out.println("Hello Nathan, Brahim and Cédric");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrateur;
    private javax.swing.JButton btnEleve;
    private javax.swing.JButton btnMoniteur;
    private javax.swing.JLabel lblChoixDeConnexion;
    private javax.swing.JLabel lblTitre;
    // End of variables declaration//GEN-END:variables
}
