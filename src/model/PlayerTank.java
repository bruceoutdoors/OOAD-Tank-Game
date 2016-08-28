/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author bruceoutdoors
 */
public class PlayerTank extends Tank {
    
    public PlayerTank(Tile tile, Board board) {
        super(tile, board);
    }
    
    @Override
    public Boolean move(Tile.Direction d) {
        Boolean result = super.move(d);
        
        if (result) updatePlayerMoves();
        
        return result;
    } 
    
    @Override
    public Boolean attack(Tile.Direction d) {
        Boolean result = super.attack(d);
        
        if (result) updatePlayerMoves();
        
        return result;
    }
    
    public void updatePlayerMoves() {
        if (!m_board.isSimulationMode()) {
            return;
        }

        m_board.clearPlayerMoves();

        for (Tile.Direction d : Tile.Direction.values()) {
            if (d == Tile.Direction.NONE) {
                continue;
            }

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
