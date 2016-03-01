package game.graphicalInterface;

import game.logic.Hero;

public class CreateHero extends javax.swing.JFrame {

    /**
     * Creates new form CreateHero
     */
    public CreateHero() {
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

        jPanel1 = new javax.swing.JPanel();
        lblCreateHeroName = new javax.swing.JLabel();
        txtCreateName = new javax.swing.JTextField();
        btnCreateHero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));
        jPanel1.setLayout(null);

        lblCreateHeroName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCreateHeroName.setForeground(new java.awt.Color(153, 153, 0));
        lblCreateHeroName.setText("Name:");
        jPanel1.add(lblCreateHeroName);
        lblCreateHeroName.setBounds(170, 40, 60, 15);

        txtCreateName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCreateName.setText("Todor");
        jPanel1.add(txtCreateName);
        txtCreateName.setBounds(50, 90, 290, 30);

        btnCreateHero.setText("DO IT");
        btnCreateHero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateHeroActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateHero);
        btnCreateHero.setBounds(160, 140, 70, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method creates hero with the specified name. Redirect to the
     * MainForm.
     */
    private void btnCreateHeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateHeroActionPerformed
        dispose();
        Hero h = new Hero(txtCreateName.getText());
        new MainForm().setVisible(true);
        MainForm.setHero(h);
        MainForm.makeOpponents();
    }//GEN-LAST:event_btnCreateHeroActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateHero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCreateHeroName;
    private javax.swing.JTextField txtCreateName;
    // End of variables declaration//GEN-END:variables
}