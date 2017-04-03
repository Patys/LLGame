package com.patys.llgame.UserInterface;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.patys.llgame.Card;
import com.patys.llgame.MetaGame;

public class GameView extends Subject {
	private DefaultSkin skin;
	
	private Table table;
	
	private Card currentCard;
	private UserInterface ui;
	
	public GameView(UserInterface ui) {
		skin = new DefaultSkin();
		table = new Table();
		this.ui = ui;
		updateGame(ui);
	}
	
	public void updateGame(final UserInterface ui) {
		table.clearChildren();
		
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
		
		table.add();
		table.add(getPreparedCardWithWord(mainCard)).space(5).center();
		table.row();
		addCardsToTableInRandomWay(table, card1, card2, card3);
		
		TextButton backButton = new TextButton("<-", skin.getSkin());
		
		backButton.addListener(new ChangeListener() {
	        @Override
	        public void changed (ChangeEvent event, Actor actor) {
	        	getBackToMainView(ui);
	        }
	    });
		table.row();
	    table.add(backButton).space(10).bottom().right();
	}
	
	private Table getPreparedCardWithWord(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.word, skin.getSkin());
		
		graphicalCard.add(meaning).spaceBottom(50).center();

		currentCard = card;
		return graphicalCard;
	}
	
	private Table getPreparedCardWithMeaning(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.meaning, skin.getSkin());
		Label good = new Label("Dobrze: " + Float.toString(card.good), skin.getSkin());
		Label wrong = new Label("Zle: " + Float.toString(card.wrong), skin.getSkin());
		
		graphicalCard.add(meaning).spaceBottom(50).center();
		graphicalCard.row();
		graphicalCard.add(good).left().padLeft(15).expandX();
		graphicalCard.row();
		graphicalCard.add(wrong).left().padLeft(15).expandX();
		
		graphicalCard.setTouchable(Touchable.enabled); 
		graphicalCard.addListener(addListener(card));

		return graphicalCard;
	}
	
	private ClickListener addListener(final Card card) {
		return new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            checkAnswer(currentCard, card);
	        }
	    };
	}
	
	private void checkAnswer(Card word, Card meaning) {
		if(word != null && meaning != null) {
			if(word.meaning.equals(meaning.meaning)) {
				MetaGame.cardManager.getCardByWord(word.word).good += 1;
				MetaGame.experience += 10;
				MetaGame.points += 1;
			}
			else {
				MetaGame.cardManager.getCardByWord(word.word).wrong += 1;
				if(MetaGame.points > 0) {
					MetaGame.points -= 1;
				}
			}
			this.setState(1);
			updateGame(ui);
		}
	}
	
	private void addCardsToTableInRandomWay(Table table, Card card1, Card card2, Card card3) {
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
					table.add(getPreparedCardWithMeaning(card1)).space(5).left();
				}
				break;
			case 2:
				if(!addedCardTwo) {
					addedCardTwo = true;
					table.add(getPreparedCardWithMeaning(card2)).space(5).left();
				}
				break;
			case 3:
				if(!addedCardThree) {
					addedCardThree = true;
					table.add(getPreparedCardWithMeaning(card3)).space(5).left();
				}
				break;
			}
		}
	}

	private void getBackToMainView(UserInterface ui) {
		ui.goToMainView();
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
