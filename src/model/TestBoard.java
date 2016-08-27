/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruceoutdoors
 */
public class TestBoard {

    public static void main(String[] args) {
        Board b = new Board(4, 4);
        Tile t = b.getBoardArr()[3][3];
        Tile o = t.getNeighbor(Tile.Direction.RIGHT);
        Tank player = b.getPlayerTank();
        Boolean success = player.move(Tile.Direction.LEFT);
        player.attack(Tile.Direction.TOP);
        
        System.out.println("hello");
    }

}
