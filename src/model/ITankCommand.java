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
public interface ITankCommand {
    String getCommandName();
    void execute();
    void undo();
    Direction getDirection();
}
