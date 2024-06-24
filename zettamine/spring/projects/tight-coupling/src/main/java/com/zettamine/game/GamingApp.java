package com.zettamine.game;

public class GamingApp {

	public static void main(String[] args) {
		//Mario game = new Mario();
		SuperContra game = new SuperContra();
		GameRunner gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
