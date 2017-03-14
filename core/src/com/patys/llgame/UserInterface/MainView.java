package com.patys.llgame.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.patys.llgame.MetaGame;

public class MainView extends Table{
	private TextButton playButton;
	private TextButton exitButton;
	private Skin skin;
	
	public MainView() {
		skin = new Skin();
		
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
		
		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());
		

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
		exitButton = new TextButton("Wyjœcie", skin);
		
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
		startGame();
	}
	
	private void startGame() {
		String mainCard = MetaGame.cardManager.getRandomCard().word;
		String meaning_one = MetaGame.cardManager.getCardByWord(mainCard).meaning;
		String meaning_two = MetaGame.cardManager.getRandomCard().meaning;
		String meaning_three = MetaGame.cardManager.getRandomCard().meaning;
		while(meaning_one.equals(meaning_two)){
			meaning_two = MetaGame.cardManager.getRandomCard().meaning;
		}
		while(meaning_one.equals(meaning_three) && meaning_two.equals(meaning_three)){
			meaning_three = MetaGame.cardManager.getRandomCard().meaning;
		}
		
	    Label.LabelStyle label1Style = new Label.LabelStyle();
	    BitmapFont myFont = skin.getFont("default");
	    label1Style.font = myFont;
	    label1Style.fontColor = Color.RED;
		
		Label mainCardLabel = new Label(mainCard, label1Style);
		Label meaningOneLabel = new Label(meaning_one, label1Style);
		Label meaningTwoLabel = new Label(meaning_two, label1Style);
		Label meaningThreeLabel = new Label(meaning_three, label1Style);
		
		
		Table cardMain = new Table();
		cardMain.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		cardMain.add(mainCardLabel).center();

		Table cardLeft = new Table();
		cardLeft.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		cardLeft.add(meaningOneLabel).center();

		Table cardCenter = new Table();
		cardCenter.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		cardCenter.add(meaningTwoLabel).center();

		Table cardRight = new Table();
		cardRight.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		cardRight.add(meaningThreeLabel).center();
		
		this.add();
		this.add(cardMain).space(5).center();
		this.row();
		this.add(cardLeft).space(5).left();
		this.add(cardCenter).space(5).center();
		this.add(cardRight).space(5).right();
	}
}
