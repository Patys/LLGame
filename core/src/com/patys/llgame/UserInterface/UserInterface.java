package com.patys.llgame.UserInterface;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class UserInterface {
	private Table table;
	
	private LevelBar levelBar;
	private GameView gameView;
	private MainView mainView;
	private ShopView shopView;
	
	public UserInterface(Table table) {
		
		gameView = new GameView(this);
		levelBar = new LevelBar(gameView);
		mainView = new MainView(this);
		shopView = new ShopView(this);
		
		this.table = table;
		this.table.add(levelBar.getTable());
		this.table.row();
		this.table.add(mainView).expandX();
	}
	
	public void goToMainView() {
		table.clearChildren();
		table.add(levelBar.getTable());
		table.row();
		table.add(mainView).expandX();
	}
	
	public void goToGame() {
		table.clearChildren();
		table.add(levelBar.getTable());
		table.row();
		table.add(gameView.getTable());
	}
	
	public void goToShop() {
		table.clearChildren();
		table.add(levelBar.getTable());
		table.row();
		table.add(shopView.getTable());
	}
}
