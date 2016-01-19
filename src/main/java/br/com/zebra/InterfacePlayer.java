package br.com.zebra;

import java.util.Scanner;

import br.com.zebra.model.Card;
import br.com.zebra.model.Player;
import br.com.zebra.model.Suit;

public class InterfacePlayer {

	private Player p;
	private Scanner scanner = new Scanner(System.in);
	
	public InterfacePlayer(Player p) {
		this.p = p;
	}
	
	public Card chooseCard(int suit){
		int i = 0;
		System.out.println("Player: " + this.p.getName());
		int cd = 0;
		do{
			for(Card c: p.getHand()){
				System.out.println("Card " + i + ": naipe " +  Suit.getSuit(c.getSuit()) + " Value " + c.getValue());
				i++;
			}
			System.out.print("Enter the number of your card: ");
			cd = scanner.nextInt();
			scanner.nextLine();
			if(p.validateCard(suit, cd) == false){
				System.out.println("You must choose a card with a same suit.");
				i = 0;
			}
		}while(!p.validateCard(suit, cd));
		Card card = this.p.getHand().get(cd);
		this.p.getHand().remove(cd);
		return card;
	}
	
	public Card chooseCard(){
		int i = 0;
		System.out.println("Player: " + this.p.getName());
		for(Card c: p.getHand()){
			System.out.println("Card " + i + ": naipe: " +  Suit.getSuit(c.getSuit()) + " Value " + c.getValue());
			i++;
		}
		System.out.print("Enter the number of your card: ");
		int cd = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Card chose: " + cd);
		Card card = this.p.getHand().get(cd);
		this.p.getHand().remove(cd);
		return card;
	}
}
