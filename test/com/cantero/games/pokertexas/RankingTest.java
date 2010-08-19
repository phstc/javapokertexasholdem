package com.cantero.games.pokertexas;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.cantero.games.pokertexas.Card;
import com.cantero.games.pokertexas.Player;
import com.cantero.games.pokertexas.RankingUtil;
import com.cantero.games.pokertexas.Card.CardRankEnum;
import com.cantero.games.pokertexas.Card.CardSuitEnum;
import com.cantero.games.pokertexas.RankingUtil.RankingEnum;

public class RankingTest extends TestCase {

	/*
	 * 	01) ROYAL_FLUSH,
	 *	02) STRAIGHT_FLUSH,
	 *	03) FOUR_OF_A_KIND,
	 *	04) FULL_HOUSE,
	 *	05) FLUSH,
	 *	06) STRAIGHT,
	 *	07) THREE_OF_A_KIND,
	 *	08) TWO_PAIR,
	 *	09) ONE_PAIR,
	 *	10) HIGH_CARD
	 */
	@Test
	public void testCheckRoyalFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setRoyalFlush(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.ROYAL_FLUSH, player.getRankingEnum());
		assertEquals(RankingUtil.getRoyalFlush(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(10), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckStraightFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setStraightFlush(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.STRAIGHT_FLUSH, player.getRankingEnum());
		assertEquals(RankingUtil.getStraightFlush(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(9), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFourOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFourOfAKind(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.FOUR_OF_A_KIND, player.getRankingEnum());
		assertEquals(RankingUtil.getFourOfAKind(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(8), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFullHouse() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFullHouse(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.FULL_HOUSE, player.getRankingEnum());
		assertEquals(RankingUtil.getFullHouse(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(7), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFlush(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.FLUSH, player.getRankingEnum());
		assertEquals(RankingUtil.getFlush(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(6), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckStraight() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setStraight(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.STRAIGHT, player.getRankingEnum());
		assertEquals(RankingUtil.getStraight(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(5), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckThreeOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setThreeOfAKind(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.THREE_OF_A_KIND, player.getRankingEnum());
		assertEquals(RankingUtil.getThreeOfAKind(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(4), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckTwoPair() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setTwoPair(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.TWO_PAIR, player.getRankingEnum());
		assertEquals(RankingUtil.getTwoPair(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(3), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckOnePair() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setOnePair(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.ONE_PAIR, player.getRankingEnum());
		assertEquals(RankingUtil.getOnePair(player, tableCards), player
				.getRankingList());
		assertEquals(new Integer(2), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testCheckHighCard() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setHighCard(player, tableCards);
		RankingUtil.checkRanking(player, tableCards);
		assertEquals(RankingEnum.HIGH_CARD, player.getRankingEnum());
		assertEquals(RankingUtil.getHighCard(player, tableCards), player
				.getRankingList().get(0));
		assertEquals(new Integer(1), RankingUtil.getRankingToInt(player));
	}

	@Test
	public void testIsRoyalFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setRoyalFlush(player, tableCards);

		List<Card> royalFlushList = new ArrayList<Card>();
		royalFlushList.addAll(tableCards);
		royalFlushList.add(player.getCards()[0]);
		royalFlushList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getRoyalFlush(player, tableCards);
		assertTrue(isSameCardList(royalFlushList, result));
	}

	@Test
	public void testIsRoyalFlushNotSequence() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));

		List<Card> royalFlushList = new ArrayList<Card>();
		royalFlushList.addAll(tableCards);
		royalFlushList.add(player.getCards()[0]);
		royalFlushList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getRoyalFlush(player, tableCards);
		assertTrue(isSameCardList(royalFlushList, result));
	}

	@Test
	public void testIsNotRoyalFlushNotSameSuit() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE);
		player.getCards()[1] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_3));
		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_4));

		assertNull(RankingUtil.getRoyalFlush(player, tableCards));
	}

	@Test
	public void testIsStraightFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setStraightFlush(player, tableCards);

		List<Card> straightFlushList = new ArrayList<Card>();
		straightFlushList.addAll(tableCards);
		straightFlushList.add(player.getCards()[0]);
		straightFlushList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getStraightFlush(player, tableCards);
		assertTrue(isSameCardList(straightFlushList, result));
	}

	@Test
	public void testIsStraightFlushNotSequence() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_8));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_6));

		assertNull(RankingUtil.getStraightFlush(player, tableCards));
	}

	@Test
	public void testIsNotStraightFlushNoSameSuit() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5));
		tableCards.add(new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_6));

		assertNull(RankingUtil.getStraightFlush(player, tableCards));
	}

	@Test
	public void testIsFourOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFourOfAKind(player, tableCards);

		List<Card> fourOfAKindList = new ArrayList<Card>();
		fourOfAKindList.add(tableCards.get(0));
		fourOfAKindList.add(tableCards.get(2));
		fourOfAKindList.add(player.getCards()[0]);
		fourOfAKindList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getFourOfAKind(player, tableCards);
		assertTrue(isSameCardList(fourOfAKindList, result));
	}

	@Test
	public void testIsNotFourOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));

		assertNull(RankingUtil.getFourOfAKind(player, tableCards));
	}

	@Test
	public void testIsFullHouse() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFullHouse(player, tableCards);

		List<Card> fullHouseList = new ArrayList<Card>();
		fullHouseList.add(player.getCards()[0]);
		fullHouseList.add(tableCards.get(1));
		fullHouseList.add(tableCards.get(2));
		fullHouseList.add(player.getCards()[1]);
		fullHouseList.add(tableCards.get(0));

		List<Card> result = RankingUtil.getFullHouse(player, tableCards);
		assertTrue(isSameCardList(fullHouseList, result));
	}

	@Test
	public void testIsNotFullHouse() {
		Card cardThree1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		Card cardThree2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.ACE);
		Card cardThree3 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);

		Card cardTwo1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
		Card cardTwo2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);

		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = cardThree3;
		player.getCards()[1] = cardTwo2;

		tableCards.add(cardTwo1);
		tableCards.add(cardThree2);
		tableCards.add(cardThree1);

		List<Card> result = RankingUtil.getFullHouse(player, tableCards);
		assertNull(result);
	}

	@Test
	public void testIsFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setFlush(player, tableCards);

		List<Card> flushList = new ArrayList<Card>();
		flushList.addAll(tableCards);
		flushList.add(player.getCards()[0]);
		flushList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getFlush(player, tableCards);
		assertTrue(isSameCardList(flushList, result));
	}

	@Test
	public void testIsNotFlush() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));

		assertNull(RankingUtil.getFlush(player, tableCards));
	}

	@Test
	public void testIsStraight() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setStraight(player, tableCards);

		List<Card> straightList = new ArrayList<Card>();
		straightList.addAll(tableCards);
		straightList.add(player.getCards()[0]);
		straightList.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getStraight(player, tableCards);
		assertTrue(isSameCardList(straightList, result));
	}

	@Test
	public void testIsNotStraight() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_2);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_8));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_6));

		assertNull(RankingUtil.getStraight(player, tableCards));
	}

	@Test
	public void testIsThreeOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setThreeOfAKind(player, tableCards);

		List<Card> listThreeOfAKind = new ArrayList<Card>();

		listThreeOfAKind.add(tableCards.get(1));
		listThreeOfAKind.add(player.getCards()[0]);
		listThreeOfAKind.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getThreeOfAKind(player, tableCards);
		assertTrue(isSameCardList(listThreeOfAKind, result));
	}

	@Test
	public void testIsNotThreeOfAKind() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));

		assertNull(RankingUtil.getThreeOfAKind(player, tableCards));
	}

	@Test
	public void testIsTwoPair() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setTwoPair(player, tableCards);

		List<Card> fullHouseList = new ArrayList<Card>();
		fullHouseList.add(player.getCards()[0]);
		fullHouseList.add(tableCards.get(0));
		fullHouseList.add(player.getCards()[1]);
		fullHouseList.add(tableCards.get(1));

		List<Card> result = RankingUtil.getTwoPair(player, tableCards);
		assertTrue(isSameCardList(fullHouseList, result));
	}

	@Test
	public void testIsNotTwoPair() {
		Card cardThree1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10);
		Card cardThree2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10);
		Card cardThree3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10);

		Card cardTwo1 = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);
		Card cardTwo2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);

		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = cardThree3;
		player.getCards()[1] = cardTwo2;

		tableCards.add(cardTwo1);
		tableCards.add(cardThree2);
		tableCards.add(cardThree1);

		List<Card> result = RankingUtil.getTwoPair(player, tableCards);
		assertNull(result);
	}

	@Test
	public void testIsOnePair() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		setOnePair(player, tableCards);

		List<Card> listOnePair = new ArrayList<Card>();
		listOnePair.add(player.getCards()[0]);
		listOnePair.add(player.getCards()[1]);

		List<Card> result = RankingUtil.getOnePair(player, tableCards);
		assertTrue(isSameCardList(listOnePair, result));
	}

	@Test
	public void testIsNotOnePair() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_2);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));

		assertNull(RankingUtil.getOnePair(player, tableCards));
	}

	@Test
	public void testGetHighCardRepeatedCards() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		Card fourCard = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4);
		player.getCards()[0] = fourCard;
		player.getCards()[1] = fourCard;

		tableCards.add(fourCard);
		tableCards.add(fourCard);
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));

		assertEquals(fourCard, RankingUtil.getHighCard(player, tableCards));
	}

	@Test
	public void testGetHighCardAce() {
		List<Card> tableCards = new ArrayList<Card>();
		Player player = new Player();
		player.getCards()[0] = new Card(CardSuitEnum.HEARTS,
				CardRankEnum.CARD_9);
		player.getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_7);

		Card aceCard = new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE);
		tableCards.add(aceCard);
		assertEquals(aceCard, RankingUtil.getHighCard(player, tableCards));
	}

	public Boolean isSameCardList(List<Card> list1, List<Card> list2) {
		return list1.containsAll(list2) && list1.size() == list2.size();
	}

	private void setRoyalFlush(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.QUEEN));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
	}

	private void setStraightFlush(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_4));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_6));
	}

	private void setFourOfAKind(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
	}

	private void setFullHouse(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_10));
	}

	private void setFlush(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
	}

	private void setStraight(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_4);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_5);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3));
		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_6));
	}

	private void setThreeOfAKind(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.SPADES,
				CardRankEnum.CARD_10);
		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.ACE));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2));
	}

	private void setTwoPair(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK);

		tableCards.add(new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_10));
		tableCards.add(new Card(CardSuitEnum.HEARTS, CardRankEnum.JACK));
	}

	private void setOnePair(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS,
				CardRankEnum.CARD_10);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
	}

	private void setHighCard(Player player, List<Card> tableCards) {
		player.getCards()[0] = new Card(CardSuitEnum.DIAMONDS,
				CardRankEnum.CARD_10);
		player.getCards()[1] = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_9
				);

		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_2));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.KING));
		tableCards.add(new Card(CardSuitEnum.CLUBS, CardRankEnum.ACE));
	}
}
