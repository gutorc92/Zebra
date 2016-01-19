package br.com.zebra.model;

public class Card implements Comparable<Card> {
	
	private int strength;
	
	private int suit;
	
	private int value;

	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if(value > 1 && value < 14){
			this.value = value;
		}
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int suit) {
		if(this.suit == suit){
			this.strength = this.value;
		}else if(this.suit == Suit.DIAMONDS.getValue()){
			this.strength = this.value * 5;
		}else{
			this.strength = 0;
		}
	}

	public int compareTo(Card other) {
		return Integer.compare(this.getStrength(), other.getStrength());
	}
	
	
}
