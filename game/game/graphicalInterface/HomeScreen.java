package game.graphicalInterface;

import game.logic.Hero;
import game.logic.Item;
import game.logic.SaveClass;
import java.io.File;
import javax.swing.DefaultListModel;

public class HomeScreen extends javax.swing.JFrame {

    private static DefaultListModel model;
    private String heroName;

    /**
     * Creates new form HomeScreen
     */
    public HomeScreen() {
        initComponents();
        model = new DefaultListModel();
        listHero.setModel(model);
    }
    
    /**
     * This method creates firstrun list of heroes for the game
     */
    private static void firstHeroes() {
        Hero h = new Hero("Kris", 4, new Item("uno", 3, 12), new Item("Duo", 12, 8), new Item("f", 12, 34),
                15, 65, 78, 234);
        Hero l = new Hero("Gosho", 5, new Item("Duo", 12, 12), new Item("Bla", 4, 9), new Item("f", 12, 34),
                15, 65, 78, 234);
        Hero m = new Hero("Toshko", 4.7, new Item("Bla", 10, 11), new Item("Item", 9, 7), new Item("f", 12, 34),
                15, 65, 78, 234);
        Hero n = new Hero("Mariana", 5.1, new Item("80426", 4, 7), new Item("80329", 5, 12), new Item("f", 12, 34),
                15, 65, 78, 234);
        SaveClass.saveHero(h);
        SaveClass.saveHero(l);
        SaveClass.saveHero(m);
        SaveClass.saveHero(n);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHero = new javax.swing.JList();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Choose hero from the list:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 0));
        jLabel2.setText("OR");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 100, 34, 15);

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCreate.setText("Create one");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate);
        btnCreate.setBounds(30, 150, 120, 23);

        listHero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listHero.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bai Tosho", "bratched mu", "ortaka mu", "badjanaka", "portierkata" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listHero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listHero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHeroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listHero);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(180, 20, 170, 120);

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOK.setText("OK");
        btnOK.setEnabled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);
        btnOK.setBounds(180, 150, 170, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Applyes chosen hero as Current game hero. Redirect to Main Form
     */
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        dispose();
        new MainForm().setVisible(true);
        Hero h = new Hero(heroName);
        SaveClass.reviveHero(h);
        MainForm.setHero(h);
        MainForm.makeOpponents();
    }//GEN-LAST:event_btnOKActionPerformed
    
    /**
     * When a hero from the list is clicked
     */
    private void listHeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listHeroMouseClicked
        int n = listHero.locationToIndex(evt.getPoint());
        heroName = model.getElementAt(n).toString();
        btnOK.setEnabled(true);
    }//GEN-LAST:event_listHeroMouseClicked
    
    /**
     * Redirect to CreateHero form
     */
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        dispose();
        new CreateHero().setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
     * Adds heroes from save folder to the model of heroes
     */
    private static void getSaveFiles() {
        String path = "./save";

        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(".TOSHKO") || files.endsWith(".toshko")) {
                    files = files.replace(".toshko", "");
                    model.addElement(files);
                }
            }
        }
    }
    
    
    /**
     * If not save folder found: creates save folder and calls firstHeroes()
     * calls getSaveFiles() for save folder
     */
    public static void generateList() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                boolean mkdir = new File("./save").mkdir();
                if (mkdir) {
                    firstHeroes();
                    System.out.println("New folder is created.");
                } else {
                    System.out.println("The folder already exists.");
                }
                getSaveFiles();

            }
        });
    }

    
    
    public static void main(String args[]) {    
        /*
         * Create and display the form
         */
        new HomeScreen().setVisible(true);
        generateList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listHero;
    // End of variables declaration//GEN-END:variables
}
