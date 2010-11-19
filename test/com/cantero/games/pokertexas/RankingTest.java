package com.cantero.games.pokertexas;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import static com.cantero.games.pokertexas.CardRankEnum.*;
import static com.cantero.games.pokertexas.CardSuitEnum.*;
import static com.cantero.games.pokertexas.RankingEnum.*;

/**
 * Switched fixed integers to enum ordinal values, so the check
 * doesn't get fixed to the implementation details
 * @author tesshu
 *
 */
public class RankingTest extends TestCase {

	/*
	 * 	ROYAL_FLUSH >
	 *	STRAIGHT_FLUSH >
	 *	FOUR_OF_A_KIND >
	 *	FULL_HOUSE >
	 *	FLUSH >
	 *	STRAIGHT >
	 *	THREE_OF_A_KIND >
	 *	TWO_PAIR >
	 *	ONE_PAIR >
	 *	HIGH_CARD
	 */
	@Test
	public void testCheckRoyalFlush() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setRoyalFlush(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(ROYAL_FLUSH, playerRank);
//		assertEquals(RankingUtil.getRoyalFlush(player, tableCards), player
//				.getRankingList());
		assertTrue(STRAIGHT_FLUSH.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckStraightFlush() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setStraightFlush(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(STRAIGHT_FLUSH, playerRank);
//		assertEquals(RankingUtil.getStraightFlush(player, tableCards), player
//				.getRankingList());
		assertTrue(FOUR_OF_A_KIND.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFourOfAKind() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setFourOfAKind(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(FOUR_OF_A_KIND, playerRank);
//		assertEquals(RankingUtil.getFourOfAKind(player, tableCards), player
//				.getRankingList());
		assertTrue(FULL_HOUSE.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFullHouse() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setFullHouse(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(FULL_HOUSE, playerRank);
//		assertEquals(RankingUtil.getFullHouse(player, tableCards), player
//				.getRankingList());
		assertTrue(FLUSH.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFlush() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setFlush(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(FLUSH, playerRank);
//		assertEquals(RankingUtil.getFlush(player, tableCards), player
//				.getRankingList());
		assertTrue(STRAIGHT.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckStraight() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setStraight(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(STRAIGHT, playerRank);
//		assertEquals(RankingUtil.getStraight(player, tableCards), player
//				.getRankingList());
		assertTrue(THREE_OF_A_KIND.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckThreeOfAKind() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setThreeOfAKind(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(THREE_OF_A_KIND, playerRank);
//		assertEquals(RankingUtil.getThreeOfAKind(player, tableCards), player
//				.getRankingList());
		assertTrue(TWO_PAIR.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckTwoPair() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setTwoPair(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(TWO_PAIR, playerRank);
//		assertEquals(RankingUtil.getTwoPair(player, tableCards), player
//				.getRankingList());
		assertTrue(ONE_PAIR.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckOnePair() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setOnePair(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(ONE_PAIR, playerRank);
//		assertEquals(RankingUtil.getOnePair(player, tableCards), player
//				.getRankingList());
		assertTrue(HIGH_CARD.ordinal() < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckHighCard() {
		List<ICard> tableCards = new ArrayList<ICard>();
		Player player = new Player();
		setHighCard(player, tableCards);
		RankingEnum playerRank = RankingUtil.checkRanking(player.getHand());
		assertEquals(HIGH_CARD, playerRank);
//		assertEquals(RankingUtil.getHighCard(player, tableCards), player
//				.getRankingList().get(0));
		assertTrue(-1 < playerRank.ordinal()); //RankingUtil.getRankingToInt(player));
	}

//	@Test
//	public void testIsRoyalFlush() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setRoyalFlush(player, tableCards);
//
//		List<ICard> royalFlushList = new ArrayList<ICard>();
//		royalFlushList.addAll(tableCards);
//		royalFlushList.add(player.getCards()[0]);
//		royalFlushList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getRoyalFlush(player, tableCards);
////		assertTrue(isSameCardList(royalFlushList, result));
//	}
//
//	@Test
//	public void testIsRoyalFlushNotSequence() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
//
//		List<ICard> royalFlushList = new ArrayList<ICard>();
//		royalFlushList.addAll(tableCards);
//		royalFlushList.add(player.getCards()[0]);
//		royalFlushList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getRoyalFlush(player, tableCards);
////		assertTrue(isSameCardList(royalFlushList, result));
//	}
//
//	@Test
//	public void testIsNotRoyalFlushNotSameSuit() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE);
//		player.getCards()[1] = new Card(CardSuitEnum.HEARTS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
//		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
//		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));
//
////		assertNull(RankingUtil.getRoyalFlush(player, tableCards));
//	}
//
//	@Test
//	public void testIsStraightFlush() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setStraightFlush(player, tableCards);
//
//		List<ICard> straightFlushList = new ArrayList<ICard>();
//		straightFlushList.addAll(tableCards);
//		straightFlushList.add(player.getCards()[0]);
//		straightFlushList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getStraightFlush(player, tableCards);
////		assertTrue(isSameCardList(straightFlushList, result));
//	}
//
//	@Test
//	public void testIsStraightFlushNotSequence() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_8));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_6));
//
////		assertNull(RankingUtil.getStraightFlush(player, tableCards));
//	}
//
//	@Test
//	public void testIsNotStraightFlushNoSameSuit() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5));
//		tableCards.add(new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_6));
//
////		assertNull(RankingUtil.getStraightFlush(player, tableCards));
//	}
//
//	@Test
//	public void testIsFourOfAKind() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setFourOfAKind(player, tableCards);
//
//		List<ICard> fourOfAKindList = new ArrayList<ICard>();
//		fourOfAKindList.add(tableCards.get(0));
//		fourOfAKindList.add(tableCards.get(2));
//		fourOfAKindList.add(player.getCards()[0]);
//		fourOfAKindList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getFourOfAKind(player, tableCards);
////		assertTrue(isSameCardList(fourOfAKindList, result));
//	}
//
//	@Test
//	public void testIsNotFourOfAKind() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
//				CardRankEnum.CARD_10);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
//		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.KING));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
//
////		assertNull(RankingUtil.getFourOfAKind(player, tableCards));
//	}
//
//	@Test
//	public void testIsFullHouse() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setFullHouse(player, tableCards);
//
//		List<ICard> fullHouseList = new ArrayList<ICard>();
//		fullHouseList.add(player.getCards()[0]);
//		fullHouseList.add(tableCards.get(1));
//		fullHouseList.add(tableCards.get(2));
//		fullHouseList.add(player.getCards()[1]);
//		fullHouseList.add(tableCards.get(0));
//
////		List<ICard> result = RankingUtil.getFullHouse(player, tableCards);
////		assertTrue(isSameCardList(fullHouseList, result));
//	}
//
//	@Test
//	public void testIsNotFullHouse() {
//		Card cardThree1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
//		Card cardThree2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.ACE);
//		Card cardThree3 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
//
//		Card cardTwo1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
//		Card cardTwo2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);
//
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = cardThree3;
//		player.getCards()[1] = cardTwo2;
//
//		tableCards.add(cardTwo1);
//		tableCards.add(cardThree2);
//		tableCards.add(cardThree1);
//
////		List<ICard> result = RankingUtil.getFullHouse(player, tableCards);
////		assertNull(result);
//	}
//
//	@Test
//	public void testIsFlush() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setFlush(player, tableCards);
//
//		List<ICard> flushList = new ArrayList<ICard>();
//		flushList.addAll(tableCards);
//		flushList.add(player.getCards()[0]);
//		flushList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getFlush(player, tableCards);
////		assertTrue(isSameCardList(flushList, result));
//	}
//
//	@Test
//	public void testIsNotFlush() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
//
////		assertNull(RankingUtil.getFlush(player, tableCards));
//	}
//
//	@Test
//	public void testIsStraight() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setStraight(player, tableCards);
//
//		List<ICard> straightList = new ArrayList<ICard>();
//		straightList.addAll(tableCards);
//		straightList.add(player.getCards()[0]);
//		straightList.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getStraight(player, tableCards);
////		assertTrue(isSameCardList(straightList, result));
//	}
//
//	@Test
//	public void testIsNotStraight() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
//				CardRankEnum.CARD_2);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_8));
//		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
//		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_6));
//
////		assertNull(RankingUtil.getStraight(player, tableCards));
//	}
//
//	@Test
//	public void testIsThreeOfAKind() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setThreeOfAKind(player, tableCards);
//
//		List<ICard> listThreeOfAKind = new ArrayList<ICard>();
//
//		listThreeOfAKind.add(tableCards.get(1));
//		listThreeOfAKind.add(player.getCards()[0]);
//		listThreeOfAKind.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getThreeOfAKind(player, tableCards);
////		assertTrue(isSameCardList(listThreeOfAKind, result));
//	}
//
//	@Test
//	public void testIsNotThreeOfAKind() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
//				CardRankEnum.CARD_10);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
//
////		assertNull(RankingUtil.getThreeOfAKind(player, tableCards));
//	}
//
//	@Test
//	public void testIsTwoPair() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setTwoPair(player, tableCards);
//
//		List<ICard> fullHouseList = new ArrayList<ICard>();
//		fullHouseList.add(player.getCards()[0]);
//		fullHouseList.add(tableCards.get(0));
//		fullHouseList.add(player.getCards()[1]);
//		fullHouseList.add(tableCards.get(1));
//
////		List<ICard> result = RankingUtil.getTwoPair(player, tableCards);
////		assertTrue(isSameCardList(fullHouseList, result));
//	}
//
//	@Test
//	public void testIsNotTwoPair() {
//		Card cardThree1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
//		Card cardThree2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10);
//		Card cardThree3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10);
//
//		Card cardTwo1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
//		Card cardTwo2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);
//
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = cardThree3;
//		player.getCards()[1] = cardTwo2;
//
//		tableCards.add(cardTwo1);
//		tableCards.add(cardThree2);
//		tableCards.add(cardThree1);
//
////		List<ICard> result = RankingUtil.getTwoPair(player, tableCards);
////		assertNull(result);
//	}
//
//	@Test
//	public void testIsOnePair() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		setOnePair(player, tableCards);
//
//		List<ICard> listOnePair = new ArrayList<ICard>();
//		listOnePair.add(player.getCards()[0]);
//		listOnePair.add(player.getCards()[1]);
//
////		List<ICard> result = RankingUtil.getOnePair(player, tableCards);
////		assertTrue(isSameCardList(listOnePair, result));
//	}
//
//	@Test
//	public void testIsNotOnePair() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
//				CardRankEnum.CARD_2);
//		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
//				CardRankEnum.CARD_10);
//
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
//
////		assertNull(RankingUtil.getOnePair(player, tableCards));
//	}
//
//	@Test
//	public void testGetHighCardRepeatedCards() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		Card fourCard = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4);
//		player.getCards()[0] = fourCard;
//		player.getCards()[1] = fourCard;
//
//		tableCards.add(fourCard);
//		tableCards.add(fourCard);
//		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
//
////		assertEquals(fourCard, RankingUtil.getHighCard(player, tableCards));
//	}
//
//	@Test
//	public void testGetHighCardAce() {
//		List<ICard> tableCards = new ArrayList<ICard>();
//		Player player = new Player();
//		player.getCards()[0] = new Card(CardSuitEnum.HEARTS,
//				CardRankEnum.CARD_9);
//		player.getCards()[1] = new Card(CardSuitEnum.SPADES,
//				CardRankEnum.CARD_7);
//
//		Card aceCard = new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE);
//		tableCards.add(aceCard);
////		assertEquals(aceCard, RankingUtil.getHighCard(player, tableCards));
//	}

	public Boolean isSameCardList(List<ICard> listOnePair, List<ICard> result) {
		return listOnePair.containsAll(result) && listOnePair.size() == result.size();
	}

	private void setRoyalFlush(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS,	CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, JACK); // new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);

		tableCards.add(CardFactory.getCard(CLUBS, QUEEN)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));
		tableCards.add(CardFactory.getCard(CLUBS, KING)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(CardFactory.getCard(CLUBS, ACE)); //new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
		
		player.setHand(tableCards);
	}

	private void setStraightFlush(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_2); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_3); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_4)); //new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_5)); //new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_6)); //new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_6));
		
		player.setHand(tableCards);
	}

	private void setFourOfAKind(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(DIAMONDS, CARD_10); // new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS,	CardRankEnum.CARD_10);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_10)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
		tableCards.add(CardFactory.getCard(CLUBS, KING)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_10)); //new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		
		player.setHand(tableCards);
	}

	private void setFullHouse(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(HEARTS, JACK); // new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);

		tableCards.add(CardFactory.getCard(CLUBS, JACK)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK));
		tableCards.add(CardFactory.getCard(HEARTS, CARD_10)); // new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_10)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
		
		player.setHand(tableCards);
	}

	private void setFlush(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_3); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_2)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(CardFactory.getCard(CLUBS, KING)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(CardFactory.getCard(CLUBS, ACE)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
		
		player.setHand(tableCards);
	}

	private void setStraight(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(DIAMONDS, CARD_4); // new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_4);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_5); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_2)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_3)); // new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3));
		tableCards.add(CardFactory.getCard(CLUBS, CARD_6)); // new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_6));
		
		player.setHand(tableCards);
	}

	private void setThreeOfAKind(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(SPADES, CARD_10); // new Card(CardSuitEnum.SPADES,	CardRankEnum.CARD_10);
		
		tableCards.add(CardFactory.getCard(SPADES, ACE)); // new Card(CardSuitEnum.SPADES, CardRankEnum.ACE));
		tableCards.add(CardFactory.getCard(HEARTS, CARD_10)); // new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		tableCards.add(CardFactory.getCard(HEARTS, CARD_2)); // new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
		
		player.setHand(tableCards);
	}

	private void setTwoPair(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(CLUBS, CARD_10); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, JACK); // new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);

		tableCards.add(CardFactory.getCard(SPADES, CARD_10)); // new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));
		tableCards.add(CardFactory.getCard(HEARTS, JACK)); // new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK));
		
		player.setHand(tableCards);
	}

	private void setOnePair(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(DIAMONDS, CARD_10); // new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_10); // New Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_2)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(CardFactory.getCard(CLUBS, KING)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(CardFactory.getCard(CLUBS, ACE)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
		
		player.setHand(tableCards);
	}

	private void setHighCard(Player player, List<ICard> tableCards) {
		player.getCards()[0] = CardFactory.getCard(DIAMONDS, CARD_10); // new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_10);
		player.getCards()[1] = CardFactory.getCard(CLUBS, CARD_9); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_9);

		tableCards.add(CardFactory.getCard(CLUBS, CARD_2)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(CardFactory.getCard(CLUBS, KING)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(CardFactory.getCard(CLUBS, ACE)); // new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
		
		player.setHand(tableCards);
	}
}
