package com.ideas.snakeladder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ideas.snakeladder.vo.Ladder;
import com.ideas.snakeladder.vo.Snake;

public class LoadSLBoard {
	private static Map<Integer, Snake> snakes = null;
	private static Map<Integer, Ladder> ladders = null;

	private LoadSLBoard() {

	}

	protected static Map<Integer, Snake> awakeSnakes() {
		if (snakes == null) {

			System.out.println("Awakining snakes ");
			snakes = new ConcurrentHashMap<Integer, Snake>();
			Snake snake1 = new Snake(17, 7);
			Snake snake2 = new Snake(54, 34);
			Snake snake3 = new Snake(62, 19);
			Snake snake4 = new Snake(64, 60);
			Snake snake5 = new Snake(87, 24);
			Snake snake6 = new Snake(101, 68);
			Snake snake7 = new Snake(111, 78);

			snakes.put(17, snake1);
			snakes.put(54, snake2);
			snakes.put(62, snake3);
			snakes.put(64, snake4);
			snakes.put(87, snake5);
			snakes.put(101, snake6);
			snakes.put(111, snake7);

		} else {
			System.out.println("Snakes already awake ");
		}
		return snakes;
	}

	protected static Map<Integer, Ladder> setUpLadders() {

		if (ladders == null) {
			System.out.println("setting up ladders ");
			ladders = new ConcurrentHashMap<Integer, Ladder>();
			Ladder ladder1 = new Ladder(4, 14);
			Ladder ladder2 = new Ladder(9, 31);
			Ladder ladder3 = new Ladder(20, 38);
			Ladder ladder4 = new Ladder(28, 84);
			Ladder ladder5 = new Ladder(40, 59);
			Ladder ladder6 = new Ladder(51, 110);
			Ladder ladder7 = new Ladder(71, 115);

			ladders.put(4, ladder1);
			ladders.put(9, ladder2);
			ladders.put(20, ladder3);
			ladders.put(28, ladder4);
			ladders.put(40, ladder5);
			ladders.put(51, ladder6);
			ladders.put(71, ladder7);
		} else {
			System.out.println("ladders already set ");
		}
		return ladders;
	}
}
