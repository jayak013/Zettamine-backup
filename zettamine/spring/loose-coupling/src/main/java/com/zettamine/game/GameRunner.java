package com.zettamine.game;

public class GameRunner {
	private Game game;

	public GameRunner(Game game) {
		super();
		this.game = game;
	}
	public void run() {
		System.out.println("Running Game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();	
	}	

}
