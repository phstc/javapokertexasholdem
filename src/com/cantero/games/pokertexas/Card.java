package com.cantero.games.pokertexas;

import java.io.Serializable;

public class Card implements Serializable {

	private static final long serialVersionUID = 8343990871159439035L;

	public enum CardSuitEnum {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}
	
	public enum CardRankEnum {
		CARD_2, CARD_3, CARD_4, CARD_5, CARD_6, CARD_7, CARD_8, CARD_9, CARD_10, JACK, QUEEN, KING, ACE
	}
	
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
		switch (rank) {
		case CARD_2:
			return 2;
		case CARD_3:
			return 3;
		case CARD_4:
			return 4;
		case CARD_5:
			return 5;
		case CARD_6:
			return 6;
		case CARD_7:
			return 7;
		case CARD_8:
			return 8;
		case CARD_9:
			return 9;
		case CARD_10:
			return 10;
		case JACK:
			return 11;
		case QUEEN:
			return 12;
		case KING:
			return 13;
		case ACE:
			return 14;
		}
		return null;
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
	public String toString() {
		return "Suit: " + suit.toString() + ", Rank :" + rank.toString();
	}
}
