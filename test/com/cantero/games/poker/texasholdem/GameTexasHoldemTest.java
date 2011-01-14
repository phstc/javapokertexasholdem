package com.cantero.games.poker.texasholdem;

import static com.cantero.games.poker.texasholdem.CardRankEnum.*;
import static com.cantero.games.poker.texasholdem.CardSuitEnum.*;
import static com.cantero.games.poker.texasholdem.RankingEnum.*;
import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.cantero.games.poker.texasholdem.Card;
import com.cantero.games.poker.texasholdem.Deck;
import com.cantero.games.poker.texasholdem.GameTexasHoldem;
import com.cantero.games.poker.texasholdem.IPlayer;
import com.cantero.games.poker.texasholdem.Player;

public class GameTexasHoldemTest {

	@Test
	public void testDrawGameFourPlayers() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player1 = new Player();
		IPlayer player2 = new Player();
		IPlayer player3 = new Player();
		IPlayer player4 = new Player();
		game.newGame(new Deck(), player1, player2, player3, player4);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		game.getTableCards().add(new Card(SPADES, ACE));
		player1.getCards()[0] = new Card(DIAMONDS, CARD_2);
		player1.getCards()[1] = new Card(SPADES, CARD_3);
		player2.getCards()[0] = new Card(CLUBS, CARD_2);
		player2.getCards()[1] = new Card(HEARTS, CARD_3);
		player3.getCards()[0] = new Card(SPADES, CARD_2);
		player3.getCards()[1] = new Card(DIAMONDS, CARD_3);
		player4.getCards()[0] = new Card(HEARTS, CARD_2);
		player4.getCards()[1] = new Card(CLUBS, CARD_3);
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(4, winnerList.size());
	}

	@Test
	public void testDrawGameTwoPlayers() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		game.getTableCards().add(new Card(SPADES, ACE));
		dealer.getCards()[0] = new Card(DIAMONDS, CARD_2);
		dealer.getCards()[1] = new Card(SPADES, CARD_2);
		player.getCards()[0] = new Card(CLUBS, CARD_2);
		player.getCards()[1] = new Card(HEARTS, CARD_2);
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(2, winnerList.size());
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void testPlayerWinDrawGameBestRanking() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		game.getTableCards().add(new Card(SPADES, ACE));
		dealer.getCards()[0] = new Card(CLUBS, CARD_10);
		dealer.getCards()[1] = new Card(HEARTS, CARD_2);
		player.getCards()[0] = new Card(CLUBS, CARD_2);
		player.getCards()[1] = new Card(HEARTS, ACE);
		//assertEquals(GameEnum.PLAYER_WINNER_BEST_RANKING, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void testDealerWinDrawGameHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		dealer.getCards()[0] = new Card(CLUBS, CARD_10);
		dealer.getCards()[1] = new Card(HEARTS, ACE);
		player.getCards()[0] = new Card(CLUBS, CARD_2);
		player.getCards()[1] = new Card(HEARTS, CARD_10);
		//assertEquals(GameEnum.DEALER_WINNER_HIGH_CARD, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void testDealerWinStraighFlush() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player1 = new Player();
		IPlayer player2 = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player1, player2, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_3));
		game.getTableCards().add(new Card(SPADES, CARD_4));
		game.getTableCards().add(new Card(SPADES, CARD_5));
		game.getTableCards().add(new Card(CLUBS, QUEEN));
		dealer.getCards()[0] = new Card(SPADES, CARD_6);
		dealer.getCards()[1] = new Card(SPADES, CARD_7);
		player1.getCards()[0] = new Card(SPADES, CARD_10);
		player1.getCards()[1] = new Card(DIAMONDS, CARD_10);
		player2.getCards()[0] = new Card(SPADES, CARD_2);
		player2.getCards()[1] = new Card(DIAMONDS, CARD_2);
		//assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(STRAIGHT_FLUSH, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player1.getRankingEnum());
	}

	@Test
	public void testPlayerWinFourOfAKind() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_3));
		game.getTableCards().add(new Card(SPADES, CARD_4));
		game.getTableCards().add(new Card(HEARTS, CARD_10));
		game.getTableCards().add(new Card(CLUBS, CARD_10));
		dealer.getCards()[0] = new Card(SPADES, ACE);
		dealer.getCards()[1] = new Card(SPADES, CARD_2);
		player.getCards()[0] = new Card(SPADES, CARD_10);
		player.getCards()[1] = new Card(DIAMONDS, CARD_10);
		//assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(FOUR_OF_A_KIND, player.getRankingEnum());
	}

	@Test
	public void testDealerWinFullHouse() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_3));
		game.getTableCards().add(new Card(SPADES, CARD_4));
		game.getTableCards().add(new Card(HEARTS, CARD_10));
		game.getTableCards().add(new Card(CLUBS, CARD_10));
		dealer.getCards()[0] = new Card(HEARTS, CARD_3);
		dealer.getCards()[1] = new Card(CLUBS, CARD_3);
		player.getCards()[0] = new Card(SPADES, CARD_10);
		player.getCards()[1] = new Card(SPADES, CARD_2);
		//assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(FULL_HOUSE, dealer.getRankingEnum());
		assertEquals(THREE_OF_A_KIND, player.getRankingEnum());
	}

	@Test
	public void testPlayerWinFlush() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_3));
		game.getTableCards().add(new Card(SPADES, CARD_4));
		game.getTableCards().add(new Card(SPADES, CARD_7));
		dealer.getCards()[0] = new Card(HEARTS, CARD_5);
		dealer.getCards()[1] = new Card(CLUBS, CARD_6);
		player.getCards()[0] = new Card(SPADES, CARD_10);
		player.getCards()[1] = new Card(SPADES, CARD_2);
		//assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(STRAIGHT, dealer.getRankingEnum());
		assertEquals(FLUSH, player.getRankingEnum());
	}

	@Test
	public void testDealerWinStraight() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_3));
		game.getTableCards().add(new Card(SPADES, CARD_4));
		game.getTableCards().add(new Card(SPADES, CARD_7));
		dealer.getCards()[0] = new Card(HEARTS, CARD_5);
		dealer.getCards()[1] = new Card(CLUBS, CARD_6);
		player.getCards()[0] = new Card(CLUBS, CARD_10);
		player.getCards()[1] = new Card(HEARTS, CARD_10);
		//assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(STRAIGHT, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void testDealerWinThreeOfAKind() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		game.getTableCards().add(new Card(SPADES, ACE));
		dealer.getCards()[0] = new Card(HEARTS, ACE);
		dealer.getCards()[1] = new Card(CLUBS, ACE);
		player.getCards()[0] = new Card(CLUBS, CARD_6);
		player.getCards()[1] = new Card(HEARTS, QUEEN);
		//assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(THREE_OF_A_KIND, dealer.getRankingEnum());
		assertEquals(HIGH_CARD, player.getRankingEnum());
	}

	@Test
	public void testPlayerWinTwoPair() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		game.getTableCards().add(new Card(SPADES, ACE));
		dealer.getCards()[0] = new Card(HEARTS, CARD_10);
		dealer.getCards()[1] = new Card(HEARTS, QUEEN);
		player.getCards()[0] = new Card(CLUBS, CARD_10);
		player.getCards()[1] = new Card(HEARTS, ACE);
		//assertEquals(GameEnum.PLAYER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(TWO_PAIR, player.getRankingEnum());
	}

	@Test
	public void testDealerWinOnePair() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_10));
		dealer.getCards()[0] = new Card(CLUBS, CARD_10);
		dealer.getCards()[1] = new Card(HEARTS, CARD_7);
		player.getCards()[0] = new Card(CLUBS, ACE);
		player.getCards()[1] = new Card(HEARTS, QUEEN);
		//assertEquals(GameEnum.DEALER_WINNER, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(dealer, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(HIGH_CARD, player.getRankingEnum());
	}

	@Test
	public void testDrawGameOnePairDealerWinSecondHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(DIAMONDS, CARD_6));
		game.getTableCards().add(new Card(CLUBS, QUEEN));
		game.getTableCards().add(new Card(DIAMONDS, CARD_9));
		game.getTableCards().add(new Card(DIAMONDS, ACE));
		game.getTableCards().add(new Card(CLUBS, CARD_6));
		dealer.getCards()[0] = new Card(DIAMONDS, CARD_10);
		Card highCardDealer = new Card(SPADES, CARD_2);
		dealer.getCards()[1] = highCardDealer;
		player.getCards()[0] = new Card(HEARTS, CARD_10);
		Card highCardPlayer = new Card(SPADES, CARD_3);
		player.getCards()[1] = highCardPlayer;
		//assertEquals(GameEnum.PLAYER_WINNER_HIGH_CARD, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(ONE_PAIR, dealer.getRankingEnum());
		assertEquals(ONE_PAIR, player.getRankingEnum());
		assertEquals(highCardPlayer, player.getHighCard());
		assertEquals(highCardDealer, dealer.getHighCard());
	}

	@Test
	public void testPlayerWinHighCard() {
		//Basic tests
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		game.newGame(new Deck(), player, dealer);
		game.deal();
		game.callFlop();
		game.betRiver();
		game.betTurn();
		game.getTableCards().clear();
		game.getTableCards().add(new Card(SPADES, CARD_4));
		dealer.getCards()[0] = new Card(CLUBS, CARD_10);
		dealer.getCards()[1] = new Card(HEARTS, CARD_7);
		player.getCards()[0] = new Card(CLUBS, ACE);
		player.getCards()[1] = new Card(HEARTS, QUEEN);
		//assertEquals(GameEnum.PLAYER_WINNER_BEST_RANKING, game.getWinner());
		List<IPlayer> winnerList = game.getWinner();
		assertEquals(1, winnerList.size());
		assertEquals(player, winnerList.get(0));
		assertEquals(HIGH_CARD, dealer.getRankingEnum());
		assertEquals(HIGH_CARD, player.getRankingEnum());
	}
}
