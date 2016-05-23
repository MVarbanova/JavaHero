package game.graphicalInterface;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import game.logic.Hero;
import game.logic.Item;
import game.logic.SaveClass;

@SuppressWarnings({ "unchecked", "unqualified-field-access" })
public class HomeScreen extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultListModel<String> model;
	private String heroName;

	/**
	 * Creates new form HomeScreen
	 */
	public HomeScreen() {
		initComponents();
		listHero.setModel(new DefaultListModel<>());
	}

	/**
	 * This method creates first run list of heroes for the game
	 */
	private static void firstHeroes() {
		final Hero h = new Hero("Kris", 4, new Item("uno", 3, 12), new Item("Duo", 12, 8), new Item("f", 12, 34), 15,
				65, 78, 234);
		final Hero l = new Hero("Gosho", 5, new Item("Duo", 12, 12), new Item("Bla", 4, 9), new Item("f", 12, 34), 15,
				65, 78, 234);
		final Hero m = new Hero("Toshko", 4.7, new Item("Bla", 10, 11), new Item("Item", 9, 7), new Item("f", 12, 34),
				15, 65, 78, 234);
		final Hero n = new Hero("Mariana", 5.1, new Item("80426", 4, 7), new Item("80329", 5, 12),
				new Item("f", 12, 34), 15, 65, 78, 234);
		SaveClass.saveHero(h);
		SaveClass.saveHero(l);
		SaveClass.saveHero(m);
		SaveClass.saveHero(n);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		btnCreate = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		listHero = new JList<>();
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
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnCreateActionPerformed();
			}
		});
		jPanel1.add(btnCreate);
		btnCreate.setBounds(30, 150, 120, 23);

		listHero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		listHero.setModel(new javax.swing.AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 693106279431190491L;
			String[] strings = { "Bai Tosho", "bratched mu", "ortaka mu", "badjanaka", "portierkata" };

			@Override
			public int getSize() {
				return strings.length;
			}

			@Override
			public Object getElementAt(final int i) {
				return strings[i];
			}
		});
		listHero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		listHero.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(final java.awt.event.MouseEvent evt) {
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
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnOKActionPerformed();
			}
		});
		jPanel1.add(btnOK);
		btnOK.setBounds(180, 150, 170, 23);

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Applies chosen hero as Current game hero. Redirect to Main Form
	 */
	private void btnOKActionPerformed() {// GEN-FIRST:event_btnOKActionPerformed
		dispose();
		new MainForm().setVisible(true);
		final Hero h = new Hero(heroName);
		SaveClass.reviveHero(h);
		MainForm.setHero(h);
		MainForm.makeOpponents();
	}// GEN-LAST:event_btnOKActionPerformed

	/**
	 * When a hero from the list is clicked
	 */
	private void listHeroMouseClicked(final java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listHeroMouseClicked
		final int n = listHero.locationToIndex(evt.getPoint());
		heroName = model.getElementAt(n).toString();
		btnOK.setEnabled(true);
	}// GEN-LAST:event_listHeroMouseClicked

	/**
	 * Redirect to CreateHero form
	 */
	private void btnCreateActionPerformed() {// GEN-FIRST:event_btnCreateActionPerformed
		dispose();
		new CreateHero().setVisible(true);
	}// GEN-LAST:event_btnCreateActionPerformed

	/**
	 * Adds heroes from save folder to the model of heroes
	 */
	private static void getSaveFiles() {
		final String path = "./save";

		String files;
		final File folder = new File(path);
		final File[] listOfFiles = folder.listFiles();
		
		//todo check if listOfFiles null!

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
				final boolean mkdir = new File("./save").mkdir();
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

	public static void main(final String args[]) {
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
