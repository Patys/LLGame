package com.patys.llgame.UserInterface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainView extends Table{
	private TextButton playButton;
	private TextButton exitButton;
	private DefaultSkin skin;
	
	private GameView gameView;
	
	public MainView() {
		skin = new DefaultSkin();
		
		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);
		
		playButton = new TextButton("Graj", skin);
		playButton.padLeft(20);
		playButton.padRight(20);
		playButton.padTop(5);
		playButton.padBottom(5);
		exitButton = new TextButton("Wyj�cie", skin);
		
		gameView = new GameView();
		
		this.add(playButton).space(10);
		this.row();
		this.add(exitButton);
		
		playButton.addListener(new ChangeListener() {
	        @Override
	        public void changed (ChangeEvent event, Actor actor) {
	            createGame();
	        }
	    });
	}
	
	private void createGame() {
		this.reset();
		gameView.startGame();
		this.add(gameView);
	}
}
