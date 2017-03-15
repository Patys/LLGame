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
import com.patys.llgame.Card;
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
		
		Card mainCard = MetaGame.cardManager.getRandomCard();
		Card card1 = MetaGame.cardManager.getCardByWord(mainCard.word);
		Card card2 = MetaGame.cardManager.getRandomCard();
		Card card3 = MetaGame.cardManager.getRandomCard();
		
		while(card1.meaning.equals(card2.meaning)){
			card2 = MetaGame.cardManager.getRandomCard();
		}
		while(card1.meaning.equals(card3.meaning) || card2.meaning.equals(card3.meaning)){
			card3 = MetaGame.cardManager.getRandomCard();
		}
		
		this.add();
		this.add(getPreparedCardWithWord(mainCard)).space(5).center();
		this.row();
		addCardsToTableInRandomWay(this, card1, card2, card3);
	}
	
	Table getPreparedCardWithWord(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.word, getLabelStyle());
		
		graphicalCard.add(meaning).spaceBottom(50).center();
		
		return graphicalCard;
	}
	
	Table getPreparedCardWithMeaning(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.meaning, getLabelStyle());
		Label good = new Label("Dobrze: " + Float.toString(card.good), getLabelStyle());
		Label wrong = new Label("Zle: " + Float.toString(card.wrong), getLabelStyle());
		
		graphicalCard.add(meaning).spaceBottom(50).center();
		graphicalCard.row();
		graphicalCard.add(good).left().padLeft(15).expandX();
		graphicalCard.row();
		graphicalCard.add(wrong).left().padLeft(15).expandX();
		
		return graphicalCard;
	}
	
	void addCardsToTableInRandomWay(Table table, Card card1, Card card2, Card card3) {
		// simple randomize
		Boolean addedCardOne = false;
		Boolean addedCardTwo = false;
		Boolean addedCardThree = false;
		while(!addedCardOne || !addedCardTwo || !addedCardThree ){
			int random = (int )(Math.random() * 3 + 1);
			switch(random) {
			case 1:
				if(!addedCardOne){
					addedCardOne = true;
					this.add(getPreparedCardWithMeaning(card1)).space(5).left();
				}
				break;
			case 2:
				if(!addedCardTwo) {
					addedCardTwo = true;
					this.add(getPreparedCardWithMeaning(card2)).space(5).left();
				}
				break;
			case 3:
				if(!addedCardThree) {
					addedCardThree = true;
					this.add(getPreparedCardWithMeaning(card3)).space(5).left();
				}
				break;
			}
		}
	}
	
	Label.LabelStyle getLabelStyle() {
		Label.LabelStyle label1Style = new Label.LabelStyle();
	    BitmapFont myFont = skin.getFont("default");
	    label1Style.font = myFont;
	    label1Style.fontColor = Color.DARK_GRAY;
	    return label1Style;
	}
}
