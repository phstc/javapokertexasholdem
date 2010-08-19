package com.cantero.games.pokertexas;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.cantero.games.pokertexas.Card;
import com.cantero.games.pokertexas.DeckFactory;

public class DeckFactoryTest extends TestCase {

	@Test
	public void testGetDeck52Size() {
		List<Card> deck = DeckFactory.getInstance().getDeck().getCards();
		assertEquals(52, deck.size());
	}

	@Test
	public void testOnlyDistinctCards() {
		List<Card> deck = DeckFactory.getInstance().getDeck().getCards();
		for (Card c1 : deck) {
			int equalsCount = 0;
			for (Card c2 : deck) {
				if (c1.equals(c2)) {
					equalsCount++;
				}
			}
			assertEquals(1, equalsCount);
		}
	}

}
