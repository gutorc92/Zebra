package br.com.zebra;

import junit.framework.Assert;

import org.junit.Test;

import br.com.zebra.model.Card;

public class CardTest {

	@Test
	public void getAndSet(){
		Card card = new Card();
		card.setValue(2);
		Assert.assertEquals("This shoud be equal", 2, card.getValue());
		card.setSuit(2);
		Assert.assertEquals("This shoud be equal", 2, card.getSuit());
		card.setValue(15);
		Assert.assertEquals("It shoud remain 2", 2, card.getValue());
		card.setStrength(2);
		Assert.assertEquals("This shoud be equal", 2, card.getStrength());
		card.setStrength(1);
		Assert.assertEquals("This shoud be equal", 0, card.getStrength());
		card.setSuit(4);
		card.setStrength(3);
		Assert.assertEquals("This shoud be equal", 4, card.getStrength());
	}
	
	@Test
	public void compareTo(){
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
		System.out.println(card.compareTo(card1));
		Assert.assertEquals("The card should be ",1,card.compareTo(card1));
		Assert.assertEquals("The card should be ",-1,card1.compareTo(card));
		Assert.assertEquals("The card should be ",0,card.compareTo(card2));
	}
}
