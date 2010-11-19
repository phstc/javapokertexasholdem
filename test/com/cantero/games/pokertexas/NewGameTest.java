package com.cantero.games.pokertexas;

import static com.cantero.games.pokertexas.CardSuitEnum.*;
import static com.cantero.games.pokertexas.CardRankEnum.*;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This class aims to provide an example of the
 * usage of the new classes Deck and CardFactory
 * instead of the old tests syntax
 * @author tesshu
 *
 */
public class NewGameTest {
	
	@Test
	public void testDrawGameTwoPlayers() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player1 = new Player();
		IPlayer player2 = new Player();
		
		List<ICard> cards = new ArrayList<ICard>();
		//Turn
		cards.add(CardFactory.getCard(SPADES, ACE));
		//River
		cards.add(CardFactory.getCard(SPADES, CARD_2));
		//Flop
		cards.add(CardFactory.getCard(SPADES, CARD_3));
		cards.add(CardFactory.getCard(SPADES, CARD_4));
		cards.add(CardFactory.getCard(SPADES, CARD_5));
		//Player2 Cards
		cards.add(CardFactory.getCard(SPADES, CARD_10));
		cards.add(CardFactory.getCard(SPADES, KING));
		//Player1 Cards
		cards.add(CardFactory.getCard(SPADES, CARD_10));
		cards.add(CardFactory.getCard(SPADES, KING));
		IDeck deck = new Deck(cards);
		
		game.newGame(deck, player1, player2);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();

		List<IPlayer> winnerList = game.getWinner();
		assertEquals(2, winnerList.size());
	}

}
