package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import main.java.classes.Hand;

public class Poker {
	
	public static void main(String[] args) throws IOException{
		URL url = new URL("https://projecteuler.net/project/resources/p054_poker.txt");
		InputStream is = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    int count=(int)reader.lines().filter(s->Hand.playerOneWins(s)==true).count();
		System.out.println("Player 1 wins "+count+" hands");	
	 }
}