package com.cantero.games.poker.texasholdem;

import static com.cantero.games.poker.texasholdem.CardRankEnum.*;
import static com.cantero.games.poker.texasholdem.CardSuitEnum.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.cantero.games.poker.texasholdem.Card;

public class CardTest extends TestCase {

	@Test
	public void testGetRankToInt() {

	}

	@Test
	public void testEquals() {
		// Same instance
		Card cardA = new Card(SPADES, CARD_2);
		assertEquals(cardA, cardA);
		assertEquals(cardA.hashCode(), cardA.hashCode());
		// Same suit and rank
		Card cardB = new Card(SPADES, CARD_2);
		assertEquals(cardA, cardB);
		assertEquals(cardA.hashCode(), cardB.hashCode());
		// Different rank
		Card cardC = new Card(SPADES, CARD_3);
		assertFalse(cardA.equals(cardC));
		assertFalse(cardA.hashCode() == cardC.hashCode());
		// Different suit
		Card cardD = new Card(CLUBS, CARD_2);
		assertFalse(cardA.equals(cardD));
		assertFalse(cardA.hashCode() == cardD.hashCode());
		// Different suit and rank
		Card cardE = new Card(HEARTS, KING);
		assertFalse(cardA.equals(cardE));
		assertFalse(cardA.hashCode() == cardE.hashCode());
	}
}
