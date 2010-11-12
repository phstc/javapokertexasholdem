package com.cantero.games.pokertexas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DeckTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCreateDeck() {
		Deck deck = new Deck();
		for (int i = 0; i < 52; i++) {
			assertNotNull(deck.pop());

		}
		//The card.size should be 0 after the loop
		//Throw IllegalArgumentException(n must be positive)
		deck.pop();
	}

}
