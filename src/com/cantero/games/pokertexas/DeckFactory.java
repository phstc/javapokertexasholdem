package com.cantero.games.pokertexas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cantero.games.pokertexas.Card.CardRankEnum;
import com.cantero.games.pokertexas.Card.CardSuitEnum;

public class DeckFactory {

	public static DeckFactory getInstance() {
		return DeckFactoryHodeler.instance;
	}

	private static class DeckFactoryHodeler {
		private static DeckFactory instance = new DeckFactory();
	}

	public Deck getDeck() {
		return getDeck(new Random());
	}

	public Deck getDeck(Random random) {
		return generateDeck(random);
	}

	private Deck generateDeck(Random random) {
		List<Card> deckList = new ArrayList<Card>();
		for (CardSuitEnum s : CardSuitEnum.values()) {
			for (CardRankEnum r : CardRankEnum.values()) {
				deckList.add(new Card(s, r));
			}
		}
		return new Deck(deckList, random);
	}
}
