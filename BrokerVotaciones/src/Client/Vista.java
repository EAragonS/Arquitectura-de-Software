ackage Client;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author ellysxd
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelOp1 = new javax.swing.JLabel();
        btnOp1 = new javax.swing.JButton();
        labelOp2 = new javax.swing.JLabel();
        labelOp3 = new javax.swing.JLabel();
        btnOp2 = new javax.swing.JButton();
        btnOp3 = new javax.swing.JButton();
        resultados1 = new javax.swing.JLabel();
        resultados2 = new javax.swing.JLabel();
        resultados3 = new javax.swing.JLabel();
        panelBarras = new javax.swing.JPanel();
        panelPastel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Votaciones"));
        jPanel1.setMaximumSize(new java.awt.Dimension(584, 364));
        jPanel1.setMinimumSize(new java.awt.Dimension(584, 364));

        labelOp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOp1.setText("jLabel1");

        btnOp1.setText("Votar");

        labelOp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOp2.setText("jLabel2");
        labelOp2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelOp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOp3.setText("jLabel3");

        btnOp2.setText("Votar");
        btnOp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp2ActionPerformed(evt);
            }
        });

        btnOp3.setText("Votar");

        resultados1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultados1.setText("null");

        resultados2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultados2.setText("null");

        resultados3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultados3.setText("null");

        panelBarras.setPreferredSize(new java.awt.Dimension(240, 180));

        javax.swing.GroupLayout panelBarrasLayout = new javax.swing.GroupLayout(panelBarras);
        panelBarras.setLayout(panelBarrasLayout);
        panelBarrasLayout.setHorizontalGroup(
            panelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelBarrasLayout.setVerticalGroup(
            panelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        panelPastel.setPreferredSize(new java.awt.Dimension(240, 180));

        javax.swing.GroupLayout panelPastelLayout = new javax.swing.GroupLayout(panelPastel);
        panelPastel.setLayout(panelPastelLayout);
        panelPastelLayout.setHorizontalGroup(
            panelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelPastelLayout.setVerticalGroup(
            panelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(panelPastel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelOp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultados1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(resultados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(146, 146, 146)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnOp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resultados3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultados2)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resultados1)
                                .addGap(18, 18, 18)
                                .addComponent(btnOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(resultados3)
                                .addGap(18, 18, 18)
                                .addComponent(btnOp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPastel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void btnOp2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    public JButton getBtnOp1() {
        return btnOp1;
    }

    public void setBtnOp1(JButton btnOp1) {
        this.btnOp1 = btnOp1;
    }

    public JButton getBtnOp2() {
        return btnOp2;
    }

    public void setBtnOp2(JButton btnOp2) {
        this.btnOp2 = btnOp2;
    }

    public JButton getBtnOp3() {
        return btnOp3;
    }

    public void setBtnOp3(JButton btnOp3) {
        this.btnOp3 = btnOp3;
    }

    public JLabel getResultados1() {
        return resultados1;
    }

    public void setResultados1(JLabel resultados1) {
        this.resultados1 = resultados1;
    }

    public JLabel getResultados2() {
        return resultados2;
    }

    public void setResultados2(JLabel resultados2) {
        this.resultados2 = resultados2;
    }

    public JLabel getResultados3() {
        return resultados3;
    }

    public void setResultados3(JLabel resultados3) {
        this.resultados3 = resultados3;
    }

    public JLabel getLabelOp1() {
        return labelOp1;
    }

    public void setLabelOp1(JLabel labelOp1) {
        this.labelOp1 = labelOp1;
    }

    public JLabel getLabelOp2() {
        return labelOp2;
    }

    public void setLabelOp2(JLabel labelOp2) {
        this.labelOp2 = labelOp2;
    }

    public JLabel getLabelOp3() {
        return labelOp3;
    }

    public void setLabelOp3(JLabel labelOp3) {
        this.labelOp3 = labelOp3;
    }

    public JPanel getPanelBarras() {
        return panelBarras;
    }

    public void setPanelBarras(JPanel panelBarras) {
        this.panelBarras = panelBarras;
    }

    public JPanel getPanelPastel() {
        return panelPastel;
    }

    public void setPanelPastel(JPanel panelPastel) {
        this.panelPastel = panelPastel;
    }

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnOp1;
    private javax.swing.JButton btnOp2;
    private javax.swing.JButton btnOp3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelOp1;
    private javax.swing.JLabel labelOp2;
    private javax.swing.JLabel labelOp3;
    private javax.swing.JPanel panelBarras;
    private javax.swing.JPanel panelPastel;
    private javax.swing.JLabel resultados1;
    private javax.swing.JLabel resultados2;
    private javax.swing.JLabel resultados3;
    // End of variables declaration                   
}
