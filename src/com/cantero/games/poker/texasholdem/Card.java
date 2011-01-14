package com.cantero.games.poker.texasholdem;

import java.io.Serializable;


public class Card implements Serializable {

	private static final long serialVersionUID = 8343990871159439035L;

	private CardSuitEnum suit;
	private CardRankEnum rank;

	public Card(CardSuitEnum suit, CardRankEnum rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public CardSuitEnum getSuit() {
		return suit;
	}

	public CardRankEnum getRank() {
		return rank;
	}

	public Integer getRankToInt() {
		return rank.ordinal();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (!(obj instanceof Card)) {
			return false;
		} else {
			Card card2 = (Card) obj;
			return rank.equals(card2.getRank()) && suit.equals(card2.getSuit());
		}
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(String.valueOf(rank.ordinal())
				+ String.valueOf(suit.ordinal()));
	}

	@Override
	public String toString() {
		return "Suit: " + suit.toString() + ", Rank :" + rank.toString();
	}
}
