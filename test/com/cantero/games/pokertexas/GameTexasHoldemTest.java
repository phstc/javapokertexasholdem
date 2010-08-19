package com.cantero.games.pokertexas;

import junit.framework.TestCase;

import org.junit.Test;

import com.cantero.games.pokertexas.Card;
import com.cantero.games.pokertexas.GameTexasHoldem;
import com.cantero.games.pokertexas.Card.CardRankEnum;
import com.cantero.games.pokertexas.Card.CardSuitEnum;
import com.cantero.games.pokertexas.GameTexasHoldem.GameEnum;
import com.cantero.games.pokertexas.RankingUtil.RankingEnum;

public class GameTexasHoldemTest extends TestCase {

	@Test
	public void testPlayerWinDrawGameBestRanking() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.ACE));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_2);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_2);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.ACE);

		assertEquals(GameEnum.PLAYER_WINNER_BEST_RANKING, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.ONE_PAIR, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDealerWinDrawGameHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.ACE);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_2);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_10);

		assertEquals(GameEnum.DEALER_WINNER_HIGH_CARD, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.ONE_PAIR, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDealerWinStraighFlush() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_5));
		game.getTableCards().add(
				new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_6);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_7);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);

		assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		assertEquals(RankingEnum.STRAIGHT_FLUSH, game.getDealer()
				.getRankingEnum());
		assertEquals(RankingEnum.ONE_PAIR, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testPlayerWinFourOfAKind() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
		game.getTableCards().add(
				new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		game.getTableCards().add(
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.ACE);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_2);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);

		assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.FOUR_OF_A_KIND, game.getPlayer()
				.getRankingEnum());
	}

	@Test
	public void testDealerWinFullHouse() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
		game.getTableCards().add(
				new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		game.getTableCards().add(
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_3);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_3);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_2);

		assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		assertEquals(RankingEnum.FULL_HOUSE, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.THREE_OF_A_KIND, game.getPlayer()
				.getRankingEnum());
	}

	@Test
	public void testPlayerWinFlush() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_7));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_5);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_6);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_2);

		assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		assertEquals(RankingEnum.STRAIGHT, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.FLUSH, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDealerWinStraight() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_7));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_5);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_6);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_10);

		assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		assertEquals(RankingEnum.STRAIGHT, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.ONE_PAIR, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDealerWinThreeOfAKind() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.ACE));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.ACE);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.ACE);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_6);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.QUEEN);

		assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		assertEquals(RankingEnum.THREE_OF_A_KIND, game.getDealer()
				.getRankingEnum());
		assertEquals(RankingEnum.HIGH_CARD, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testPlayerWinTwoPair() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.ACE));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_10);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.QUEEN);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.ACE);

		assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.TWO_PAIR, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDealerWinOnePair() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_7);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.ACE);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.QUEEN);

		assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.HIGH_CARD, game.getPlayer().getRankingEnum());
	}

	@Test
	public void testDrawGameOnePairDealerWinSecondHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();

		game.getTableCards().add(
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_6));
		game.getTableCards().add(
				new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));
		game.getTableCards().add(
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_9));
		game.getTableCards().add(
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.ACE));
		game.getTableCards().add(
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_6));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		Card highCardDealer = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_2);
		game.getDealer().getCards()[1] = highCardDealer;

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_10);
		Card highCardPlayer = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3);
		game.getPlayer().getCards()[1] = highCardPlayer;

		assertEquals(GameEnum.PLAYER_WINNER_HIGH_CARD, game.getWinner());
		assertEquals(RankingEnum.ONE_PAIR, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.ONE_PAIR, game.getPlayer().getRankingEnum());
		assertEquals(highCardPlayer, game.getPlayer().getHighCard());
		assertEquals(highCardDealer, game.getDealer().getHighCard());
	}

	@Test
	public void testPlayerWinHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		game.newGame();
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(
				new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));

		game.getDealer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		game.getDealer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_7);

		game.getPlayer().getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.ACE);
		game.getPlayer().getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.QUEEN);

		assertEquals(GameEnum.PLAYER_WINNER_BEST_RANKING, game.getWinner());
		assertEquals(RankingEnum.HIGH_CARD, game.getDealer().getRankingEnum());
		assertEquals(RankingEnum.HIGH_CARD, game.getPlayer().getRankingEnum());
	}
}
