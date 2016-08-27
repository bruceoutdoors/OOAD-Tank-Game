/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;


/**
 *
 * @author bruceoutdoors
 */
public class Tile {

    private final int m_col;
    private final int m_row;
    public enum Direction {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }
    private Point m_position;
    private Tank m_tank = null;
    private Board m_board;
    private Boolean m_blasted = false;
    
    public Tile(Board b, int row, int col) {
        m_row = row;
        m_col = col;
        m_board = b;
    }
    
    public int getRow() {
        return m_row;
    }
    
    public int getCol() {
        return m_col;
    }
    
    public Tile getNeighbor(Direction dir) {
        return m_board.getNeighborTile(this, dir);
    }
    
    public void setTank(Tank tank) {
        m_tank = tank;
    }
    
    public Tank getTank() {
        return m_tank;
    }
    
    public void setBlasted(Boolean b) {
        m_blasted = b;
    }
    
    public Boolean isBlasted() {
        return m_blasted;
    }
}
