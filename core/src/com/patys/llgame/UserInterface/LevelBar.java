package com.patys.llgame.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.patys.llgame.MetaGame;

public class LevelBar extends Observer {
	
	private DefaultSkin skin;
	private Table table;
	
	public LevelBar(Subject subject) {
		skin = new DefaultSkin();
		table = new Table();
		this.subject = subject;
		this.subject.attach(this);
		updateTable();
	}

	private void updateTable() {
		table.clearChildren();
		Label level = new Label("Poziom: " + Integer.toString(MetaGame.level), skin.getSkin());
		Label experience = new Label("Doœwiadczenie: " + Integer.toString(MetaGame.experience), skin.getSkin());
		Label points = new Label("Punkty: " + Integer.toString(MetaGame.points), skin.getSkin());
		
		int averge = (int) ((level.getWidth() + experience.getWidth())/2);
		int space = Gdx.graphics.getWidth() - averge*3;
		
		table.add(level).expandX().fill().align(Align.left);
		table.add().spaceRight(space);
		table.add(experience).expandX().fill().align(Align.right);
		table.row();
		table.add(points).expandX().fill().align(Align.right);
	}
	
	private void updateLevel() {
		if(MetaGame.experience > ((MetaGame.level + 1)*50)) {
			MetaGame.level += 1;
			MetaGame.experience = 0;
			NextLevelWindow nextLevelWindow = new NextLevelWindow();
			nextLevelWindow.getDialog().show(table.getStage());
		}
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	@Override
	public void update() {
		updateLevel();
		updateTable();
	}
}
