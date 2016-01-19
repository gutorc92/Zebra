package br.com.zebra;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.zebra.model.Card;
import br.com.zebra.model.Player;

public class PlayerTest {

	@Test
	public void getAndSet(){
		Player p = new Player();
		p.setId(2L);
		Long ex = new Long(2);
		Assert.assertEquals(ex, p.getId());
		p.setName("Gustavo");
		Assert.assertEquals("Gustavo", p.getName());
		Card card = new Card();
		card.setValue(5);
		card.setSuit(2);
		card.setStrength(2);
		Card card1 = new Card();
		card1.setValue(5);
		card1.setSuit(1);
		card1.setStrength(2);
		Card card2 = new Card();
		card2.setValue(5);
		card2.setSuit(2);
		card2.setStrength(2);
		List<Card> cards = new ArrayList<Card>();
		cards.add(card);
		cards.add(card1);
		cards.add(card2);
		p.setHand(cards);
		Assert.assertEquals(cards, p.getHand());
	}
}
