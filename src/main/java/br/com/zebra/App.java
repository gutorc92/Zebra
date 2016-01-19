package br.com.zebra;

import java.util.Scanner;

import br.com.zebra.model.Table;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
        System.out.println( "Zebra!" );
        System.out.print("Enter the number of players: ");
        int np = scanner.nextInt();
        scanner.nextLine();
        Table t = new Table(np);
        for(int i = 0; i < np; i++){
        	System.out.print("Enter the name of the player: ");
            String name = scanner.nextLine();
            t.createPlayer(name);
        }
        t.play();
        
        
    }
}
