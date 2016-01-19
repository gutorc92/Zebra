package br.com.zebra.model;

public class TableMarks {
	
	
	private int[] points;
	
	public TableMarks(int numRounds){
		this.points = new int[numRounds + 1];
	}
	
	public void setPoint(int round, int points){
		this.points[round] = points + this.points[round - 1];
	
	}
	
	public int[] getPoints(){
		return this.points;
	}
	
	

}
