/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;

/**
 *
 * @author bruceoutdoors
 */
public class TestBoard {

    public static void main(String[] args) throws IOException {
        Board b = new Board(4, 4);
       // for (int i =0; i < b.getRowCount())
        Tile t = b.getBoardArr()[3][3];
        Tile o = t.getNeighbor(Tile.Direction.RIGHT);
        Tank player = b.getPlayerTank();
//        Boolean success = player.move(Tile.Direction.LEFT);
        MoveCommand mc = new MoveCommand(player, Tile.Direction.LEFT);
        mc.execute();
        player.attack(Tile.Direction.TOP);
        mc.undo();
        System.out.println("hello");
        
        TankCommandFileIO io = new TankCommandFileIO(b.getEnemyTank());
        TankCommandStack s = io.read("SAVED_COMMANDS.txt");

        System.out.println(s);
        
        io.write(s, "WRITTEN_COMMANDS.txt");
    }

}
