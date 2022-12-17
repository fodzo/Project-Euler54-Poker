package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import classes.Hand;



public class HandTest {
	
	@Test
	final void testCompareTo() {
		
		assertTrue(new Hand("5H 5C 6S 7S KD").compareTo(new Hand("2C 3S 8S 8D TD"))<0);
		assertTrue(new Hand("5D 8C 9S JS AC").compareTo(new Hand("2C 5C 7D 8S QH"))>0);
		assertTrue(new Hand("2D 9C AS AH AC").compareTo(new Hand("3D 6D 7D TD QD"))<0);
		assertTrue(new Hand("4D 6S 9H QH QC").compareTo(new Hand("3D 6D 7H QD QS"))>0);
		assertTrue(new Hand("2H 2D 4C 4D 4S").compareTo(new Hand("3C 3D 3S 9S 9D"))>0);
		assertTrue(new Hand("2H 2D 3C 3D 3S").compareTo(new Hand("3C 3D 3S 9S 9D"))<0);
		assertTrue(new Hand("TH TD 3C 3D 3S").compareTo(new Hand("3C 3D 3S 9S 9D"))>0);
		assertFalse(new Hand("3C 8C 2D 7D 4D").compareTo(new Hand("8S 7S 3H 2H 4D"))>0);
		assertTrue(new Hand("3C 8C 2D 7D 4D").compareTo(new Hand("8S 5S 3H 2H 4D"))>0);
		assertFalse(new Hand("3C 3H 3S 3D 4D").compareTo(new Hand("3S 3D 3H 3C TD"))>0);
		assertTrue(new Hand("3C 3H 3C 3D 4D").compareTo(new Hand("2S 2C 2H 2D TD"))>0);
		assertTrue(new Hand("3C 3H QS QD 3D").compareTo(new Hand("3S 3C QH QS 2D"))>0);
		assertFalse(new Hand("3C 3H TS TD 2D").compareTo(new Hand("3S 3H TS TH 4D"))>0);
		assertFalse(new Hand("3C 3H TS TD 2D").compareTo(new Hand("3S 3H KS KH 4D"))>0);
		assertTrue(new Hand("4C 4D TS TD 2D").compareTo(new Hand("3S 3H TS TH 4D"))>0);
		assertTrue(new Hand("4S 4C 4D TD 5D").compareTo(new Hand("4S 4C 4H TH 3D"))>0);
		assertTrue(new Hand("2H 3D 4C 5D 6S").compareTo(new Hand("4S 4C 4H TH 3D"))>0);
		assertTrue(new Hand("2H 3H 4H 5H 6H").compareTo(new Hand("4S 4C 4H TH 3D"))>0);
		assertTrue(new Hand("TH AH KH QH JH").compareTo(new Hand("4S 4C 4H TH 3D"))>0);	
	}
	
	/*
	@Test
	final void testIsFlush() {
		
		assertTrue(new Hand("2D 9D AD KD TD").isFlush());
		assertFalse(new Hand("2H 2D 4C 4D 4S").isFlush());
		
	}

	@Test
	final void testIsStraight() {
		
		assertTrue(new Hand("2H 3D 4C 5D 6S").isStraight());
		assertTrue(new Hand("2H 6D 4C 5D 3S").isStraight());
		assertFalse(new Hand("2H 3D 4C 5D TS").isStraight());
	}
	
	@Test
	final void testIsStraightFull() {
		
		assertFalse(new Hand("2H 3D 4C 5D 6S").isStraightFlush());
		assertTrue(new Hand("2H 3H 4H 5H 6H").isStraightFlush());
		assertFalse(new Hand("2H 2D 4C 5D TS").isStraightFlush());
	}
	@Test
	final void testIsRoyalFlush() {
		
		assertFalse(new Hand("2H 2D 4C 4D 4S").isRoyalFlush());
		assertTrue(new Hand("TH AH KH QH JH").isRoyalFlush());
		assertFalse(new Hand("TH AH KH QH JS").isRoyalFlush());
		assertFalse(new Hand("TS 3S KS QS JS").isRoyalFlush());
		assertFalse(new Hand("5S AS KS QS JS").isRoyalFlush());
	}

	@Test
	final void testIsOnePair() {
		
		assertTrue(new Hand("4D 6S 9H QH QC").isOnePair());
		assertFalse(new Hand("5D 8C 9S JS AC").isOnePair());
		assertFalse(new Hand("8D 8C 9S 7S 9C").isOnePair());
			
	}

	@Test
	final void testIsTwoPairs() {
		
		assertFalse(new Hand("4D 6S 9H QH QC").isTwoPairs());
		assertFalse(new Hand("5D 8C 9S JS AC").isTwoPairs());
		assertTrue(new Hand("8D 8C 9S 7S 9C").isTwoPairs());
		
	}
	
	@Test
	final void testIsXPairs() {
		
		assertFalse(new Hand("4D 6S 9H QH KC").isXPairs(1));
		}

	@Test
	final void testIsThreeOfAKind() {
		
		assertTrue(new Hand("4D 4S 2H 4H QC").isThreeOfAKind());
		assertFalse(new Hand("4D 4S 4H 4H QC").isThreeOfAKind());
		assertFalse(new Hand("4D 2S 3H KH QC").isThreeOfAKind());
	}

	@Test
	final void testIsFourOfAKind() {
		assertFalse(new Hand("4D 4S 2H 4H QC").isFourOfAKind());
		assertTrue(new Hand("4D 4S 4C 4H QC").isFourOfAKind());
		assertFalse(new Hand("4D 2S 3H KH QC").isFourOfAKind());
	}

	@Test
	final void testIsFullHouse() {
		
		assertTrue(new Hand("2H 2D 4C 4D 4S").isFullHouse());	
		assertFalse(new Hand("4D 4S 2H 4H QC").isFullHouse());
	}
5D 8C 9S JS AC
	@Test
	void testCompareHighestCards() 
	{
	  assertTrue(Hand.compareHighestCards(new Hand("5D 8C 9S JS AC"),new Hand("2C 5C 7D 8S QH"))>0);
	  assertFalse(Hand.compareHighestCards(new Hand("5H 5C 6S 7S KD"),new Hand("2C 3S 8S 8D TD"))>0);	
	}
	*/
}
