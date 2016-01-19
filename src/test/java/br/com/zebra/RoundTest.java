package br.com.zebra;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.zebra.model.Player;
import br.com.zebra.model.Round;

public class RoundTest {

	@Test
	public void testRandomNumbers(){
		Player p = new Player();
		p.setId(2L);
		p.setName("Gustavo");
		Player p1 = new Player();
		p1.setId(3L);
		p1.setName("Pedro");
		Player p2 = new Player();
		p2.setId(2L);
		p2.setName("Joao");
		List<Player> players = new ArrayList<Player>();
		players.add(p);
		players.add(p1);
		players.add(p2);
		Round round = new Round(players,2);
		List<Integer> pCards = round.chooseCards();
		Assert.assertEquals(6,pCards.size());
		round.giveCards();
	}
}
