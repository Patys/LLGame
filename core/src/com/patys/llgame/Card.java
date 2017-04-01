package com.patys.llgame;

public class Card {
	// good or wrong picks
	public float good;
	public float wrong;
	
	public String word;
	public String meaning;
	
	public Boolean bought;
	public int cost;
	
	public Card() {
		this.good = 0;
		this.wrong = 0;
		
		this.word = "";
		this.meaning = "";
		
		this.bought = false;
		this.cost = 0;
	}
	
	public Card(String word, String meaning) {
		this.good = 0;
		this.wrong = 0;
		
		this.word = word;
		this.meaning = meaning;
		
		this.bought = false;
		this.cost = 0;
	}
	
	public Card(String word, String meaning, float good, float wrong) {
		this.good = good;
		this.wrong = wrong;
		
		this.word = word;
		this.meaning = meaning;
		
		this.bought = false;
		this.cost = 0;
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

	public Boolean getBought() {
		return bought;
	}

	public void setBought(Boolean bought) {
		this.bought = bought;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
