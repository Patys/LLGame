package com.patys.llgame.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.patys.llgame.MetaGame;

public class LevelBar extends Table {
	
	private DefaultSkin skin;
	
	public LevelBar() {
		skin = new DefaultSkin();

		Label level = new Label("Poziom: " + Integer.toString(MetaGame.level), skin);
		Label experience = new Label("Doœwiadczenie: " + Integer.toString(MetaGame.experience), skin);
		Label points = new Label("Punkty: " + Integer.toString(MetaGame.points), skin);
		
		int averge = (int) ((level.getWidth() + experience.getWidth())/2);
		int space = Gdx.graphics.getWidth() - averge*3;
		
		this.add(level).expandX().fill().align(Align.left);
		this.add().spaceRight(space);
		this.add(experience).expandX().fill().align(Align.right);
		this.row();
		this.add(points).expandX().fill().align(Align.right);
	}
}
