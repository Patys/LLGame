package com.patys.llgame;

public class Card {
	// good or wrong picks
	public float good;
	public float wrong;
	
	public String word;
	public String meaning;
	
	public Card(String word, String meaning) {
		this.good = 0;
		this.wrong = 0;
		
		this.word = word;
		this.meaning = meaning;
	}
	
	public Card(String word, String meaning, float good, float wrong) {
		this.good = good;
		this.wrong = wrong;
		
		this.word = word;
		this.meaning = meaning;
	}
}
