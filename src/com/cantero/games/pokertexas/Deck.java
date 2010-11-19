package com.cantero.games.pokertexas;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck implements IDeck, Serializable {

	private static final long serialVersionUID = 2463644121163649891L;

	private Stack<ICard> cards;
	
	public Deck() {
		cards = new Stack<ICard>();
		for (CardSuitEnum suit : CardSuitEnum.values()) {
			for (CardRankEnum rank : CardRankEnum.values()) {
				cards.push(CardFactory.getCard(suit, rank));
			}
		}
		Collections.shuffle(cards);
	}
	
	/**
	 * Constructor for tests, where a specific order is needed
	 * @param cards the cards of the deck
	 */
	public Deck(List<ICard> cards) {
		this.cards = new Stack<ICard>();
		this.cards.addAll(cards);
	}

	@Deprecated
	public Deck(Random random) {
		createDeck();
	}

	@Deprecated
	private void createDeck() {
		cards = new Stack<ICard>();
		for (CardSuitEnum suit : CardSuitEnum.values()) {
			for (CardRankEnum rank : CardRankEnum.values()) {
				cards.add(CardFactory.getCard(suit, rank));
			}
		}
	}

	public ICard pop() {
		return cards.pop();
	}
}
