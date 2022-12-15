package main.java.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.enums.CardValue;
import main.java.enums.Rank;
import main.java.enums.Suit;


public class Hand implements Comparable<Hand>{
private List<Card> cards;

public Hand(String cards) {
	String[] els=cards.split(" ");
	String[] cardPart;
	Card card;
	
	this.cards=new ArrayList<Card>(els.length/2);
	for(String el:els)
	{
		cardPart=el.split("");
		card=new Card(CardValue.getEnum(cardPart[0]),Suit.valueOf(cardPart[1]));
		this.cards.add(card);
		
	}
	
}

/**
 * @return the cards
 */
public List<Card> getCards() {
	return cards;
}

/**
 * @param cards the cards to set
 */
public void setCards(List<Card> cards) {
	this.cards = cards;
}

public boolean isFlush()
{
	Suit suit=cards.get(0).getSuit();
	int i=0;
	int size=cards.size();
	boolean flush=true;
	while(i<size && flush)
	{
		flush=cards.get(i).getSuit()==suit;
		i++;
	}
	return flush;
}
public boolean isStraight()
{
	List<Card> cards=new ArrayList<Card>(this.cards.size());
	cards.addAll(this.cards);
	cards.sort(null);
	int size=cards.size();
	boolean straight=true;
	int i=0;
	while(i<size-1 && straight)
	{
		straight=cards.get(i+1).getValue().ordinal()-cards.get(i).getValue().ordinal()==1;
		i++;
	}
	return straight;
}
public boolean isStraightFlush()
{
	return this.isFlush() && this.isStraight();
}
public boolean isRoyalFlush()
{
	return this.cards.get(0).getValue().equals(CardValue.ten) && this.isFlush() && this.isStraight();
}

public Card getCardByOccurence(int x)
{
	int size=this.cards.size();
	Card card;
	for (int i = 0; i < size; i++) 
	{
		card=this.cards.get(i);
		if(Collections.frequency(this.cards,card)==x)
		{
			return card;
		}
		
	}
	return null;
	
}

public Hand(List<Card> cards) {
	super();
	this.cards = cards;
}

public Map<Integer,List<Card>> pairs()
{
	List<Card> cards=new ArrayList<Card>();
	cards.addAll(this.cards);
	int size=cards.size();
	int count=0;
	Card card;
	ArrayList<Card> liste;
	ArrayList<Card> pairs=new ArrayList<Card>();
	for (int i = 0; i < size; i++) {
		liste=new ArrayList<Card>(1);
		card=this.cards.get(i);
		if(Collections.frequency(cards,this.cards.get(i))==2)
		{
			count++;
			liste.add(card);
			cards.removeAll(liste);
			pairs.add(card);
			
		}
		
	}
	if(count==0)
		return null;
	pairs.sort(null);
	return getMap(count,pairs);
}
public boolean isXPairs(int x)
{
	Map<Integer,List<Card>> map=this.pairs();
	if(map==null)
		return false;
	return map.get(x)!=null;
}
public boolean isOnePair()
{
	return this.isXPairs(1);
}
public boolean isTwoPairs()
{
	return this.isXPairs(2);
}
public boolean isThreeOfAKind()
{
	return this.getCardByOccurence(3)!=null;
}
public boolean isFourOfAKind()
{
	return this.getCardByOccurence(4)!=null;
}
public boolean isFullHouse()
{
	return this.isThreeOfAKind() && this.isOnePair();
}
//switch
public Rank rank()
{
	if(this.isRoyalFlush())
		return Rank.RoyalFlush;
	if(this.isStraightFlush())
		return Rank.StraightFlush;
	if(this.isFourOfAKind())
		return Rank.FourOfaKind;
	if(this.isFullHouse())
		return Rank.FullHouse;
	if(this.isFlush())
		return Rank.Flush;
	if(this.isStraight())
		return Rank.Straight;
	if(this.isThreeOfAKind())
		return Rank.ThreeOfaKind;
	if(this.isTwoPairs())
		return Rank.TwoPairs;
	if(this.isOnePair())
	    return Rank.OnePair;
	return Rank.HighCard;
}

@Override
public int compareTo(Hand o) {
	// TODO Auto-generated method stub
	Rank rank1=this.rank();
	Rank rank2=o.rank();
	if(rank1.compareTo(rank2)>0)
		return 1;
	if(rank1.compareTo(rank2)<0)
		return -1;
	else
	{
	    Card card1=null,card2=null;
	    Map<Integer,List<Card>> map1=this.pairs();
	    Map<Integer,List<Card>> map2=o.pairs();
		boolean pair=rank1.equals(Rank.OnePair);
		boolean doublePair=rank1.equals(Rank.TwoPairs);
		
		if(pair || doublePair)
		{
			
			if(pair)
			{
				
				card1=map1.get(1).get(0);
				card2=map2.get(1).get(0);	
			}
			else
			{
				List<Card> liste1=map1.get(2),liste2=map2.get(2);
				card1=liste1.get(1);
				card2=liste2.get(1);
				if(card1.equals(card2))
				{
					card1=liste1.get(0);
					card2=liste2.get(0);
					
				}	
			}		
		}
			
		
		boolean threeOfKind=rank1.equals(Rank.ThreeOfaKind);
		boolean fullHouse=rank1.equals(Rank.FullHouse);
		if(threeOfKind || fullHouse)
		{
			card1=this.getCardByOccurence(3);
			card2=o.getCardByOccurence(3);
			if(fullHouse)
			{
				if(card1.equals(card2))
				{
					card1=map1.get(1).get(0);
					card2=map2.get(1).get(0);
				}
			}
		}
		if(rank1.equals(Rank.FourOfaKind))
		{
			card1=this.getCardByOccurence(4);
			card2=o.getCardByOccurence(4);
		}
		if(card1!=null && !card1.equals(card2))
		return card1.compareTo(card2);
			
	}
	return compareHigherCards(this, o);
}
public static Map<Integer,List<Card>> getMap(int count,List<Card> cards)
{
	Map<Integer,List<Card>> map=new HashMap<Integer,List<Card>>(1);
	map.put(count,cards);
	return map;
}
public static int compareHigherCards(Hand hand1, Hand hand2)
{
	ArrayList<Card> liste1 = new ArrayList<Card>();
	ArrayList<Card> liste2=new ArrayList<Card>();
	liste1.addAll(hand1.getCards());
	liste2.addAll(hand2.getCards());
	liste1.sort(null);
	liste2.sort(null);
	liste1.removeIf(e->e.getValue()==liste1.get(liste1.size()-1).getValue());
	liste2.removeIf(e->e.getValue()==liste2.get(liste2.size()-1).getValue());
	Card card1,card2;
	while(liste1.size()>0)
	{
		card1=liste1.get(liste1.size()-1);
		card2=liste2.get(liste2.size()-1);
		
		if(card1.compareTo(card2)>0)
			return 1;
		if(card1.compareTo(card2)<0)
			return -1;
		
		liste1.remove(card1);
		liste2.remove(card2);
		
	}
    return 0;
}

public static boolean playerOneWins(String hands)
{
	int position=14;
	String hand1=hands.substring(0,position);
	String hand2=hands.substring(position+1);
	return new Hand(hand1).compareTo(new Hand(hand2))>0;
}
}
