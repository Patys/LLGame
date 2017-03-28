package com.patys.llgame.UserInterface;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.patys.llgame.Card;
import com.patys.llgame.MetaGame;

public class ShopView {

	private DefaultSkin skin;
	private Table cardHolder;
	private Table table;
	private ScrollPane scroller;

	
	public ShopView() {
		skin = new DefaultSkin();
		cardHolder = new Table();
		
		for(Card x : MetaGame.cardManager.getCards()) {
			Label wordLabel = new Label(x.getWord(), skin.getSkin());
			Label meaningLabel = new Label(x.getMeaning(), skin.getSkin());
			cardHolder.add(wordLabel).spaceRight(20);
			cardHolder.add(meaningLabel);
			cardHolder.row();
		}

		scroller = new ScrollPane(cardHolder);

		table = new Table();
	    table.add(scroller).fill().expand();
	}

	public Table getTable() {
		return table;
	}	
}
