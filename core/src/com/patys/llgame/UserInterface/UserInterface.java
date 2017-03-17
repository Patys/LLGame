package com.patys.llgame.UserInterface;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class UserInterface {
	private Table table;
	
	public UserInterface(Table table) {
		this.table = table;
		this.table.add(new LevelBar()).top().spaceBottom(20);
		this.table.row();
		this.table.add(new MainView()).expandX();
	}
}
