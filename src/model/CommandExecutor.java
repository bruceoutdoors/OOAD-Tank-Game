/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.command.TankCommandStack;
import model.command.ITankCommand;
import model.tank.Tank;
import model.board.Board;
import java.util.Iterator;

/**
 *
 * @author bruceoutdoors
 */
public class CommandExecutor {

    public enum State {
        NONE,
        STILLEXECUTING,
        PLAYERWIN,
        ENEMYWIN,
        DRAW
    }

    private int m_currentStep = 0;
    private TankCommandStack m_playerStack;
    private TankCommandStack m_enemyStack;
    private Iterator<ITankCommand> m_playerCommandIterator;
    private Iterator<ITankCommand> m_enemyCommandIterator;
    private Tank m_enemyTank;
    private Tank m_playerTank;
    private Board m_board;

    public CommandExecutor(Board b, TankCommandStack playerStack, TankCommandStack enemyStack) {
        m_playerStack = playerStack;
        m_enemyStack = enemyStack;
        m_enemyTank = b.getEnemyTank();
        m_playerTank = b.getPlayerTank();
        m_board = b;

        m_playerCommandIterator = m_playerStack.getIterator();
        m_enemyCommandIterator = m_enemyStack.getIterator();
    }

    public Boolean isFinished() {
        return !m_playerCommandIterator.hasNext();
    }

    public State step() {
        // begining. Do nothing.
        if (m_currentStep == 0) {
            m_currentStep++;
            return State.STILLEXECUTING;
        }
        
        if (m_playerCommandIterator.hasNext()) {
            // remove past attacks
            m_board.resetBlasts();

            ITankCommand playerCommand = m_playerCommandIterator.next();
            ITankCommand enemyCommand = m_enemyCommandIterator.next();
            playerCommand.execute();
            enemyCommand.execute();
            m_currentStep++;

            if (!m_playerTank.isAlive() && !m_enemyTank.isAlive()) {
                return State.DRAW;
            } else if (!m_playerTank.isAlive()) {
                return State.ENEMYWIN;
            } else if (!m_enemyTank.isAlive()) {
                return State.PLAYERWIN;
            }

            return State.STILLEXECUTING;
        } else {
            throw new RuntimeException("Nothing more to step. Hello??");
        }
    }

    public void restart() {
        m_board.resetBoard();
        m_currentStep = 0;

        m_playerCommandIterator = m_playerStack.getIterator();
        m_enemyCommandIterator = m_enemyStack.getIterator();
    }
    
    public int getCurrentStep() {
        return m_currentStep;
    }
}
