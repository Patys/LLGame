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

	public float getGood() {
		return good;
	}

	public void setGood(float good) {
		this.good = good;
	}

	public float getWrong() {
		return wrong;
	}

	public void setWrong(float wrong) {
		this.wrong = wrong;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
