package com.patys.llgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		// TODO: read all cards from file
		
		
		return true;
	}
	
	Boolean saveCards(String filename) {
		// TODO: save all cards from list: cards
		
		return true;
	}

	public List<Card> getCards() {
		return cards;
	}
}
