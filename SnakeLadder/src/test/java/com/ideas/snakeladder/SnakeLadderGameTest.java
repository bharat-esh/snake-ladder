package com.ideas.snakeladder;

import java.io.BufferedReader;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.ideas.snakeladder.vo.Player;
@RunWith(MockitoJUnitRunner.class)

public class SnakeLadderGameTest {


	Player playerOne;
	Player playerTwo;
	SnakeLadderGame ladderGame;
	@Before
	public void setUp() throws Exception {
		playerOne = new Player(0,"playerOne");
		playerTwo = new Player(0,"playerTwo");
		ladderGame = new SnakeLadderGame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStartSnakeLadderGame() {
		//fail("Not yet implemented");
	}
	@Test
	public void play_when_PositionIsLast() throws Exception{
		
		
		//SnakeLadderGame spy = PowerMockito.spy(new SnakeLadderGame());
		//BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
		//PowerMockito.when(bufferedReader.readLine()).thenReturn("0");
		
		//PowerMockito.doReturn(diceValue).when(spy, PowerMockito.method(SnakeLadderGame.class,"readInPut")).withNoArguments();
		//PowerMockito.when(spy,"readInput").thenReturn(diceValue);
		//PowerMockito.doReturn(true).when(spy, PowerMockito.method(SnakeLadderGame.class,"checkIfWon",int.class)).withArguments(lastPosition);
//		BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);
//		Mockito.when(bufferedReader.readLine()).thenReturn("120");
//		ladderGame.readInput();

//				
//		playerOne.setCurrentPosition(lastPosition);
		//ladderGame.play(playerOne);
		
		
		

		
	}
	
	@Test
	public void play_when_PositionIsAny(){
		
	}
	
	@Test
	public void play_when_PositionIsSnakeHead(){
		
	}

	@Test
	public void play_when_PositionIsLadderBottom(){
		
	}
}
