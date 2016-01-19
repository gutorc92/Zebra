package br.com.zebra.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import br.com.zebra.InterfacePlayer;

public class Hand {
	
	private List<Player> players;
	
	private int playerBegginer;
	
	private int playerWinner;
	
	private Player winner;
	
	private int suit;
	
	private Map<Card, Player> cards;
	

	public Hand(){
		this.cards = new HashMap<Card,Player>();
	}
	public Player getWinner() {
		return winner;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setPlayerBegginer(int playerBegginer) {
		this.playerBegginer = playerBegginer;
	}

	public int getPlayerWinner() {
		return playerWinner;
	}

	public void setPlayerWinner(int playerWinner) {
		this.playerWinner = playerWinner;
	}
	
	public void setWinner(){
		TreeSet<Card> hand = new TreeSet<Card>(cards.keySet());
		Card card = hand.last();
		System.out.println("Card of the winner: " + card.getSuit() + " " + card.getValue());
		winner = cards.get(card);
		System.out.println("The winner is: " + winner.getName());
		playerWinner = findPlayerWinner(winner);
	}
	
	private int findPlayerWinner(Player player){
		int i = -1;
		for(int j= 0; j < players.size(); j++){
			Player p = players.get(j);
			if(p.getId() == player.getId()){
				i = j;
			}
		}
		return i;
		
	}
	
	public void setSuit(Card card){
		this.suit = card.getSuit();
	}
	
	private void setStrength2(){
		for(Card c : this.cards.keySet()){
			c.setStrength(this.suit);
			System.out.println("Card: " + c.getSuit() + " " + c.getValue() + " " + c.getStrength());
		}
	}

	public void play() {
		for(int i = 0; i < this.players.size(); i++){
			int j = (this.playerBegginer + i) % this.players.size();
			Player p =  this.players.get(j);
			Card card = null;
			if(i == 0){
				card = new InterfacePlayer(p).chooseCard();
				this.setSuit(card);
			}else{
				card = new InterfacePlayer(p).chooseCard(this.suit);
			}
			this.cards.put(card, p);
		}
		this.setStrength2();
	}
	
	
	
}
