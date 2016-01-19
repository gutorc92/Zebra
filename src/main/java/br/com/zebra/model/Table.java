package br.com.zebra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.zebra.InterfaceGuess;
import br.com.zebra.InterfaceTablePoints;

public class Table {

	private int numPlayers;
	
	private int numRounds;
	
	private List<Player> players;
	
	private Map<Long,TableMarks> marks;
	
	public Table(int numPlayers){
		this.numPlayers = numPlayers;
//		this.numRounds = 52/numPlayers;
		this.numRounds = 2;
		this.players = new ArrayList<Player>();
		this.marks = new HashMap<Long, TableMarks>();
	}
	
	public void createPlayer(String name){
		if(players.size() < numPlayers){
			Player p = new Player();
			p.setId(new Long(this.players.size() + 1));
			p.setName(name);
			players.add(p);
			TableMarks tm = new TableMarks(this.numRounds);
			marks.put(p.getId(), tm);
			System.out.println("Player id: " + p.getId() + " Name: " + p.getName());
		}
	}

	public void play() {
		// TODO Auto-generated method stub
		for(int i = 1; i <= this.numRounds; i++){
			Round r = new Round(players, i);
			r.giveCards();
			for(int j = 0; j < this.players.size(); j++){
				Player p = players.get(j);
				boolean last = false;
				if(j + 1 == this.players.size()){
					last = true;
				}
				InterfaceGuess itf = new InterfaceGuess(p, r, last );
				itf.guess();
			}
			r.play();
			this.countPoints(i,r);
			this.printPoints();
		}
		
	}

	private void printPoints() {
    	InterfaceTablePoints itp = new InterfaceTablePoints(this.numRounds);
    	itp.title();
    	for(Player p: players){
    		TableMarks tm = marks.get(p.getId());
    		itp.printPointsPlayer(p, tm.getPoints());
    	}
		
	}

	private void countPoints(int round, Round r) {
		for(Player p: players){
			TableMarks tm = marks.get(p.getId());
			tm.setPoint(round, r.getPlayersPoints(p.getId()));
		}
		
		
	}
	
}
