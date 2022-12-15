package main.java.classes;

import main.java.enums.CardValue;
import main.java.enums.Suit;

public class Card implements Comparable<Card>{
private CardValue value;
private Suit suit;
@Override
public int compareTo(Card o) {
	// TODO Auto-generated method stub
	return this.value.ordinal()-o.value.ordinal();
}
/**
 * @return the value
 */
public CardValue getValue() {
	return value;
}
/**
 * @param value the value to set
 */
public void setValue(CardValue value) {
	this.value = value;
}
/**
 * @return the suit
 */
public Suit getSuit() {
	return suit;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Card other = (Card) obj;
	return value.equals(other.getValue());
	
}
/**
 * @param suit the suit to set
 */
public void setSuit(Suit suit) {
	this.suit = suit;
}
public Card(CardValue value, Suit suit) {
	super();
	this.value = value;
	this.suit = suit;
}

}
