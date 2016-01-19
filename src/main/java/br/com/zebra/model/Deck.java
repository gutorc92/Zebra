package br.com.zebra.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private static List<Card> deck = new ArrayList<Card>();

	private static Deck d = null;
	
	private Deck(){
		
	}
	
	private void setUpDeck(){
		for(Suit suit: Suit.values()){
			for(int i = 1; i <= 13; i++){
				Card card = new Card();
				card.setSuit(suit.getValue());
				card.setValue(i);
				deck.add(card);
			}
		}
	}
	
	public Card getCard(int i){
		return this.deck.get(i);
	}
	
	public static Deck getDeck(){
		if(d == null){
			d = new Deck();
			d.setUpDeck();
		}
		return d;
		
	}
}
