package com.cantero.games.pokertexas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cantero.games.pokertexas.Card.CardRankEnum;
import com.cantero.games.pokertexas.Card.CardSuitEnum;

public class Deck implements IDeck, Serializable {

	private static final long serialVersionUID = 2463644121163649891L;

	private List<Card> cards;
	private Random random;

	public Deck() {
		this(new Random());
	}

	public Deck(Random random) {
		this.random = random;
		createDeck();
	}

	private void createDeck() {
		cards = new ArrayList<Card>();
		for (CardSuitEnum suit : Card.CardSuitEnum.values()) {
			for (CardRankEnum rank : Card.CardRankEnum.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public Card pop() {
		return cards.remove(random.nextInt(cards.size()));
	}
}
