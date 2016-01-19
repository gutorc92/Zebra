package br.com.zebra;

import br.com.zebra.model.Player;

public class InterfaceTablePoints {

	private int numRounds;
	
	public InterfaceTablePoints(int numRounds) {
		this.numRounds = numRounds;
	}
	
	public void title(){
		System.out.println("------------------------------------------------ The Results ------------------------------------------------ ");
		System.out.print("Name\t\t");
		for(int i = 1; i <= numRounds; i++){
			System.out.print(i+"\t");
		}
		System.out.println("");
	}
	
	public void printPointsPlayer(Player p, int[] points){
		System.out.print(p.getName()+"\t\t");
		for(int i = 1; i <= numRounds; i++){
			System.out.print(points[i]+"\t");
		}
		System.out.println("");
	}
	
	

}
