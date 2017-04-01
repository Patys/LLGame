package com.patys.llgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public Boolean addNewCard(Card card) {
		if(cards.add(card))
			return true;
		else
			return false;
	}
	
	public Boolean addNewCard(String word, String meaning) {
		if(cards.add(new Card(word, meaning)))
			return true;
		else
			return false;
	}
	
	public Card getCardByWord(String word) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).word.contentEquals(word))
				return cards.get(i);
		}
		return null;
	}
	
	public Card getCardByMeaning(String meaning) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).meaning.contentEquals(meaning))
				return cards.get(i);
		}
		return null;
	}
	
	public Card getRandomCard() {
		Random rand = new Random();
		int n = rand.nextInt(cards.size());
		return cards.get(n);
	}
	
	public Boolean loadCards(String filename) {
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
	
	public Boolean saveCards(String filename) {
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
