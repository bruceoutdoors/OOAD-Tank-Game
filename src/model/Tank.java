/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Tile.Direction;

/**
 *
 * @author bruceoutdoors
 */
public class Tank {

    private Board m_board;
    private Tile m_tile;
    private Direction m_direction = Direction.TOP;
    private Boolean m_isAlive = true;

    public Tank(Tile tile, Board board) {
        m_board = board;
        m_tile = tile;
        m_tile.setTank(this);
        
        updatePlayerMoves();
    }

    public Boolean move(Direction d) {
        Tile target = m_tile.getNeighbor(d);
        if (target != null) {
            if (target.getTank() != null) {
                return false;
            }

            m_direction = d;
            m_tile.setTank(null);
            target.setTank(this);
            m_tile = target;
            updatePlayerMoves();
            return true;
        }

        return false;
    }

    public Boolean attack(Direction d) {
        Tile target = m_tile.getNeighbor(d);
        if (target != null) { 
            m_direction = d;
            target.setBlasted(true);
            Tank t = target.getTank();
            if (t != null) {
                t.setAlive(false);
            }
            
            updatePlayerMoves();
            return true;
        }

        return false;
    }

    public Direction getDirection() {
        return m_direction;
    }

    public void setDirection(Direction d) {
        m_direction = d;
    }

    public Tile getTile() {
        return m_tile;
    }

    public void setTile(Tile t) {
        m_tile = t;
        t.setTank(this);
    }

    public Boolean isAlive() {
        return m_isAlive;
    }

    public void setAlive(Boolean b) {
        m_isAlive = b;
    }

    public void updatePlayerMoves() {
        m_board.clearPlayerMoves();
        
        for (Direction d : Direction.values()) {
            if (d == Direction.NONE) continue;
            
            Tile topTile = m_tile.getNeighbor(d);
            if (topTile != null) {
                ArrayList<ITankCommand> commands = new ArrayList<>();
                commands.add(new AttackCommand(this, d));
                commands.add(new MoveCommand(this, d));
                topTile.setPlayerCommands(commands);
            }
        }
    }

}
