/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpii02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;

/**
 *
 * @author Gustavo
 */
public class JFMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public JFMain() {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jDesktopPane1 = new javax.swing.JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Image _backImg = null;

                try {
                    _backImg = ImageIO.read(new File("C:\\Users\\Gustavo\\Desktop\\EC5\\Java\\Projeto\\EC6\\Imgs\\logo_cranio-removebg-preview.png"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (_backImg != null) {
                    Dimension dimension = this.getSize();
                    int x = (int)(dimension.getWidth() - _backImg.getWidth(this)) / 2;
                    int y = (int)(dimension.getHeight() - _backImg.getHeight(this)) / 2;

                    grphcs.drawImage(_backImg, x, y, _backImg.getWidth(this), _backImg.getHeight(this), this);
                }
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        setName("frMain"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 770));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setForeground(new java.awt.Color(153, 153, 153));
        jDesktopPane1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jDesktopPane1.setName("mdiComponent"); // NOI18N

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1228, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuBar1.setName("cpMenuBar"); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu1.setName("mFile"); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem2.setText("Perfil");
        jMenuItem2.setName("imPerfil"); // NOI18N
        jMenu1.add(jMenuItem2);

        jMenuItem1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.setName("imLeave"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu2.setName("mInputs"); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem3.setText("Matéria");
        jMenuItem3.setName("miInMatter"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem4.setText("Dificuldade");
        jMenuItem4.setName("miInDifficulty"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem5.setText("Permissões");
        jMenuItem5.setName("miInPermissions"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem6.setText("Grupo de Acesso");
        jMenuItem6.setName("miInAccessGroup"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem7.setText("Questões");
        jMenuItem7.setName("miInQuestions"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Testes");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu3.setName("mTests"); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem8.setText("Histórico");
        jMenuItem8.setName("miHistory"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Cursos");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem9.setText("Cadastro");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem10.setText("Disponibilidades");
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Fóruns");
        jMenu4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu4.setName("mForuns"); // NOI18N
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Matérias",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPMatter matterFrame = new JPMatter();

        container.add(matterFrame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Dificuldades",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPDifficulty frame = new JPDifficulty();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Permissões",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPPermission frame = new JPPermission();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Histórico - Testes",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPTestsHistory frame = new JPTestsHistory();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Grupos de Acesso",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPAccessGroup frame = new JPAccessGroup();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Questões",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPQuestions frame = new JPQuestions();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();
        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        JInternalFrame internalFrame = new JInternalFrame("Cursos",
                true,
                true,
                true,
                true);

        Container container = internalFrame.getContentPane();
        JPCourse frame = new JPCourse();

        container.add(frame, BorderLayout.CENTER);
        internalFrame.pack();

        this.jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
