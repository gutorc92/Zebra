package br.com.zebra;

import java.util.Scanner;

import br.com.zebra.model.Card;
import br.com.zebra.model.Player;
import br.com.zebra.model.Round;
import br.com.zebra.model.Suit;

public class InterfaceGuess {

	private Player p;
	
	private Round round;
	
	private Scanner scanner = new Scanner(System.in);
	
	private boolean last;
	
	public InterfaceGuess(Player p, Round round, boolean last) {
		this.p = p;
		this.round = round;
		this.last = last;
	}
	
	public void guess(){
		System.out.println("User: " + p.getName());
		System.out.print("Cards\t");
		this.printCards();
		if(last){
			this.lastGuess();
		}else{
			this.normalGuess();
		}
	}
	
	private void normalGuess(){
		System.out.print("Enter your guess: ");
		int guess = scanner.nextInt();
		scanner.nextLine();
		round.setUpMarks(this.p, guess);
	}
	
	private void lastGuess(){
		System.out.println("Not possible: " + round.guessNotPossible());
		if(round.guessNotPossible() == -1){
			this.normalGuess();
		}else{
			int guess = 0;
			do{
				System.out.print("Enter your guess: ");
				guess = scanner.nextInt();
				scanner.nextLine();
			}while(guess == round.guessNotPossible());
			round.setUpMarks(this.p, guess);
		}
	}
	
	public void printCards(){
		for(Card c : this.p.getHand()){
			if(c.getValue() == 0){
				System.out.println("Erro no valor");
			}
			System.out.print("" + c.getValue() + Suit.getSuit(c.getSuit()) + " ");
		}
		System.out.println("");
	}
}
