package br.com.zebra.model;

import java.util.List;

public class Player {

	private Long id;
	
	private String name;
	
	private List<Card> hand;

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private boolean hasSuit(int suit){
		for(Card card: hand){
			if(card.getSuit() == suit){
				return true;
			}
		}
		return false;
	}
	
	public boolean validateCard(int suit, int card){
		if(hasSuit(suit) && this.hand.get(card).getSuit() != suit){
			return false;
		}
		return true;
	}
	
}
