

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import classes.Hand;


public class Poker {
	
	public static void main(String[] args) throws IOException{
		URL url = new URL("https://projecteuler.net/project/resources/p054_poker.txt");
		InputStream is = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        int count=(int)reader.lines().filter(s->playerOneWins(s)).count();
		System.out.println("Player 1 wins "+count+" hands");	
	 }
	
	// returns true if Player 1 wins
	public static boolean playerOneWins(String hands)
	{
		int position=14;
		String hand1=hands.substring(0,position);
		String hand2=hands.substring(position+1);
		return new Hand(hand1).compareTo(new Hand(hand2))>0;
	}
}
