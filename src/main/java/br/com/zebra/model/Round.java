package br.com.zebra.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Round {

	private List<Player> players;
	
	private int numCards;
	
	private Map<Long, RoundMarks> marks;

	private Deck deck = Deck.getDeck();
	
	public Round(List<Player> players, int numCards){
		this.players = players;
		this.numCards = numCards;
		this.marks = new HashMap<Long, RoundMarks>();
	}
	
	public void play(){
//		this.giveCards();
		int begginer = 0;
		for(int i = 0; i < this.numCards; i++){
			Hand hand = new Hand();
			hand.setPlayerBegginer(begginer);
			hand.setPlayers(players);
			hand.play();
			hand.setWinner();
			begginer = hand.getPlayerWinner();
			Player p = hand.getWinner();
			RoundMarks rm = marks.get(p.getId());
			rm.addWinnings();
		}
	}
	
	public void giveCards(){
		List<Integer> rCards = chooseCards();
		for(Player p : this.players){
			ArrayList<Card> hand = new ArrayList<Card>();
			for(int numCard = this.numCards - 1; numCard >= 0; numCard--){
				Card card = deck.getCard(rCards.get(numCard));
				rCards.remove(numCard);
				hand.add(card);
			}
			p.setHand(hand);
		}
	
	}
	
	public List<Integer> chooseCards(){
		ArrayList<Integer> rCards = new ArrayList<Integer>(); 
		int size = this.numCards * this.players.size();
		do{
			Random r = new Random();
			int i = r.nextInt(53);
			if(!rCards.contains(i)){
				rCards.add(i);
			}
		}while(rCards.size() < size);
		
		return rCards;
		
	}
	
	public void setUpMarks(Player p, int guess){
		RoundMarks rm = null;
		if(marks.containsKey(p.getId())){
			rm = marks.get(p.getId());
			rm.setGuess(guess);
		}else{
			rm = new RoundMarks();
			rm.setPlayer(p);
			rm.setGuess(guess);
			marks.put(p.getId(), rm);
		}
	}
	
	public int guessNotPossible(){
		int total = 0;
		for(Long key: marks.keySet()){
			RoundMarks rm = marks.get(key);
			total += rm.getGuess();
		}
		if(total < this.numCards){
			return this.numCards - total;
		}
		return -1;
	}

	public Map<Long, RoundMarks> getMarks() {
		return marks;
	}
	
	public int getPlayersPoints(Long id){
		RoundMarks rm = marks.get(id);
		return rm.getPoints();
	}
	
	
	
}
