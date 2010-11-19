package com.cantero.games.pokertexas;

import java.io.Serializable;

public class Card implements ICard, Serializable {

	private static final long serialVersionUID = 8343990871159439035L;

	private CardSuitEnum suit;
	private CardRankEnum rank;

	public Card(CardSuitEnum suit, CardRankEnum rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see com.cantero.games.pokertexas.ICard#getSuit()
	 */
	public CardSuitEnum getSuit() {
		return suit;
	}

	/* (non-Javadoc)
	 * @see com.cantero.games.pokertexas.ICard#getRank()
	 */
	public CardRankEnum getRank() {
		return rank;
	}

	/* (non-Javadoc)
	 * @see com.cantero.games.pokertexas.ICard#getRankToInt()
	 */
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
			ICard card2 = (ICard) obj;
			return rank.equals(card2.getRank()) && suit.equals(card2.getSuit());
		}
	}

	@Override
	public String toString() {
		return "Suit: " + suit.toString() + ", Rank :" + rank.toString();
	}
}
