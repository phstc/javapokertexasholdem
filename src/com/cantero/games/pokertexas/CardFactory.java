package com.cantero.games.pokertexas;

public abstract class CardFactory {
	
	public static ICard getCard(CardSuitEnum suit, CardRankEnum rank) {
		return new Card(suit, rank);		
	}
	
}
