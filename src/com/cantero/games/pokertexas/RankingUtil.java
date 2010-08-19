package com.cantero.games.pokertexas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cantero.games.pokertexas.Card.CardRankEnum;
import com.cantero.games.pokertexas.Card.CardSuitEnum;

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
public class RankingUtil {

	private RankingUtil() {
	}

	public static enum RankingEnum {
		ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD
	}

	public static Integer getRankingToInt(Player player) {
		switch (player.getRankingEnum()) {
		case ROYAL_FLUSH:
			return 10;
		case STRAIGHT_FLUSH:
			return 9;
		case FOUR_OF_A_KIND:
			return 8;
		case FULL_HOUSE:
			return 7;
		case FLUSH:
			return 6;
		case STRAIGHT:
			return 5;
		case THREE_OF_A_KIND:
			return 4;
		case TWO_PAIR:
			return 3;
		case ONE_PAIR:
			return 2;
		case HIGH_CARD:
			return 1;
		}
		return null;
	}

	public static void checkRanking(Player player, List<Card> tableCards) {

		//HIGH_CARD
		Card highCard = getHighCard(player, tableCards);
		player.setHighCard(highCard);

		//ROYAL_FLUSH
		List<Card> rankingList = getRoyalFlush(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.ROYAL_FLUSH, rankingList);
			return;
		}
		//STRAIGHT_FLUSH
		rankingList = getStraightFlush(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.STRAIGHT_FLUSH,
					rankingList);
			return;
		}
		//FOUR_OF_A_KIND
		rankingList = getFourOfAKind(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.FOUR_OF_A_KIND,
					rankingList);
			return;
		}
		//FULL_HOUSE
		rankingList = getFullHouse(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.FULL_HOUSE, rankingList);
			return;
		}
		//FLUSH
		rankingList = getFlush(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.FLUSH, rankingList);
			return;
		}
		//STRAIGHT
		rankingList = getStraight(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.STRAIGHT, rankingList);
			return;
		}
		//THREE_OF_A_KIND
		rankingList = getThreeOfAKind(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.THREE_OF_A_KIND,
					rankingList);
			return;
		}
		//TWO_PAIR
		rankingList = getTwoPair(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.TWO_PAIR, rankingList);
			return;
		}
		//ONE_PAIR
		rankingList = getOnePair(player, tableCards);
		if (rankingList != null) {
			setRankingEnumAndList(player, RankingEnum.ONE_PAIR, rankingList);
			return;
		}
		//HIGH_CARD
		player.setRankingEnum(RankingEnum.HIGH_CARD);
		player.setRankingList(new ArrayList<Card>());
		player.getRankingList().add(highCard);
		return;
	}

	public static List<Card> getRoyalFlush(Player player, List<Card> tableCards) {
		if (!isSameSuit(player, tableCards)) {
			return null;
		}

		List<CardRankEnum> rankEnumList = toRankEnumList(player, tableCards);

		if (rankEnumList.contains(CardRankEnum.CARD_10)
				&& rankEnumList.contains(CardRankEnum.JACK)
				&& rankEnumList.contains(CardRankEnum.QUEEN)
				&& rankEnumList.contains(CardRankEnum.KING)
				&& rankEnumList.contains(CardRankEnum.ACE)) {

			return getMergedCardList(player, tableCards);
		}

		return null;
	}

	public static List<Card> getStraightFlush(Player player,
			List<Card> tableCards) {
		return getSequence(player, tableCards, 5, true);
	}

	public static List<Card> getFourOfAKind(Player player, List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		return checkPair(mergedList, 4);
	}

	public static List<Card> getFullHouse(Player player, List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		List<Card> threeList = checkPair(mergedList, 3);
		if (threeList != null) {
			mergedList.removeAll(threeList);
			List<Card> twoList = checkPair(mergedList, 2);
			if (twoList != null) {
				threeList.addAll(twoList);
				return threeList;
			}
		}
		return null;
	}

	public static List<Card> getFlush(Player player, List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		List<Card> flushList = new ArrayList<Card>();

		for (Card card1 : mergedList) {
			for (Card card2 : mergedList) {
				if (card1.getSuit().equals(card2.getSuit())) {
					if (!flushList.contains(card1)) {
						flushList.add(card1);
					}
					if (!flushList.contains(card2)) {
						flushList.add(card2);
					}
				}
			}
			if (flushList.size() == 5) {
				return flushList;
			}
			flushList.clear();
		}
		return null;
	}

	//São 5 cartas seguidas de naipes diferentes, caso empate ganha aquele com a maior sequência.
	public static List<Card> getStraight(Player player, List<Card> tableCards) {
		return getSequence(player, tableCards, 5, false);
	}

	public static List<Card> getThreeOfAKind(Player player,
			List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		return checkPair(mergedList, 3);
	}

	public static List<Card> getTwoPair(Player player, List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		List<Card> twoPair1 = checkPair(mergedList, 2);
		if (twoPair1 != null) {
			mergedList.removeAll(twoPair1);
			List<Card> twoPair2 = checkPair(mergedList, 2);
			if (twoPair2 != null) {
				twoPair1.addAll(twoPair2);
				return twoPair1;
			}
		}
		return null;
	}

	public static List<Card> getOnePair(Player player, List<Card> tableCards) {
		List<Card> mergedList = getMergedCardList(player, tableCards);
		return checkPair(mergedList, 2);
	}

	public static Card getHighCard(Player player, List<Card> tableCards) {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(tableCards);
		allCards.add(player.getCards()[0]);
		allCards.add(player.getCards()[1]);

		Card highCard = allCards.get(0);
		for (Card card : allCards) {
			if (card.getRankToInt() > highCard.getRankToInt()) {
				highCard = card;
			}
		}
		return highCard;
	}

	private static List<Card> getSequence(Player player, List<Card> tableCards,
			Integer sequenceSize, Boolean compareSuit) {
		List<Card> orderedList = getOrderedCardList(player, tableCards);
		List<Card> sequenceList = new ArrayList<Card>();

		Card cardPrevious = null;
		for (Card card : orderedList) {
			if (cardPrevious != null) {
				if ((card.getRankToInt() - cardPrevious.getRankToInt()) == 1) {
					if (!compareSuit
							|| cardPrevious.getSuit().equals(card.getSuit())) {
						if (sequenceList.size() == 0) {
							sequenceList.add(cardPrevious);
						}
						sequenceList.add(card);
					}
				} else {
					if (sequenceList.size() == sequenceSize) {
						return sequenceList;
					}
					sequenceList.clear();
				}
			}
			cardPrevious = card;
		}

		return (sequenceList.size() == sequenceSize) ? sequenceList : null;
	}

	private static List<Card> getMergedCardList(Player player,
			List<Card> tableCards) {
		List<Card> merged = new ArrayList<Card>();
		merged.addAll(tableCards);
		merged.add(player.getCards()[0]);
		merged.add(player.getCards()[1]);
		return merged;
	}

	private static List<Card> getOrderedCardList(Player player,
			List<Card> tableCards) {
		List<Card> ordered = getMergedCardList(player, tableCards);
		Collections.sort(ordered, new Comparator<Card>() {

			public int compare(Card c1, Card c2) {
				return c1.getRankToInt() < c2.getRankToInt() ? -1 : 1;
			}

		});
		return ordered;
	}

	private static List<Card> checkPair(List<Card> mergedList, Integer pairSize) {
		List<Card> checkedPair = new ArrayList<Card>();
		for (Card card1 : mergedList) {
			checkedPair.add(card1);
			for (Card card2 : mergedList) {
				if (!card1.equals(card2)
						&& card1.getRank().equals(card2.getRank())) {
					checkedPair.add(card2);
				}
			}
			if (checkedPair.size() == pairSize) {
				return checkedPair;
			}
			checkedPair.clear();
		}
		return null;
	}

	private static Boolean isSameSuit(Player player, List<Card> tableCards) {
		CardSuitEnum suit = player.getCards()[0].getSuit();

		if (!suit.equals(player.getCards()[1].getSuit())) {
			return false;
		}

		for (Card card : tableCards) {
			if (!card.getSuit().equals(suit)) {
				return false;
			}
		}

		return true;
	}

	private static List<CardRankEnum> toRankEnumList(Player player,
			List<Card> tableCards) {
		List<CardRankEnum> rankEnumList = new ArrayList<CardRankEnum>();

		for (Card card : tableCards) {
			rankEnumList.add(card.getRank());
		}

		rankEnumList.add(player.getCards()[0].getRank());
		rankEnumList.add(player.getCards()[1].getRank());

		return rankEnumList;
	}

	private static void setRankingEnumAndList(Player player,
			RankingEnum rankingEnum, List<Card> rankingList) {
		player.setRankingEnum(rankingEnum);
		player.setRankingList(rankingList);
	}
}
