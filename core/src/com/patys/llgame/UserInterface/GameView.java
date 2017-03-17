package com.patys.llgame.UserInterface;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.patys.llgame.Card;
import com.patys.llgame.MetaGame;

public class GameView extends Table{
	private DefaultSkin skin;
	
	public GameView() {
		skin = new DefaultSkin();
	}
	
	public void startGame() {
		
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
	
	private Table getPreparedCardWithWord(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.word, skin);
		
		graphicalCard.add(meaning).spaceBottom(50).center();
		
		return graphicalCard;
	}
	
	private Table getPreparedCardWithMeaning(Card card) {
		Table graphicalCard = new Table();
		graphicalCard.background(new TextureRegionDrawable(new TextureRegion(new Texture("data/card_blue.png"))));
		
		Label meaning = new Label(card.meaning, skin);
		Label good = new Label("Dobrze: " + Float.toString(card.good), skin);
		Label wrong = new Label("Zle: " + Float.toString(card.wrong), skin);
		
		graphicalCard.add(meaning).spaceBottom(50).center();
		graphicalCard.row();
		graphicalCard.add(good).left().padLeft(15).expandX();
		graphicalCard.row();
		graphicalCard.add(wrong).left().padLeft(15).expandX();
		
		return graphicalCard;
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
}
