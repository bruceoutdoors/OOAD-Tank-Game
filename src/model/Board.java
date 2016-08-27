/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;
import model.Tile.Direction;

/**
 *
 * @author bruceoutdoors
 */
class Board {

    private final Tile[][] m_boardArr;
    private final int m_row;
    private final int m_col;
    private Tank m_playerTank;
    private Tank m_enemyTank;

    public Board(int row, int col) {
        m_boardArr = new Tile[row][col];
        m_row = row;
        m_col = col;

        for (int i = 0; i < m_row; i++) {
            for (int j = 0; j < m_col; j++) {
                m_boardArr[i][j] = new Tile(this, i, j);
            }
        }

        m_playerTank = new Tank(m_boardArr[m_row - 1][m_col - 1], this);
        m_enemyTank = new Tank(m_boardArr[0][0], this);
    }

    public Tile getNeighborTile(Tile t, Direction d) {
        int r = t.getRow();
        int c = t.getCol();

        try {
            switch (d) {
                case TOP:
                    return m_boardArr[r][c - 1];
                case BOTTOM:
                    return m_boardArr[r][c + 1];
                case LEFT:
                    return m_boardArr[r - 1][c];
                case RIGHT:
                    return m_boardArr[r + 1][c];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }

        return null;
    }

    public int getRowCount() {
        return m_row;
    }

    public int getColumnCount() {
        return m_col;
    }

    public Tile[][] getBoardArr() {
        return m_boardArr;
    }
    
    public Tank getPlayerTank() {
        return m_playerTank;
    }
    
    private void resetBlasts() {
        for (int i = 0; i < m_row; i++) {
            for (int j = 0; j < m_col; j++) {
                m_boardArr[i][j].setBlasted(false);
            }
        }
    }
}
