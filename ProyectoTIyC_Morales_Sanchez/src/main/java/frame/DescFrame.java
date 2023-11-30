
package frame;

import frame.CompactFrame;
import com.mycompany.huffmanm.Decodificar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DescFrame extends javax.swing.JFrame {
public static Decodificar descompactar = new Decodificar();
    /**
     * Creates new form DescFrame
     */
    public DescFrame() {
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

        background1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        compactarB = new javax.swing.JButton();
        fondo6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        fondo7 = new javax.swing.JLabel();
        estadisticas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ruta_antes = new javax.swing.JTextField();
        ruta_despues = new javax.swing.JTextField();
        jSantes = new javax.swing.JScrollPane();
        ANTES = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        DESPUES = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exitB1 = new javax.swing.JButton();
        aux0 = new javax.swing.JPanel();
        tituloHuffman = new javax.swing.JLabel();
        fondo5 = new javax.swing.JLabel();
        fondo8 = new javax.swing.JLabel();
        fondo9 = new javax.swing.JLabel();
        fondo10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background1.setBackground(new java.awt.Color(28, 40, 61));
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setBackground(new java.awt.Color(18, 26, 51));
        volver.setFont(new java.awt.Font("Roboto Slab", 0, 15)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("VOLVER");
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverMouseClicked(evt);
            }
        });
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        background1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jPanel2.setBackground(new java.awt.Color(18, 26, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(28, 40, 61));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        compactarB.setBackground(new java.awt.Color(18, 26, 51));
        compactarB.setFont(new java.awt.Font("Roboto Cn", 0, 22)); // NOI18N
        compactarB.setForeground(new java.awt.Color(255, 255, 255));
        compactarB.setText("DESCOMPACTAR");
        compactarB.setBorder(null);
        compactarB.setMaximumSize(new java.awt.Dimension(336, 36));
        compactarB.setMinimumSize(new java.awt.Dimension(336, 36));
        compactarB.setPreferredSize(new java.awt.Dimension(336, 36));
        compactarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compactarBMouseClicked(evt);
            }
        });
        compactarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compactarBActionPerformed(evt);
            }
        });

        fondo6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\zip2.png"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fondo6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(compactarB, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fondo6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(compactarB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 190, 210));

        jPanel6.setBackground(new java.awt.Color(28, 40, 61));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(null);

        fondo7.setBackground(new java.awt.Color(18, 26, 51));
        fondo7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\grafico.png"));
        jPanel6.add(fondo7);
        fondo7.setBounds(590, 10, 30, 30);

        estadisticas.setBackground(new java.awt.Color(18, 26, 51));
        estadisticas.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        estadisticas.setForeground(new java.awt.Color(43, 183, 246));
        estadisticas.setText("VER ESTADÍSTICAS");
        estadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 183, 246)));
        estadisticas.setEnabled(false);
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });
        jPanel6.add(estadisticas);
        estadisticas.setBounds(630, 10, 300, 30);

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jButton2.setText("Seleccionar archivo (.huf, .de, .dc)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jButton2.setBounds(10, 10, 350, 30);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 50));

        ruta_antes.setEditable(false);
        ruta_antes.setBackground(new java.awt.Color(0, 0, 0));
        ruta_antes.setForeground(new java.awt.Color(43, 183, 246));
        ruta_antes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruta_antesActionPerformed(evt);
            }
        });
        jPanel2.add(ruta_antes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 350, 30));

        ruta_despues.setEditable(false);
        ruta_despues.setBackground(new java.awt.Color(0, 0, 0));
        ruta_despues.setForeground(new java.awt.Color(43, 183, 246));
        jPanel2.add(ruta_despues, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 350, 30));

        ANTES.setEditable(false);
        ANTES.setBackground(new java.awt.Color(255, 255, 255));
        ANTES.setColumns(20);
        ANTES.setLineWrap(true);
        ANTES.setRows(5);
        ANTES.setWrapStyleWord(true);
        jSantes.setViewportView(ANTES);

        jPanel2.add(jSantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 350, 290));

        DESPUES.setEditable(false);
        DESPUES.setBackground(new java.awt.Color(255, 255, 255));
        DESPUES.setColumns(20);
        DESPUES.setLineWrap(true);
        DESPUES.setRows(5);
        DESPUES.setWrapStyleWord(true);
        jScrollPane1.setViewportView(DESPUES);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 350, 290));

        background1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1030, 410));

        jPanel3.setBackground(new java.awt.Color(18, 26, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        background1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 30));

        jPanel4.setBackground(new java.awt.Color(18, 26, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1030, 410));

        exitB1.setBackground(new java.awt.Color(18, 26, 51));
        exitB1.setFont(new java.awt.Font("Roboto Slab", 0, 16)); // NOI18N
        exitB1.setForeground(new java.awt.Color(255, 255, 255));
        exitB1.setText("SALIR");
        exitB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitB1ActionPerformed(evt);
            }
        });
        background1.add(exitB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 520, 90, 30));

        aux0.setBackground(new java.awt.Color(0, 0, 0));
        aux0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloHuffman.setFont(new java.awt.Font("Roboto", 1, 52)); // NOI18N
        tituloHuffman.setForeground(new java.awt.Color(218, 236, 255));
        tituloHuffman.setText("DESCOMPACTAR ARCHIVO");
        tituloHuffman.setToolTipText("");
        aux0.add(tituloHuffman, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 660, -1));

        background1.add(aux0, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 640, 40));

        fondo5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\a.gif"));
        fondo5.setText("jLabel6");
        background1.add(fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 500, 580, 80));

        fondo8.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\a.gif"));
        background1.add(fondo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 580, 80));

        fondo9.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\a.gif"));
        fondo9.setText("jLabel6");
        background1.add(fondo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 20, 580, 80));

        fondo10.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\images\\a.gif"));
        fondo10.setText("jLabel6");
        background1.add(fondo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 580, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseClicked
        // TODO add your handling code here:
        MainHuff m = new MainHuff();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_volverMouseClicked

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volverActionPerformed

    private void compactarBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compactarBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_compactarBMouseClicked

    private void compactarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compactarBActionPerformed
        // TODO add your handling code here:
           if(ruta_antes.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un archivo","Error", JOptionPane.ERROR_MESSAGE);

            }else{
            
            try {
                try {
                    descompactar.descompactar();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DescFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ruta_despues.setText(descompactar.getArchivoDecodificado());
                FileReader fr= new FileReader(descompactar.getArchivoDecodificado());
                BufferedReader br = new BufferedReader(fr);
                String texto="";
                String linea="";
                while(((linea=br.readLine())!=null)){
                    texto+=linea+"\n";
                }
                
                DESPUES.setText(texto);
                  estadisticas.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(CompactFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_compactarBActionPerformed

    private void estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "\n"
                    + "- Tamaño del archivo compactado: " + descompactar.tamanioCodificado() + " Bytes\n"
                    + "- Tamaño del archivo descompactado: " + descompactar.tamanioDecodificado() + " Bytes\n"
                    ,"ETADÍSTICAS OBTENIDAS", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_estadisticasActionPerformed

    private void ruta_antesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruta_antesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruta_antesActionPerformed

    private void exitB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitB1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitB1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        descompactar.setArchivoCodificado("");
        descompactar.setArchivoDecodificado("");
        descompactar.SelectArchivo();
        
        if(!descompactar.getArchivoCodificado().equals("")){
             ruta_antes.setText(descompactar.getArchivoCodificado()); //escribe la ruta del archivo
            try {
                
                FileReader fr= new FileReader(descompactar.getArchivoCodificado());
                BufferedReader br = new BufferedReader(fr);
                String texto="";
                String linea="";
                while(((linea=br.readLine())!=null)){
                    texto+=linea+"\n";
                }
           
                ANTES.setText(texto);
              
                
            } catch (IOException ex) {
                Logger.getLogger(CompactFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DescFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ANTES;
    private javax.swing.JTextArea DESPUES;
    private javax.swing.JPanel aux0;
    private javax.swing.JPanel background1;
    private javax.swing.JButton compactarB;
    private javax.swing.JButton estadisticas;
    private javax.swing.JButton exitB1;
    private javax.swing.JLabel fondo10;
    private javax.swing.JLabel fondo5;
    private javax.swing.JLabel fondo6;
    private javax.swing.JLabel fondo7;
    private javax.swing.JLabel fondo8;
    private javax.swing.JLabel fondo9;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jSantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ruta_antes;
    private javax.swing.JTextField ruta_despues;
    private javax.swing.JLabel tituloHuffman;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}