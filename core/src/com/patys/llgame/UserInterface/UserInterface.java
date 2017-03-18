package com.patys.llgame.UserInterface;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class UserInterface {
	private Table table;
	
	private LevelBar levelBar;
	private GameView gameView;
	private MainView mainView;
	
	public UserInterface(Table table) {
		
		gameView = new GameView();
		levelBar = new LevelBar(gameView);
		mainView = new MainView(this);
		
		this.table = table;
		this.table.add(levelBar.getTable());
		this.table.row();
		this.table.add(mainView).expandX();
	}
	
	public void startGame() {
		table.clearChildren();
		table.add(levelBar.getTable());
		table.row();
		table.add(gameView.getTable());
	}
}
