package game.graphicalInterface;

import game.logic.Battle;
import game.logic.Hero;
import game.logic.Item;
import game.logic.SaveClass;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {
    private static Hero hero;
    private ArrayList<Item> weaponsLibrary;
    private static ArrayList<Hero> heroesLibrary;
    private static DefaultListModel modelHeros;
    private static DefaultListModel modelWeapons;
    private Thread thrEnergy;
    private Thread thrHealth;
    private int nHeroes;  //koi oponent sme izbrali
    private int nWeapons; //koe oryjie sme izbrali

    /**
     * Sets Current game hero for this session
     *
     * @param h becomes Current game hero
     */
    public static void setHero(Hero h) {
        MainForm.hero = new Hero(h);
    }

    /**
     * Method creates threads for: increasing of health of Current game hero
     * increasing of energy of Current game hero
     */
    private void healthAndEnergyThreads() {
        thrHealth = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(8300L);
                        if (hero.getHealth() < 100) {
                            hero.setHealth(hero.getHealth() + 1);
                            lblHealth.setText(hero.getHealth() + "");
                        }
                    } catch (InterruptedException e) {
                        return;
                    }

                }
            }
        });
        thrEnergy = new Thread(new Runnable() {

            @Override
            @SuppressWarnings({"SleepWhileInLoop", "SleepWhileInLoop"})
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5800L);
                        if (hero.getEnergy() < hero.getMaxEnergy()) {
                            hero.setEnergy(hero.getEnergy() + 1);
                            lblEnergy.setText(hero.getEnergy() + "");
                        }
                    } catch (InterruptedException e) {
                        return;
                    }

                }
            }
        });
        thrHealth.start();
        thrEnergy.start();
    }

    /**
     * Generates weapons for the weapons section (tab) of the game
     */
    private void makeWaepons() {
        int i;
        modelWeapons.removeAllElements();
        weaponsLibrary = new ArrayList<Item>();
        weaponsLibrary.add(new Item("Spider", 5, 12));
        weaponsLibrary.add(new Item("Mukakana", 7, 7));
        weaponsLibrary.add(new Item("Casa", 14, 6));
        weaponsLibrary.add(new Item("Pinokio", 3, 9));
        weaponsLibrary.add(new Item("KoalaMan", 13, 8));
        weaponsLibrary.add(new Item("ST", 21, 21));
        weaponsLibrary.add(new Item("Adriana", 2, 15));
        weaponsLibrary.add(new Item("Motika", 4, 12));
        weaponsLibrary.add(new Item("Prava Lopata", 20, 20));
        for (i = 0; i < weaponsLibrary.size(); i++) {
            modelWeapons.addElement(weaponsLibrary.get(i).toString());
        }
    }

    /**
     * Sets components of Current game hero to the propriate labels in MyHero
     * tab
     */
    private void viewStats() {
        lblName.setText(hero.getName());
        lblExperience.setText(hero.getExperience() + "");
        lblEnergy.setText(hero.getEnergy() + "");
        lblHealth.setText(hero.getHealth() + "");
        lblMaxEnergy.setText(hero.getMaxEnergy() + "");
        lblStamina.setText(hero.getStamina() + "");
        lblHead.setText(hero.getHead().getIname());
        lblLeft.setText(hero.getLeft().getIname());
        lblRight.setText(hero.getRight().getIname());
    }

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        modelHeros = new DefaultListModel();
        listOpponents.setModel(modelHeros);
        modelWeapons = new DefaultListModel();
        listWeapons.setModel(modelWeapons);
        makeWaepons();
        healthAndEnergyThreads();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedMainFormPanel = new javax.swing.JTabbedPane();
        tabBattlefield = new javax.swing.JPanel();
        lblChoose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOpponents = new javax.swing.JList();
        btnViewOpponent = new javax.swing.JButton();
        btnFight = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        tabWeapons = new javax.swing.JPanel();
        lblWHead = new javax.swing.JLabel();
        lblHead = new javax.swing.JLabel();
        lblWLeft = new javax.swing.JLabel();
        lblLeft = new javax.swing.JLabel();
        lblWRight = new javax.swing.JLabel();
        lblRight = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listWeapons = new javax.swing.JList();
        btnHead = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        tabMyHero = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblHealth = new javax.swing.JLabel();
        lblStamina = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblExperience = new javax.swing.JLabel();
        lblEnergy = new javax.swing.JLabel();
        lblMaxEnergy = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnSearchFood = new javax.swing.JButton();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Epic Knight in Toskolandia");
        setResizable(false);

        tabbedMainFormPanel.setBackground(new java.awt.Color(153, 153, 153));
        tabbedMainFormPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedMainFormPanelMouseClicked(evt);
            }
        });

        tabBattlefield.setBackground(new java.awt.Color(51, 51, 0));
        tabBattlefield.setLayout(null);

        lblChoose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChoose.setForeground(new java.awt.Color(153, 153, 0));
        lblChoose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChoose.setText("Choose opponent:");
        tabBattlefield.add(lblChoose);
        lblChoose.setBounds(30, 90, 120, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Result");
        tabBattlefield.add(jLabel2);
        jLabel2.setBounds(40, 170, 130, 50);

        listOpponents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listOpponents.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Todor", "Kris", "Gosho", "Irinei" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listOpponents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOpponents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOpponentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listOpponents);

        tabBattlefield.add(jScrollPane1);
        jScrollPane1.setBounds(190, 50, 330, 180);

        btnViewOpponent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnViewOpponent.setText("View Opponent");
        btnViewOpponent.setEnabled(false);
        btnViewOpponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOpponentActionPerformed(evt);
            }
        });
        tabBattlefield.add(btnViewOpponent);
        btnViewOpponent.setBounds(370, 260, 130, 23);

        btnFight.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFight.setText("Fight");
        btnFight.setEnabled(false);
        btnFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFightActionPerformed(evt);
            }
        });
        tabBattlefield.add(btnFight);
        btnFight.setBounds(40, 260, 120, 23);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh.setText("Refresh Opponents");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        tabBattlefield.add(btnRefresh);
        btnRefresh.setBounds(200, 260, 140, 23);

        tabbedMainFormPanel.addTab("Battlefield", tabBattlefield);

        tabWeapons.setBackground(new java.awt.Color(51, 51, 0));
        //tabWeapons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        //tabWeapons.setLayout(new java.awt.BorderLayout());
        tabWeapons.setLayout(null);

        lblWHead.setBackground(new java.awt.Color(160, 51, 0));
        lblWHead.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWHead.setForeground(new java.awt.Color(255, 255, 0));
        lblWHead.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWHead.setText("Head");
        lblWHead.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblWHead.setOpaque(true);
        //tabWeapons.add(lblWHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 30));
        tabWeapons.add(lblWHead);
        lblWHead.setBounds(30, 40, 130, 30);
        
        lblHead.setBackground(new java.awt.Color(255, 255, 0));
        lblHead.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblHead.setForeground(new java.awt.Color(0, 0, 102));
        lblHead.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHead.setText("Ryjdqsala kaska");
        lblHead.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHead.setOpaque(true);
        //tabWeapons.add(lblHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 30));
        tabWeapons.add(lblHead);
        lblHead.setBounds(30, 80, 130, 30);

        lblWLeft.setBackground(new java.awt.Color(160, 51, 0));
        lblWLeft.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWLeft.setForeground(new java.awt.Color(255, 255, 0));
        lblWLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWLeft.setText("Left Hand");
        lblWLeft.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblWLeft.setOpaque(true);
        //tabWeapons.add(lblWLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));
        tabWeapons.add(lblWLeft);
        lblWLeft.setBounds(30, 140, 130, 30);

        lblLeft.setBackground(new java.awt.Color(255, 255, 0));
        lblLeft.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeft.setText("Boza");
        lblLeft.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblLeft.setOpaque(true);
        //tabWeapons.add(lblLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));
        tabWeapons.add(lblLeft);
        lblLeft.setBounds(30, 180, 130, 30);

        lblWRight.setBackground(new java.awt.Color(160, 51, 0));
        lblWRight.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWRight.setForeground(new java.awt.Color(255, 255, 0));
        lblWRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWRight.setText("Right Hand");
        lblWRight.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblWRight.setOpaque(true);
        //tabWeapons.add(lblWRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, 30));
        tabWeapons.add(lblWRight);
        lblWRight.setBounds(30, 240, 130, 30);

        lblRight.setBackground(new java.awt.Color(255, 255, 0));
        lblRight.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRight.setText("Banichka");
        lblRight.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblRight.setOpaque(true);
        //tabWeapons.add(lblRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 30));
        tabWeapons.add(lblRight);
        lblRight.setBounds(30, 280, 130, 30);

        listWeapons.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listWeapons.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Termometyr", "Piper", "Delfin", "Noktorezachka", "Kifla", "Govejdo zadusheno" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listWeapons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listWeapons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWeaponsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listWeapons);

        //tabWeapons.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 290, 200));
        tabWeapons.add(jScrollPane2);
        jScrollPane2.setBounds(210, 40, 290, 200);

        btnHead.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnHead.setText("Head");
        btnHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeadActionPerformed(evt);
            }
        });
        //tabWeapons.add(btnHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 80, 22));
        tabWeapons.add(btnHead);
        btnHead.setBounds(220, 280, 80, 22);

        btnLeft.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnLeft.setText("Left hand");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        //tabWeapons.add(btnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 80, 22));
        tabWeapons.add(btnLeft);
        btnLeft.setBounds(310, 280, 80, 22);

        btnRight.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnRight.setText("Right hand");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
        //tabWeapons.add(btnRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 90, 22));
        tabWeapons.add(btnRight);
        btnRight.setBounds(400, 280, 80, 22);

        tabbedMainFormPanel.addTab("Weapons", tabWeapons);

        tabMyHero.setBackground(new java.awt.Color(51, 51, 0));
        //tabMyHero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        //tabMyHero.setLayout(new java.awt.BorderLayout());
        tabMyHero.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(160, 51, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Name:");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, 30));
        tabMyHero.add(jLabel9);
        jLabel9.setBounds(30, 60, 90, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(160, 51, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Health:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 30));
        tabMyHero.add(jLabel10);
        jLabel10.setBounds(30, 150, 90, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(160, 51, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Stamina");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, 30));
        tabMyHero.add(jLabel11);
        jLabel11.setBounds(30, 240, 90, 30);

        lblName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(153, 153, 0));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 90, 30));
        tabMyHero.add(lblName);
        lblName.setBounds(150, 60, 90, 30);

        lblHealth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblHealth.setForeground(new java.awt.Color(153, 153, 0));
        lblHealth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHealth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblHealth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 90, 30));
        tabMyHero.add(lblHealth);
        lblHealth.setBounds(150, 150, 90, 30);

        lblStamina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStamina.setForeground(new java.awt.Color(153, 153, 0));
        lblStamina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStamina.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblStamina, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 90, 30));
        tabMyHero.add(lblStamina);
        lblStamina.setBounds(150, 240, 90, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(160, 51, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Experience");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 90, 30));
        tabMyHero.add(jLabel15);
        jLabel15.setBounds(280, 60, 90, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(160, 51, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Energy");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 90, 30));
        tabMyHero.add(jLabel16);
        jLabel16.setBounds(280, 150, 90, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(160, 51, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Max Energy");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 90, 30));
        tabMyHero.add(jLabel17);
        jLabel17.setBounds(280, 240, 90, 30);

        lblExperience.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblExperience.setForeground(new java.awt.Color(153, 153, 0));
        lblExperience.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExperience.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 90, 30));
        tabMyHero.add(lblExperience);
        lblExperience.setBounds(400, 60, 90, 30);

        lblEnergy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEnergy.setForeground(new java.awt.Color(153, 153, 0));
        lblEnergy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnergy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblEnergy, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 90, 30));
        tabMyHero.add(lblEnergy);
        lblEnergy.setBounds(400, 150, 90, 30);

        lblMaxEnergy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMaxEnergy.setForeground(new java.awt.Color(153, 153, 0));
        lblMaxEnergy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaxEnergy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //tabMyHero.add(lblMaxEnergy, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 90, 30));
        tabMyHero.add(lblMaxEnergy);
        lblMaxEnergy.setBounds(400, 240, 90, 30);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        //tabMyHero.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 90, -1));
        tabMyHero.add(btnSave);
        btnSave.setBounds(280, 300, 120, 20);

        btnSearchFood.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearchFood.setText("Search Food");
        btnSearchFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFoodActionPerformed(evt);
            }
        });
        //tabMyHero.add(btnSearchFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));
        tabMyHero.add(btnSearchFood);
        btnSearchFood.setBounds(150, 300, 120, 20);

        lblLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mim\\Desktop\\MimiGraphicalInterface\\logout.png")); // NOI18N
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        //tabMyHero.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 60, 50));
        tabMyHero.add(lblLogout);
        lblLogout.setBounds(500, 20, 60, 50);

        tabbedMainFormPanel.addTab("My Hero", tabMyHero);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedMainFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedMainFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabbedMainFormPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedMainFormPanelMouseClicked
        viewStats();
        modelHeros.removeAllElements();
        makeOpponents();
        btnFight.setEnabled(false);
        btnViewOpponent.setEnabled(false);
        btnHead.setEnabled(false);
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
    }//GEN-LAST:event_tabbedMainFormPanelMouseClicked

    /**
     * Saves Current game hero
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        SaveClass.saveHero(hero);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewOpponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOpponentActionPerformed

        JOptionPane.showMessageDialog(this, heroesLibrary.get(nHeroes).toString());
    }//GEN-LAST:event_btnViewOpponentActionPerformed

    /**
     * Generates random int to add to Current game hero health. If it is
     * negative, you consider yourself poisoned.
     */
    private void btnSearchFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFoodActionPerformed
        if (hero.getHealth() == 100) {
            return;
        }
        Random rnd = new Random();
        int berry = rnd.nextInt(25) - 5;
        if (berry < 0) {
            JOptionPane.showMessageDialog(this, "You poisened yourself! Miserable You!");
        }
        hero.setHealth(hero.getHealth() + berry);
        hero.setEnergy(hero.getEnergy() - 3);
        lblHealth.setText(hero.getHealth() + "");
        lblEnergy.setText(hero.getEnergy() + "");

    }//GEN-LAST:event_btnSearchFoodActionPerformed

    private void listOpponentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOpponentsMouseClicked
        btnViewOpponent.setEnabled(true);
        btnFight.setEnabled(true);
        nHeroes = listOpponents.locationToIndex(evt.getPoint());
    }//GEN-LAST:event_listOpponentsMouseClicked

    /**
     * This method performes a battle between Current game hero and choosen
     * opponent.
     */
    private void btnFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFightActionPerformed
        Battle battle = new Battle(hero, heroesLibrary.get(nHeroes));
        Hero battleOne = battle.fight();
        if (!(battleOne.getExperience() == hero.getExperience())) {
            hero = new Hero(battleOne);
            JOptionPane.showMessageDialog(this, "You win this time!");
        } else {
            hero = new Hero(battleOne);
            JOptionPane.showMessageDialog(this, "He won!");
        }
        battleOne = null;
    }//GEN-LAST:event_btnFightActionPerformed

    /**
     * Refresh/generate new set of opponents by makeOpponents(); 
     */
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        modelHeros.removeAllElements();
        btnFight.setEnabled(false);
        btnViewOpponent.setEnabled(false);
        makeOpponents();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void listWeaponsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWeaponsMouseClicked
    	btnHead.setEnabled(true);
        btnLeft.setEnabled(true);
        btnRight.setEnabled(true);
    	nWeapons = listWeapons.locationToIndex(evt.getPoint());
    }//GEN-LAST:event_listWeaponsMouseClicked

    /**
     * Sets chosen item as Current game hero head item
     */
    private void btnHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeadActionPerformed
        hero.setHead(weaponsLibrary.get(nWeapons));
        lblHead.setText(hero.getHead().getIname());
        btnHead.setEnabled(false);
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
    }//GEN-LAST:event_btnHeadActionPerformed

    /**
     * Sets chosen item as Current game hero Left Hand item
     */
    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        hero.setLeft(weaponsLibrary.get(nWeapons));
        lblLeft.setText(hero.getLeft().getIname());
        btnHead.setEnabled(false);
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);

    }//GEN-LAST:event_btnLeftActionPerformed

    /**
     * Sets chosen item as Current game hero right hand item
     */
    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        hero.setRight(weaponsLibrary.get(nWeapons));
        lblRight.setText(hero.getRight().getIname());
        btnHead.setEnabled(false);
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
    }//GEN-LAST:event_btnRightActionPerformed

    /**
     * LogOut. Redirect to HomeScreen Form
     */
    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        thrEnergy.interrupt();
        thrHealth.interrupt();
        dispose();
        new HomeScreen().setVisible(true);
        HomeScreen.generateList();

    }//GEN-LAST:event_lblLogoutMouseClicked

   /**
    * Generates 6 random opponents for opponents list
    */
    public static void makeOpponents() {
        Random rnd = new Random();
        heroesLibrary = new ArrayList<Hero>();

        int powerLeft = hero.getLeft().getPower();
        int powerRight = hero.getRight().getPower();
        int powerHead = hero.getHead().getPower();

        int weightLeft = hero.getLeft().getWeight();
        int weightRight = hero.getRight().getWeight();
        int weightHead = hero.getHead().getWeight();

        int stamina = hero.getStamina();

        int energy = hero.getEnergy();

        heroesLibrary.add(new Hero("Appius", 23.4, new Item("Optimus", rnd.nextInt(powerLeft) + 1, rnd.nextInt(weightLeft) + 1),
                new Item("AK47", rnd.nextInt(powerRight) + 1, rnd.nextInt(weightRight) + 1), new Item("Bradva", rnd.nextInt(powerHead) + 1, rnd.nextInt(weightHead) + 1),
                100, rnd.nextInt(stamina), rnd.nextInt(energy), 100));
        modelHeros.addElement("Appius");

        heroesLibrary.add(new Hero("Decimus", 12, new Item("Alfa", rnd.nextInt(powerLeft) + 1, rnd.nextInt(weightLeft) + 1),
                new Item("Beta", rnd.nextInt(powerRight) + 1, rnd.nextInt(weightRight) + 1), new Item("Gama", rnd.nextInt(powerHead) + 1, rnd.nextInt(weightHead) + 1),
                100, rnd.nextInt(stamina), rnd.nextInt(energy), 100));
        modelHeros.addElement("Decimus");

        heroesLibrary.add(new Hero("Gaius", 245, new Item("Tita", rnd.nextInt(powerLeft) + 1, rnd.nextInt(weightLeft) + 1),
                new Item("Epsilon", rnd.nextInt(powerRight) + 1, rnd.nextInt(weightRight) + 1), new Item("Mu", rnd.nextInt(powerHead) + 1, rnd.nextInt(weightHead) + 1),
                100, rnd.nextInt(stamina), rnd.nextInt(energy), 100));
        modelHeros.addElement("Gaius");

        heroesLibrary.add(new Hero("Mamercus", hero.getExperience(), new Item("Delta", rnd.nextInt(powerLeft + 10) + 1, rnd.nextInt(weightLeft + 10) + 1),
                new Item("MP4", rnd.nextInt(powerRight + 10) + 1, rnd.nextInt(weightRight + 10) + 1), new Item("Kirka", rnd.nextInt(powerHead + 10) + 1, rnd.nextInt(weightHead + 10) + 1),
                100, stamina, energy, hero.getMaxEnergy()));
        modelHeros.addElement("Mamercus");

        heroesLibrary.add(new Hero("Quintus", 43, new Item("Lopata", rnd.nextInt(10) + powerLeft, rnd.nextInt(10) + weightRight),
                new Item("Joker", rnd.nextInt(10) + powerRight, rnd.nextInt(10) + weightRight), new Item("Zvezdichka", rnd.nextInt(10) + powerHead, rnd.nextInt(10) + weightHead),
                80, rnd.nextInt(10) + stamina, rnd.nextInt(10) + energy, 100));
        modelHeros.addElement("Quintus");

        heroesLibrary.add(new Hero("Titus", 65.4, new Item("Piron", rnd.nextInt(20) + powerLeft, rnd.nextInt(20) + weightLeft),
                new Item("Chuk", rnd.nextInt(20) + powerRight, rnd.nextInt(20) + weightRight), new Item("Shpoka", rnd.nextInt(20) + powerHead, rnd.nextInt(20) + weightHead),
                90, stamina, energy, 100));
        modelHeros.addElement("Titus");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFight;
    private javax.swing.JButton btnHead;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchFood;
    private javax.swing.JButton btnViewOpponent;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChoose;
    private javax.swing.JLabel lblEnergy;
    private javax.swing.JLabel lblExperience;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblHealth;
    private javax.swing.JLabel lblLeft;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMaxEnergy;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRight;
    private javax.swing.JLabel lblStamina;
    private javax.swing.JLabel lblWHead;
    private javax.swing.JLabel lblWLeft;
    private javax.swing.JLabel lblWRight;
    private javax.swing.JList listOpponents;
    private javax.swing.JList listWeapons;
    private javax.swing.JPanel tabBattlefield;
    private javax.swing.JPanel tabMyHero;
    private javax.swing.JPanel tabWeapons;
    private javax.swing.JTabbedPane tabbedMainFormPanel;
    // End of variables declaration//GEN-END:variables
}
