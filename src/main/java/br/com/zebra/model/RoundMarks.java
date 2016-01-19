package br.com.zebra.model;

public class RoundMarks {
	
	private Player player;
	
	private int guess;
	
	private int winnings;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getWinnings() {
		return winnings;
	}

	public void setWinnings(int winnings) {
		this.winnings = winnings;
	}
	
	public void addWinnings() {
		this.winnings++;
	}
	
	public int getPoints(){
		if(this.guess == this.winnings){
			return this.winnings * 10;
		}
		return Math.abs(this.guess - this.winnings) * (-10);
	}

}
;