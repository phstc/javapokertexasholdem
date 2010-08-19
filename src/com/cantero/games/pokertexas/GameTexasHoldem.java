package com.cantero.games.pokertexas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.cantero.games.pokertexas.RankingUtil.RankingEnum;

public class GameTexasHoldem implements Serializable {

	private static final long serialVersionUID = 967261359515323981L;

	public enum GameEnum {
		PLAYER_WINNER, DEALER_WINNER, DRAW_GAME, PLAYER_WINNER_BEST_RANKING, DEALER_WINNER_BEST_RANKING, PLAYER_WINNER_HIGH_CARD, DEALER_WINNER_HIGH_CARD
	}

	private Random random;

	private Deck deck;

	private Player player;

	private Player dealer;

	private List<Card> tableCards;

	public GameTexasHoldem(Random random) {
		this.random = random;
	}

	public GameTexasHoldem() {
		this(new Random());
	}

	public void newGame(Deck deck) {
		this.deck = deck;
		tableCards = new ArrayList<Card>();
		dealer = new Player();
		player = new Player();
	}

	public void newGame() {
		deck = DeckFactory.getInstance().getDeck(random);
		newGame(deck);
	}

	public void endGame() {
		deck = null;
		tableCards = null;
		player = null;
		dealer = null;
	}

	public void deal() {
		Assert.assertTrue(deck != null, "First call game.newGame()");
		player.getCards()[0] = deck.pop();
		player.getCards()[1] = deck.pop();
		dealer.getCards()[0] = deck.pop();
		dealer.getCards()[1] = deck.pop();
		checkPlayerAndDealerRanking();
	}

	/**
	 * doble initial bet
	 */
	public void callFlop() {
		Assert.assertTrue(deck.size() != 52, "First call game.deal()");
		deck.pop();
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		checkPlayerAndDealerRanking();
	}

	public void betTurn() {
		Assert.assertTrue(deck.size() != 48, "First call game.callFlop()");
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayerAndDealerRanking();
	}

	public void betRiver() {
		Assert.assertTrue(deck.size() != 46, "First call game.betRiver()");
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayerAndDealerRanking();
	}

	public GameEnum getWinner() {
		checkPlayerAndDealerRanking();
		Integer playerRank = RankingUtil.getRankingToInt(player);
		Integer dealerRank = RankingUtil.getRankingToInt(dealer);

		//Draw game
		if (playerRank == dealerRank) {
			//Si no es Flush/Color, prueba quien tiene la secuencia, pareja o trio m‡s grande,
			//antes de probar la carta m‡s grande
			if (player.getRankingEnum() != RankingEnum.FLUSH) {
				GameEnum result = checkHighSequence(playerRank, dealerRank);
				if (result != null) {
					return result;
				}
			}
			if (playerRank == dealerRank) {
				GameEnum result = checkHighCardWinner();
				if (result != null) {
					return result;
				}
			}
		}

		if (playerRank > dealerRank) {
			return GameEnum.PLAYER_WINNER;
		}

		if (playerRank < dealerRank) {
			return GameEnum.DEALER_WINNER;
		}

		return GameEnum.DRAW_GAME;
	}

	private GameEnum checkHighSequence(Integer playerRank, Integer dealerRank) {
		playerRank = sumRankingList(player);
		dealerRank = sumRankingList(dealer);
		if (playerRank > dealerRank) {
			return GameEnum.PLAYER_WINNER_BEST_RANKING;
		}
		if (playerRank < dealerRank) {
			return GameEnum.DEALER_WINNER_BEST_RANKING;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private GameEnum checkHighCardWinner() {
		GameEnum result = compareHighCard(player.getHighCard(), dealer
				.getHighCard());
		if (result == null) {
			Card playerCard = RankingUtil.getHighCard(player,
					Collections.EMPTY_LIST);
			Card dealerCard = RankingUtil.getHighCard(dealer,
					Collections.EMPTY_LIST);
			result = compareHighCard(playerCard, dealerCard);
			if (result != null) {
				player.setHighCard(playerCard);
				dealer.setHighCard(dealerCard);
			}
			if (result == null) {
				playerCard = getSecondHighCard(player, playerCard);
				dealerCard = getSecondHighCard(dealer, dealerCard);
				result = compareHighCard(playerCard, dealerCard);
				if (result != null) {
					player.setHighCard(playerCard);
					dealer.setHighCard(dealerCard);
				}
			}
		}
		return result;
	}

	private GameEnum compareHighCard(Card playerCard, Card dealerCard) {
		if (playerCard.getRankToInt() > dealerCard.getRankToInt()) {
			return GameEnum.PLAYER_WINNER_HIGH_CARD;
		}
		if (playerCard.getRankToInt() < dealerCard.getRankToInt()) {
			return GameEnum.DEALER_WINNER_HIGH_CARD;
		}
		return null;
	}

	private Card getSecondHighCard(Player player, Card card) {
		if (player.getCards()[0].equals(card)) {
			return player.getCards()[1];
		}
		return player.getCards()[0];
	}

	public Player getPlayer() {
		return player;
	}

	public Player getDealer() {
		return dealer;
	}

	public List<Card> getTableCards() {
		return tableCards;
	}

	private Integer sumRankingList(Player player) {
		Integer sum = 0;
		for (Card card : player.getRankingList()) {
			sum += card.getRankToInt();
		}
		return sum;
	}

	private void checkPlayerAndDealerRanking() {
		RankingUtil.checkRanking(player, tableCards);
		RankingUtil.checkRanking(dealer, tableCards);
	}
}
