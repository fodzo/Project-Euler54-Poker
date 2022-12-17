package classes;

import enums.CardValue;
import enums.Suit;

public class Card implements Comparable<Card>{
private CardValue value;
private Suit suit;
@Override
public int compareTo(Card o) {
	// TODO Auto-generated method stub
	return this.value.ordinal()-o.value.ordinal();
}

public CardValue getValue() {
	return value;
}

public void setValue(CardValue value) {
	this.value = value;
}

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

public void setSuit(Suit suit) {
	this.suit = suit;
}
public Card(CardValue value, Suit suit) {
	super();
	this.value = value;
	this.suit = suit;
}

}
