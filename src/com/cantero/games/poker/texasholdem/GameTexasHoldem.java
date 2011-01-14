package com.cantero.games.poker.texasholdem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameTexasHoldem implements Serializable {

	private static final long serialVersionUID = 967261359515323981L;

	private IDeck deck;

	private List<IPlayer> players;

	private List<Card> tableCards;

	public void newGame(IDeck deck, IPlayer player1, IPlayer... _players) {
		this.deck = deck;
		tableCards = new ArrayList<Card>();
		players = new ArrayList<IPlayer>();
		//the game needs at least one player
		players.add(player1);
		players.addAll(Arrays.asList(_players));
	}

	//To abandon the game
	public void removePlayer(IPlayer player) {
		players.remove(player);
	}

	public void deal() {
		for (IPlayer player : players) {
			player.getCards()[0] = deck.pop();
			player.getCards()[1] = deck.pop();
		}
		checkPlayersRanking();
	}

	/**
	 * doble initial bet
	 */
	public void callFlop() {
		deck.pop();
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		checkPlayersRanking();
	}

	public void betTurn() {
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayersRanking();
	}

	public void betRiver() {
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayersRanking();
	}

	public List<IPlayer> getWinner() {
		checkPlayersRanking();
		List<IPlayer> winnerList = new ArrayList<IPlayer>();
		IPlayer winner = players.get(0);
		Integer winnerRank = RankingUtil.getRankingToInt(winner);
		winnerList.add(winner);
		for (int i = 1; i < players.size(); i++) {
			IPlayer player = players.get(i);
			Integer playerRank = RankingUtil.getRankingToInt(player);
			//Draw game
			if (winnerRank == playerRank) {
				IPlayer highHandPlayer = checkHighSequence(winner, player);
				//Draw checkHighSequence
				if (highHandPlayer == null) {
					highHandPlayer = checkHighCardWinner(winner, player);
				}
				//Not draw in checkHighSequence or checkHighCardWinner
				if (highHandPlayer != null && !winner.equals(highHandPlayer)) {
					winner = highHandPlayer;
					winnerList.clear();
					winnerList.add(winner);
				} else if (highHandPlayer == null) {
					//Draw in checkHighSequence and checkHighCardWinner
					winnerList.add(winner);
				}
			} else if (winnerRank < playerRank) {
				winner = player;
				winnerList.clear();
				winnerList.add(winner);
			}
			winnerRank = RankingUtil.getRankingToInt(winner);
		}

		return winnerList;
	}

	private IPlayer checkHighSequence(IPlayer player1, IPlayer player2) {
		Integer player1Rank = sumRankingList(player1);
		Integer player2Rank = sumRankingList(player2);
		if (player1Rank > player2Rank) {
			return player1;
		} else if (player1Rank < player2Rank) {
			return player2;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private IPlayer checkHighCardWinner(IPlayer player1, IPlayer player2) {
		IPlayer winner = compareHighCard(player1, player1.getHighCard(),
				player2, player2.getHighCard());
		if (winner == null) {
			Card player1Card = RankingUtil.getHighCard(player1,
					Collections.EMPTY_LIST);
			Card player2Card = RankingUtil.getHighCard(player2,
					Collections.EMPTY_LIST);
			winner = compareHighCard(player1, player1Card, player2, player2Card);
			if (winner != null) {
				player1.setHighCard(player1Card);
				player2.setHighCard(player2Card);
			} else if (winner == null) {
				player1Card = getSecondHighCard(player1, player1Card);
				player2Card = getSecondHighCard(player2, player2Card);
				winner = compareHighCard(player1, player1Card, player2,
						player2Card);
				if (winner != null) {
					player1.setHighCard(player1Card);
					player2.setHighCard(player2Card);
				}
			}
		}
		return winner;
	}

	private IPlayer compareHighCard(IPlayer player1, Card player1HighCard,
			IPlayer player2, Card player2HighCard) {
		if (player1HighCard.getRankToInt() > player2HighCard.getRankToInt()) {
			return player1;
		} else if (player1HighCard.getRankToInt() < player2HighCard
				.getRankToInt()) {
			return player2;
		}
		return null;
	}

	/*
	 * TODO This method must be moved to RankingUtil
	 */
	private Card getSecondHighCard(IPlayer player, Card card) {
		if (player.getCards()[0].equals(card)) {
			return player.getCards()[1];
		}
		return player.getCards()[0];
	}

	public List<Card> getTableCards() {
		return tableCards;
	}

	/*
	 * TODO This method must be moved to RankingUtil
	 */
	private Integer sumRankingList(IPlayer player) {
		Integer sum = 0;
		for (Card card : player.getRankingList()) {
			sum += card.getRankToInt();
		}
		return sum;
	}

	private void checkPlayersRanking() {
		for (IPlayer player : players) {
			RankingUtil.checkRanking(player, tableCards);
		}
	}
}
