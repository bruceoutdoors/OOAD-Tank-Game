
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import model.Board;
import model.ITankCommand;
import model.PlayerTank;
import model.TankCommandStack;
import model.Tile;
import view.CommandStackView;
import view.TankCommandPopupMenu;
import view.TileView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bruceoutdoors
 */
public class TankGame extends javax.swing.JFrame implements Observer {

    private int ROW = 3;
    private int COL = 3;
    private int MAX_COMMANDS = 5;
    private Board m_board;
    private Tile[][] m_tilesArr;
    private TileView[][] m_boardButtons;
    private TankCommandPopupMenu m_popup;
    private TankCommandStack m_playerCommandStack;
    private TankCommandStack m_enemyCommandStack;
    private CommandStackView m_playerCommandView;
    private CommandStackView m_enemyCommandView;

    /**
     * Creates new form TankGame
     */
    public TankGame() throws IOException {

        initComponents();
        m_board = new Board(ROW, COL);
        m_tilesArr = m_board.getBoardArr();
        m_boardButtons = new TileView[ROW][COL];
        board.setLayout(new GridLayout(ROW, COL));
        setResizable(false);
        for (Integer r = 0; r < ROW; r++) {
            for (Integer c = 0; c < COL; c++) {
                TileView jb = new TileView(this, m_tilesArr[r][c]);
                m_boardButtons[r][c] = jb;
                board.add(jb);
            }
        }
//        m_board.getPlayerTank().attack(Tile.Direction.TOP);

        m_playerCommandStack = new TankCommandStack(MAX_COMMANDS);
        m_enemyCommandStack = new TankCommandStack(MAX_COMMANDS);
        m_enemyCommandView = new CommandStackView(enemyCommandDisplay, m_enemyCommandStack);
        m_playerCommandView = new CommandStackView(playerCommandDisplay, m_playerCommandStack);

        redrawBoard();
    }

    public void redrawBoard() {
        Integer movesRemain = MAX_COMMANDS - m_playerCommandStack.currentSize();
        movesRemainLbl.setText(movesRemain.toString());
        if (movesRemain == 0) {
            movesRemainLbl.setForeground(Color.RED);
        } else {
            movesRemainLbl.setForeground(new Color(0, 153, 0));
        }
        for (Integer r = 0; r < ROW; r++) {
            for (Integer c = 0; c < COL; c++) {
                int w = m_boardButtons[r][c].getWidth();
                m_boardButtons[r][c].updateTile();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerCommandDisplay = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        enemyCommandDisplay = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        undoBtn = new javax.swing.JButton();
        executeBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        movesRemainLbl = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        howPlayMenuItem = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OOAD Robot Wars");

        board.setBackground(new java.awt.Color(153, 255, 255));
        board.setLayout(null);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        playerCommandDisplay.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1 - Move LEFT", "2 - Attack RIGHT", "3 - Move TOP", "4 - Move TOP", "..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        playerCommandDisplay.setEnabled(false);
        jScrollPane1.setViewportView(playerCommandDisplay);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Player Moves");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout(0, 5));

        enemyCommandDisplay.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Command #1", "Command #2", "Command #3", "Command #4", "Command #5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        enemyCommandDisplay.setEnabled(false);
        jScrollPane3.setViewportView(enemyCommandDisplay);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jLabel3.setText("Enemy Moves");
        jPanel2.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        undoBtn.setText("Undo");

        executeBtn.setText("Execute!");
        executeBtn.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Moves Remaining:");

        movesRemainLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        movesRemainLbl.setForeground(new java.awt.Color(0, 153, 0));
        movesRemainLbl.setText("15");

        jMenu3.setText("File");

        newGameMenuItem.setText("New Game...");
        newGameMenuItem.setActionCommand("");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(newGameMenuItem);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Help");

        howPlayMenuItem.setText("What to do ar?");
        jMenu4.add(howPlayMenuItem);

        aboutMenuItem.setText("About");
        jMenu4.add(aboutMenuItem);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movesRemainLbl)
                        .addGap(18, 18, 18)
                        .addComponent(executeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(undoBtn)))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(movesRemainLbl)
                    .addComponent(executeBtn)
                    .addComponent(undoBtn))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel board;
    private javax.swing.JList<String> enemyCommandDisplay;
    private javax.swing.JButton executeBtn;
    private javax.swing.JMenu howPlayMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel movesRemainLbl;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JList<String> playerCommandDisplay;
    private javax.swing.JButton undoBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ITankCommand) {
            onITankCommand((ITankCommand) arg);
        }
    }

    private void onITankCommand(ITankCommand itc) {
        if (m_board.isSimulationMode()) {
            if (!m_playerCommandStack.isFull()) {
                m_playerCommandStack.addAndExecute(itc);
                m_playerCommandView.updateView(false);

                if (m_playerCommandStack.isFull()) {
                    m_board.clearPlayerMoves();
                    executeBtn.setEnabled(true);
                }
            }

        }
        redrawBoard();
    }
}
