package com.cantero.games.pokertexas;

import static org.junit.Assert.assertNotNull;

import java.util.EmptyStackException;

import org.junit.Test;

public class DeckTest {

	@Test(expected = EmptyStackException.class)
	public void testCreateDeck() {
		Deck deck = new Deck();
		for (int i = 0; i < 52; i++) {
			assertNotNull(deck.pop());

		}
		//The card deck should be empty after the loop
		//Throw EmptyStackException
		deck.pop();
	}

}
