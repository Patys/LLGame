package com.patys.llgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollBar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class CardManager {
	private List<Card> cards;
	
	public CardManager() {
		cards = new ArrayList<Card>();
	}
	
	Boolean addNewCard(String word, String meaning) {
		if(cards.add(new Card(word, meaning)))
			return true;
		else
			return false;
	}
	
	Card getCardByWord(String word) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).word.contentEquals(word))
				return cards.get(i);
		}
		return null;
	}
	
	Card getCardByMeaning(String meaning) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).meaning.contentEquals(meaning))
				return cards.get(i);
		}
		return null;
	}
	
	Card getRandomCard() {
		Random rand = new Random();
		int n = rand.nextInt(cards.size()-1);
		return cards.get(n);
	}
	
	Boolean loadCards(String filename) {
		Json json = new Json();
		FileHandle file = Gdx.files.internal(filename);
		if(!file.exists())
			return false;
		
		JsonValue root = new JsonReader().parse(file);
		
		for (JsonValue v : root) {
			cards.add(json.readValue(Card.class, v));
		}
		
		return true;
	}
	
	Boolean saveCards(String filename) {
		Json json = new Json();
		String data = json.toJson(cards);
		if(data.length() <= 0)
			return false;
		
		FileHandle file = Gdx.files.local(filename);
		file.writeString(data, false);
		return true;
	}

	public List<Card> getCards() {
		return cards;
	}
}
