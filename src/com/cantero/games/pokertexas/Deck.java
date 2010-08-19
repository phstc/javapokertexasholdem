package com.cantero.games.pokertexas;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Deck implements Serializable {

	private static final long serialVersionUID = 2463644121163649891L;

	private List<Card> cards;
	private Random random;

	public Deck(List<Card> cards, Random random) {
		this.cards = cards;
		this.random = random;
	}

	public List<Card> getCards() {
		return cards;
	}

	public Integer size() {
		return cards.size();
	}

	public Card pop() {
		return cards.remove(random.nextInt(cards.size()));
	}
}
