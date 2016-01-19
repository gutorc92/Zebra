package br.com.zebra.model;

public enum Suit {
	DIAMONDS("Diamonds",4),
	CLUBS("Clubs",3),
	HEARTS("Hearts",2),
	SPADES("Spades",1);
	
	private final String suit;
	
	private final int value;
	
	private Suit(String suit, int value){
		this.suit = suit;
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.suit;
	}
	
	public static String getSuit(int value){
		if(Suit.DIAMONDS.getValue() == value){
			return Suit.DIAMONDS.toString();
		}else if(Suit.CLUBS.getValue() == value){
			return Suit.CLUBS.toString();
		}else if(Suit.HEARTS.getValue() == value){
			return Suit.HEARTS.toString();
		}else if(Suit.SPADES.getValue() == value){
			return Suit.SPADES.toString();
		}
		return "Not found";
	}
	
	public int getValue(){
		return this.value;
	}
	
	

}
