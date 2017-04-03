package com.patys.llgame.UserInterface;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.patys.llgame.Card;
import com.patys.llgame.MetaGame;

public class ShopView {

	private DefaultSkin skin;
	private Table cardHolder;
	private Table table;
	private ScrollPane scroller;

	
	public ShopView(final UserInterface ui) {
		skin = new DefaultSkin();
		cardHolder = new Table();
		
		buildTable();
		
		scroller = new ScrollPane(cardHolder);

		TextButton backButton = new TextButton("<-", skin.getSkin());
		
		backButton.addListener(new ChangeListener() {
	        @Override
	        public void changed (ChangeEvent event, Actor actor) {
	        	getBackToMainView(ui);
	        }
	    });
		
		table = new Table();
	    table.add(scroller).fill().expand();
	    table.row();
	    table.add(backButton).space(50).bottom().right();
	}
	
	private void buildTable() {
		for(final Card x : MetaGame.cardManager.getCards()) {
			if(x.getBought() == false) {
				Label wordLabel = new Label(x.getWord(), skin.getSkin());
				Label meaningLabel = new Label(x.getMeaning(), skin.getSkin());
				Label costLabel = new Label("Cost: " + x.getCost(), skin.getSkin());
				
				TextButton buyButton = new TextButton("Kup", skin.getSkin());
				
				buyButton.addListener(new ChangeListener() {
			        @Override
			        public void changed (ChangeEvent event, Actor actor) {
			        	buyCardByWord(x.getWord());
			        }
			    });
				
				cardHolder.add(wordLabel).spaceRight(20);
				cardHolder.add(meaningLabel).spaceRight(20);
				cardHolder.add(costLabel).spaceRight(20);
				cardHolder.add(buyButton);
				cardHolder.row();	
			}	
		}
	}
	
	private void buyCardByWord(String word) {
		// TODO: add buying in card manager
		System.out.println("You bought " + word);
	}

	private void getBackToMainView(UserInterface ui) {
		ui.goToMainView();
	}
	
	public Table getTable() {
		return table;
	}	
}
