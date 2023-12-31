/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

/**
 *
 * @author Usuario
 */
public class mainMenu extends javax.swing.JFrame {

    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imageL = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        hammingB = new javax.swing.JButton();
        huffmanB = new javax.swing.JButton();
        extension1 = new javax.swing.JLabel();
        extension2 = new javax.swing.JLabel();
        imageL3 = new javax.swing.JLabel();
        imageL2 = new javax.swing.JLabel();
        exitB = new javax.swing.JButton();
        fondo2 = new javax.swing.JLabel();
        fondo3 = new javax.swing.JLabel();
        fondo4 = new javax.swing.JLabel();
        fondo0 = new javax.swing.JLabel();
        fondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(28, 40, 61));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(18, 26, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 30));

        jPanel2.setBackground(new java.awt.Color(18, 26, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sec.png"))); // NOI18N
        imageL.setText("jLabel1");
        jPanel2.add(imageL, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, -20, 610, 480));

        menuPanel.setBackground(new java.awt.Color(28, 40, 61));
        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hammingB.setBackground(new java.awt.Color(18, 26, 51));
        hammingB.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        hammingB.setForeground(new java.awt.Color(43, 183, 246));
        hammingB.setText("HAMMING");
        hammingB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hammingB.setMaximumSize(new java.awt.Dimension(336, 36));
        hammingB.setMinimumSize(new java.awt.Dimension(336, 36));
        hammingB.setPreferredSize(new java.awt.Dimension(336, 36));
        hammingB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hammingBMouseClicked(evt);
            }
        });
        hammingB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hammingBActionPerformed(evt);
            }
        });

        huffmanB.setBackground(new java.awt.Color(18, 26, 51));
        huffmanB.setFont(new java.awt.Font("Roboto Cn", 0, 48)); // NOI18N
        huffmanB.setForeground(new java.awt.Color(43, 183, 246));
        huffmanB.setText("HUFFMAN");
        huffmanB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        huffmanB.setMaximumSize(new java.awt.Dimension(336, 36));
        huffmanB.setMinimumSize(new java.awt.Dimension(336, 36));
        huffmanB.setPreferredSize(new java.awt.Dimension(336, 36));
        huffmanB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huffmanBMouseClicked(evt);
            }
        });
        huffmanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huffmanBActionPerformed(evt);
            }
        });

        extension1.setBackground(new java.awt.Color(51, 51, 51));
        extension1.setForeground(new java.awt.Color(102, 102, 102));
        extension1.setText("proteger/desproteger");

        extension2.setBackground(new java.awt.Color(153, 153, 153));
        extension2.setForeground(new java.awt.Color(102, 102, 102));
        extension2.setText("compactar/descompactar");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(extension2)
                            .addComponent(extension1))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(hammingB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(huffmanB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(hammingB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extension1)
                .addGap(42, 42, 42)
                .addComponent(huffmanB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extension2)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 480, 320));

        imageL3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\zip.png"));
        jPanel2.add(imageL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 10, 340, 380));

        imageL2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\cir"
            + ".png"));
    jPanel2.add(imageL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, -10, 510, 430));

    background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1030, 420));

    exitB.setBackground(new java.awt.Color(18, 26, 51));
    exitB.setFont(new java.awt.Font("Roboto Slab", 0, 16)); // NOI18N
    exitB.setForeground(new java.awt.Color(255, 255, 255));
    exitB.setText("SALIR");
    exitB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            exitBActionPerformed(evt);
        }
    });
    background.add(exitB, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 520, 90, 30));

    fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a.gif"))); // NOI18N
    fondo2.setText("jLabel6");
    background.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 650, 320));

    fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a.gif"))); // NOI18N
    fondo3.setText("jLabel6");
    background.add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 600, 80));

    fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a.gif"))); // NOI18N
    fondo4.setText("jLabel6");
    background.add(fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 590, 70));

    fondo0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a.gif"))); // NOI18N
    fondo0.setText("jLabel6");
    background.add(fondo0, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 580, 70));

    fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a.gif"))); // NOI18N
    fondo1.setText("jLabel6");
    background.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 20, 580, 80));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hammingBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hammingBMouseClicked
        // TODO add your handling code here:
        MainHamm Hamm = new MainHamm();
        Hamm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hammingBMouseClicked

    private void hammingBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hammingBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hammingBActionPerformed

    private void huffmanBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huffmanBMouseClicked
        // TODO add your handling code here:
        MainHuff Huff = new MainHuff();
        Huff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_huffmanBMouseClicked

    private void huffmanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huffmanBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_huffmanBActionPerformed

    private void exitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBActionPerformed

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
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton exitB;
    private javax.swing.JLabel extension1;
    private javax.swing.JLabel extension2;
    private javax.swing.JLabel fondo0;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel fondo3;
    private javax.swing.JLabel fondo4;
    private javax.swing.JButton hammingB;
    private javax.swing.JButton huffmanB;
    private javax.swing.JLabel imageL;
    private javax.swing.JLabel imageL2;
    private javax.swing.JLabel imageL3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
