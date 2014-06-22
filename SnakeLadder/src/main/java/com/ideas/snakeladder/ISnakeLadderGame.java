package com.ideas.snakeladder;

import com.ideas.snakeladder.vo.Player;

/**
 * 
 * @author Bharatesh s h
 * This class sets up board, initializes two players and starts the game.
 * Dice value is expected from client class or user.
 * 
 */

public interface ISnakeLadderGame {

	public abstract void startSnakeLadderGame();
	public abstract int readInput();
	public abstract int play(Player player);
}