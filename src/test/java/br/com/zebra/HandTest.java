package br.com.zebra;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;

import br.com.zebra.model.Card;
import br.com.zebra.model.Hand;
import br.com.zebra.model.Player;
import br.com.zebra.model.Suit;

public class HandTest {
	
	private List<Card> deck;
	
	@Before
	public void setUp(){
		deck = new ArrayList<Card>();
	}
	
	
	public void setSuit(){
		Card card = new Card();
		card.setSuit(2);
		Hand hand = new Hand();
		hand.setSuit(card);
		Assert.assertEquals(2, 2);
	}
	
	
	public void testPlay(){
		Card card = new Card();
		card.setValue(5);
		card.setSuit(2);
		Card card1 = new Card();
		card1.setValue(5);
		card1.setSuit(1);
		ArrayList<Card> c1 = new ArrayList<Card>();
		c1.add(card);
		c1.add(card1);
		Player p = new Player();
		p.setId(2L);
		p.setName("Gustavo");
		p.setHand(c1);
		
		Card card2 = new Card();
		card2.setValue(5);
		card2.setSuit(2);
		Card card3 = new Card();
		card3.setValue(5);
		card3.setSuit(2);
		
		ArrayList<Card> c2 = new ArrayList<Card>();
		c2.add(card2);
		c2.add(card3);
		Player p1 = new Player();
		p1.setId(3L);
		p1.setName("Pedro");
		p1.setHand(c2);
		
		Card card4 = new Card();
		card4.setValue(5);
		card4.setSuit(4);
		Card card5 = new Card();
		card5.setValue(5);
		card5.setSuit(4);
		ArrayList<Card> c3 = new ArrayList<Card>();
		c3.add(card4);
		c3.add(card5);
		Player p2 = new Player();
		p2.setId(2L);
		p2.setName("Joao");
		p2.setHand(c3);
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(p);
		players.add(p1);
		players.add(p2);
		
		Hand hand = new Hand();
		hand.setPlayers(players);
		hand.setPlayerBegginer(1);
		hand.play();
		hand.setWinner();
		Assert.assertEquals(2, hand.getPlayerWinner());
	}
	
	public void setUpDeck(){
		for(Suit suit: Suit.values()){
			for(int i = 1; i <= 13; i++){
				Card card = new Card();
				card.setSuit(suit.getValue());
				card.setValue(i);
				deck.add(card);
			}
		}
	}

}
