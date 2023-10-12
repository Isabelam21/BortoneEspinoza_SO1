/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bortoneespinoza_so1;

import java.awt.BorderLayout;

/**
 *
 * @author isabe
 */
public class Grafico extends javax.swing.JFrame {

    /**
     * Creates new form Grafico
     */
    public Grafico() {
        initComponents();
        
        MainPanel mp = new MainPanel();
        mp.setSize(470,410);
        mp.setLocation(0, 0);
        
        content.removeAll();
        content.add(mp, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bg = new javax.swing.JPanel();
        Principal = new javax.swing.JButton();
        Nintendo = new javax.swing.JButton();
        Bethesda = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bg.setBackground(new java.awt.Color(0, 0, 0));

        Principal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Principal.setText("Main");
        Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrincipalActionPerformed(evt);
            }
        });

        Nintendo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Nintendo.setText("Nintendo");
        Nintendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NintendoActionPerformed(evt);
            }
        });

        Bethesda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Bethesda.setText("Bethesda");
        Bethesda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BethesdaActionPerformed(evt);
            }
        });

        content.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BgLayout = new javax.swing.GroupLayout(Bg);
        Bg.setLayout(BgLayout);
        BgLayout.setHorizontalGroup(
            BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nintendo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bethesda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BgLayout.setVerticalGroup(
            BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nintendo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bethesda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 620, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NintendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NintendoActionPerformed
        NintendoPanel np = new NintendoPanel();
        np.setSize(470,410);
        np.setLocation(0, 0);
        
        content.removeAll();
        content.add(np, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_NintendoActionPerformed

    private void BethesdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BethesdaActionPerformed
        BethesdaPanel bp = new BethesdaPanel();
        bp.setSize(470,410);
        bp.setLocation(0, 0);
        
        content.removeAll();
        content.add(bp, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_BethesdaActionPerformed

    private void PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrincipalActionPerformed
        MainPanel mp = new MainPanel();
        mp.setSize(470,410);
        mp.setLocation(0, 0);
        
        content.removeAll();
        content.add(mp, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_PrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bethesda;
    private javax.swing.JPanel Bg;
    private javax.swing.JButton Nintendo;
    private javax.swing.JButton Principal;
    private javax.swing.JPanel content;
    // End of variables declaration//GEN-END:variables
}
