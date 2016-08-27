/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Tile.Direction;

/**
 *
 * @author bruceoutdoors
 */
public class Tank {
    private Board m_board;
    private Tile m_tile;
    
    public Tank(Tile tile, Board board) 
    {
        m_board = board;
        m_tile = tile;
        m_tile.setTank(this);
    }
    
    public Boolean move(Direction d) {
        Tile target = m_tile.getNeighbor(d);
        if (target != null) {
            m_tile.setTank(null);
            target.setTank(this);
            m_tile = target;
            
            return true;
        }
        
        return false;
    }
    
    public Boolean attack(Direction d) {
        Tile target = m_tile.getNeighbor(d);
        if (target != null) {
            target.setBlasted(true);
            
            return true;
        }
        
        return false;
    }
}
