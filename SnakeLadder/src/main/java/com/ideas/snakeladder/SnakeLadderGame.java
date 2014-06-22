package com.ideas.snakeladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.ideas.snakeladder.vo.Ladder;
import com.ideas.snakeladder.vo.Player;
import com.ideas.snakeladder.vo.Snake;
/**
 * 
 * @author Bharatesh s h
 * This class sets up board, initialises two players and starts the game.
 * Dice value is expected from client class or user.
 * 
 */
public class SnakeLadderGame implements ISnakeLadderGame {

	private int boardSize;
	private Map<Integer, Snake> snakes;
	private Map<Integer, Ladder> ladders;
	private Player playerOne;
	private Player playerTwo;

	public SnakeLadderGame() {
		boardSize = SLConstants.BRD_HEIGHT * SLConstants.BRD_WIDTH;
		this.snakes = LoadSLBoard.awakeSnakes();
		this.ladders = LoadSLBoard.setUpLadders();

		initPlayers();
		System.out.println("*******Board is Ready**********");
	}

	private void initPlayers() {
		playerOne = new Player(0, "PlayerOne");
		playerTwo = new Player(0, "PlayerTwo");
	}

	private int checkIfBitten(int position) {

		if (snakes.containsKey(position)) {
			System.out.println("You are bitten by snake!!!");
			Snake snake = snakes.get(position);
			return snake.getTail();
		}
		return position;
	}

	private int checkIfLadder(int position) {
		if (ladders.containsKey(position)) {
			System.out.println("Lucky, You found a Ladder!!!");
			Ladder ladder = ladders.get(position);
			return ladder.getTop();
		}
		return position;
	}

	public boolean checkIfWon(int position) {
		if (position == boardSize) {
			return true;
		}
		return false;
	}

	public int readInput() {
		int diceValue = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			diceValue = Integer.parseInt(br.readLine());
			if(!validateInput(diceValue)){
				System.out
				.println("Invalid number, dice value must a integer, less than 7");
				diceValue = 0;
			}
			//diceValue += validateCurrentPosition(diceValue);
			if (diceValue == SLConstants.DICE_SIZE) {
				System.out.println("Lucky you, roll the dice again ");
				
				diceValue += readInput();
				
			} else {
				return diceValue;
			}
		} catch (NumberFormatException e) {
			System.out
					.println("Error!!! Invalid number, dice value must a integer ");
			diceValue = 0;
			// e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("Invalid number, dice value must a integer, less than 7");
			// e.printStackTrace();
			diceValue = 0;
		}
		return diceValue;
	}

	/**
	 * Validate invalid dice values.
	 * @param input
	 * @return
	 */
	private boolean validateInput(int input) {
		if (input > SLConstants.DICE_SIZE || input < 1) {
			return false;
		}
		return true;
	}

	/**
	 * To check if current position exceeds 120, if yes reset to old position.
	 * @param input
	 * @return
	 */
	private int validateCurrentPosition(int input) {
		System.out.println("*********nput ********* "+input);
		if (input > boardSize) {
			input=0;
		}
		return input;
	}
	

	public int play(Player player) {
		int diceValue = 0;
		int currentPosition = 0;
		int currentPositionTemp = -1;
		while (true) {
			System.out.println("Enter dice value for " + player.getName());
			diceValue = readInput();

			currentPosition = player.getCurrentPosition();
			currentPosition = currentPosition + diceValue;
			currentPositionTemp = validateCurrentPosition(currentPosition);
			
			if (currentPosition > 120 || currentPositionTemp==0) {
				System.out.println("Your position is " + currentPosition
						+ ", It should be 120 to be a winner");
				return 0;
			}
			currentPosition = checkIfBitten(currentPosition);
			currentPosition = checkIfLadder(currentPosition);
			player.setCurrentPosition(currentPosition);
			if (checkIfWon(currentPosition)) {
				System.out.println(player.getName() + " has won !!!");
				return 3;
			}
			
			System.out.println("Your new position "
					+ player.getCurrentPosition());
			return 0;
		}
	}

	public void startSnakeLadderGame() {
		while (true) {
			if (play(playerOne) == 3) {
				break;
			} else if (play(playerTwo) == 3) {
				break;
			}
		}
	}

	public static void main(String args[]) {
		new SnakeLadderGame().startSnakeLadderGame();
	}
}
