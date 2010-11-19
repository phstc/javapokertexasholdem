package com.cantero.games.pokertexas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static com.cantero.games.pokertexas.RankingEnum.*;

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
public class RankingUtil {
/*
	private RankingUtil() {
	}

	public static Integer getRankingToInt(IPlayer player) {
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
*/
	
//	public static RankingEnum getRank(List<ICard> hand) {
//		RankingEnum rank = null;
//		
//		if (hasRoyalFlush(hand))
//			// Royal Flush
//			rank = ROYAL_FLUSH;
//		else if (hasStraightFlush(hand))
//			rank = STRAIGHT_FLUSH;
//		else if (hasFourOfAKind(hand))
//			rank = FOUR_OF_A_KIND;
//		else if (hasFullHouse(hand))
//			rank = FULL_HOUSE;
//		else if (hasFlush(hand)) 
//			rank = FLUSH;
//		else if (hasStraight(hand))
//			rank = STRAIGHT;
//		else if (hasThreeOfAKind(hand))
//			rank = THREE_OF_A_KIND;
//		else if (hasTwoPair(hand))
//			rank = TWO_PAIR;
//		else if (hasPair(hand))
//			rank = ONE_PAIR;
//		else
//			rank = HIGH_CARD;
//		
//		return rank;
//	}
//	
//	private static boolean hasPair(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static boolean hasTwoPair(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static boolean hasThreeOfAKind(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static boolean hasStraight(List<ICard> hand) {
//		if (isStraight(hand))
//			return true;
//		
//		return false;
//	}
//
//	private static boolean hasFlush(List<ICard> hand) {
//		if (isFlush(hand))
//			return true;
//		
//		return false;
//	}
//
//	private static boolean hasFullHouse(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static boolean hasFourOfAKind(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static boolean hasStraightFlush(List<ICard> hand) {
//		if (isFlush(hand) && isStraight(hand))
//			return true;
//		
//		return false;
//	}
//
//	private static boolean hasRoyalFlush(List<ICard> hand) {
//		if (isHighestAce(hand) && isFlush(hand) && isStraight(hand))
//			return true;
//
//		return false;
//	}
//
//	private static boolean isHighestAce(List<ICard> hand) {
//		for (ICard card : hand)
//			if (card.getRank() == CardRankEnum.ACE)
//				// has ace
//				return true;
//		
//		return false;
//	}
//
//	private static boolean isFlush(List<ICard> hand) {
//		boolean first = true;
//		CardSuitEnum suit = null;
//		for (ICard card : hand)
//			if (first) {
//				// initialize the suit
//				suit = card.getSuit();
//				first = false;
//			}
//			else if (suit != card.getSuit())
//				// not a flush
//				return false;
//		
//		return true;
//	}
//
//	private static boolean isStraight(List<ICard> hand) {
//		hand = getOrderedCardList(hand);
//		
//		boolean first = true;
//		int previousRank = -1;
//		for (ICard card : hand) {
//			if (first) {
//				// initialize previousRank with the lowest rank
//				previousRank = card.getRankToInt();
//				first = false;
//			}
//			else if (previousRank == card.getRankToInt()-1)
//				// it's a sequence until now
//				previousRank++;
//			else
//				// not a sequence
//				return false;
//		}
//		
//		return true;
//	}
//	
//	private static List<ICard> getOrderedCardList(List<ICard> hand) {
//		Collections.sort(hand, new Comparator<ICard>() {
//
//			public int compare(ICard c1, ICard c2) {
//				return c1.getRankToInt() < c2.getRankToInt() ? -1 : 1;
//			}
//
//		});
//		
//		return hand;
//	}
//
//	public static ICard getHighCard(List<ICard> hand) {
//		boolean first = true;
//		ICard highCard = null;
//		for (ICard card : hand)
//			if (first) {
//				// initialize highCard
//				highCard = card;
//				first = false;
//			}
//			else if (card.getRankToInt() > highCard.getRankToInt())
//				// update highCard
//				highCard = card;
//		
//		return highCard;
//	}
	
//	@Deprecated
//	public static RankingEnum getRank(List<ICard> hand, IPlayer player) {
//
//		//HIGH_CARD
//		ICard highCard = getHighCard(hand);
//		player.setHighCard(highCard);
//
//		//ROYAL_FLUSH
//		List<ICard> rankingList = getRoyalFlush(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.ROYAL_FLUSH, rankingList);
//			return ROYAL_FLUSH;
//		}
//		//STRAIGHT_FLUSH
//		rankingList = getStraightFlush(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.STRAIGHT_FLUSH,
////					rankingList);
//			return STRAIGHT_FLUSH;
//		}
//		//FOUR_OF_A_KIND
//		rankingList = getFourOfAKind(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.FOUR_OF_A_KIND,
////					rankingList);
//			return FOUR_OF_A_KIND;
//		}
//		//FULL_HOUSE
//		rankingList = getFullHouse(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.FULL_HOUSE, rankingList);
//			return FULL_HOUSE;
//		}
//		//FLUSH
//		rankingList = getFlush(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.FLUSH, rankingList);
//			return FLUSH;
//		}
//		//STRAIGHT
//		rankingList = getStraight(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.STRAIGHT, rankingList);
//			return STRAIGHT;
//		}
//		//THREE_OF_A_KIND
//		rankingList = getThreeOfAKind(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.THREE_OF_A_KIND,
////					rankingList);
//			return THREE_OF_A_KIND;
//		}
//		//TWO_PAIR
//		rankingList = getTwoPair(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.TWO_PAIR, rankingList);
//			return TWO_PAIR;
//		}
//		//ONE_PAIR
//		rankingList = getOnePair(hand);
//		if (rankingList != null) {
////			setRankingEnumAndList(player, RankingEnum.ONE_PAIR, rankingList);
//			return ONE_PAIR;
//		}
//		//HIGH_CARD
////		player.setRankingEnum(RankingEnum.HIGH_CARD);
//		List<ICard> highCardRankingList = new ArrayList<ICard>();
//		highCardRankingList.add(highCard);
////		player.setRankingList(highCardRankingList);
//		return HIGH_CARD;
//	}
	
//	private static List<ICard> getOnePair(List<ICard> hand) {
//		if (checkPair(hand, 2))
//			return hand;
//		
//		return null;
//	}
//
//	private static List<ICard> getTwoPair(List<ICard> hand) {
//		if (checkTwoPair(hand, 2)) {
//			//hand.
//		}
//		return null;
//	}
//
//	private static List<ICard> getThreeOfAKind(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<ICard> getStraight(List<ICard> hand) {
//		if (!isSequence(hand))
//			// not straight
//			return null;
//		
//		return hand;
//	}
//
//	private static List<ICard> getFlush(List<ICard> hand) {
//		if (!isSameSuit(hand))
//			// not flush
//			return null;
//		
//		return hand;
//	}
//
//	private static List<ICard> getFullHouse(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<ICard> getFourOfAKind(List<ICard> hand) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<ICard> getStraightFlush(List<ICard> hand) {
//		if (!isSameSuit(hand))
//			// not a flush
//			return null;
//		
//		if (!isSequence(hand))
//			// not a straight
//			return null;
//		
//		return hand;
//	}
//
//	private static List<ICard> getRoyalFlush(List<ICard> hand) {
//		if (!isHighestAce(hand) || !isSameSuit(hand) || !isSequence(hand))
//			// not royal flush
//			return null;
//
//		return hand;
//	}
	
//	private static boolean checkTwoPair(List<ICard> hand, final int pairSize) {
//		for (ICard card1 : hand) {
//			// initialize counter
//			int sameCount = 0;
//			for (ICard card2 : hand)
//				if (card1.getRank().equals(card2.getRank()))
//					// found a pair
//					sameCount++;
//			
//			if (sameCount == pairSize)
//				// found the expected number of pairs
//				return true;
//		}
//		
//		return false;
//	}
//
//	private static boolean checkPair(List<ICard> hand, final int pairSize) {
//		for (ICard card1 : hand) {
//			// initialize counter
//			int sameCount = 0;
//			for (ICard card2 : hand)
//				if (card1.getRank().equals(card2.getRank()))
//					// found a pair
//					sameCount++;
//			
//			if (sameCount == pairSize)
//				// found the expected number of pairs
//				return true;
//		}
//		
//		return false;
//	}
	

	public static RankingEnum checkRanking(List<ICard> hand) {

		List<ICard> handCopy = new ArrayList<ICard>();
		
		//HIGH_CARD
//		ICard highCard = getHighCard(hand);
//		player.setHighCard(highCard);

		//ROYAL_FLUSH
		List<ICard> rankingList = getRoyalFlush(hand);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.ROYAL_FLUSH, rankingList);
			return ROYAL_FLUSH;
		}
		//STRAIGHT_FLUSH
		
		rankingList = getStraightFlush(hand);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.STRAIGHT_FLUSH,
//					rankingList);
			return STRAIGHT_FLUSH;
		}
		//FOUR_OF_A_KIND
		handCopy.clear();
		handCopy.addAll(hand);
		rankingList = getFourOfAKind(handCopy);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.FOUR_OF_A_KIND,
//					rankingList);
			return FOUR_OF_A_KIND;
		}
		//FULL_HOUSE
		handCopy.clear();
		handCopy.addAll(hand);
		rankingList = getFullHouse(handCopy);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.FULL_HOUSE, rankingList);
			return FULL_HOUSE;
		}
		//FLUSH
		rankingList = getFlush(hand);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.FLUSH, rankingList);
			return FLUSH;
		}
		//STRAIGHT
		rankingList = getStraight(hand);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.STRAIGHT, rankingList);
			return STRAIGHT;
		}
		//THREE_OF_A_KIND
		handCopy.clear();
		handCopy.addAll(hand);
		rankingList = getThreeOfAKind(handCopy);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.THREE_OF_A_KIND,
//					rankingList);
			return THREE_OF_A_KIND;
		}
		//TWO_PAIR
		handCopy.clear();
		handCopy.addAll(hand);
		rankingList = getTwoPair(handCopy);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.TWO_PAIR, rankingList);
			return TWO_PAIR;
		}
		//ONE_PAIR
		handCopy.clear();
		handCopy.addAll(hand);
		rankingList = getOnePair(handCopy);
		if (rankingList != null) {
//			setRankingEnumAndList(player, RankingEnum.ONE_PAIR, rankingList);
			return ONE_PAIR;
		}
		//HIGH_CARD
//		player.setRankingEnum(RankingEnum.HIGH_CARD);
//		rankingList = new ArrayList<ICard>();
//		rankingList.add(highCard);
//		player.setRankingList(highCardRankingList);
		return HIGH_CARD;
	}

	public static List<ICard> getRoyalFlush(List<ICard> hand) {
		ICard highCard = getHighCard(hand);
		List<ICard> sequence = getSequence(hand, 5, true);
		
		if (highCard.getRank() != CardRankEnum.ACE || sequence == null)
			return null;
		
		return sequence;
//		if (!isSameSuit(hand)) {
//			return null;
//		}
//
//		List<CardRankEnum> rankEnumList = toRankEnumList(hand);
//
//		if (rankEnumList.contains(CardRankEnum.CARD_10)
//				&& rankEnumList.contains(CardRankEnum.JACK)
//				&& rankEnumList.contains(CardRankEnum.QUEEN)
//				&& rankEnumList.contains(CardRankEnum.KING)
//				&& rankEnumList.contains(CardRankEnum.ACE)) {
//
//			return hand; //getMergedCardList(player, tableCards);
//		}
//
//		return null;
	}

	public static List<ICard> getStraightFlush(List<ICard> hand) {
		return getSequence(hand, 5, true);
	}

	public static List<ICard> getFourOfAKind(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		return checkPair(hand, 4);
	}

	public static List<ICard> getFullHouse(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		List<ICard> threeList = checkPair(hand, 3);
		if (threeList != null) {
			hand.removeAll(threeList);
			List<ICard> twoList = checkPair(hand, 2);
			if (twoList != null) {
				threeList.addAll(twoList);
				return threeList;
			}
		}
		return null;
	}

	public static List<ICard> getFlush(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		List<ICard> flushList = new ArrayList<ICard>();

		for (ICard card1 : hand) {
			for (ICard card2 : hand) {
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

	//S�o 5 cartas seguidas de naipes diferentes, caso empate ganha aquele com a maior sequ�ncia.
	public static List<ICard> getStraight(List<ICard> hand) {
		return getSequence(hand, 5, false);
	}

	public static List<ICard> getThreeOfAKind(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		return checkPair(hand, 3);
	}

	public static List<ICard> getTwoPair(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		List<ICard> twoPair1 = checkPair(hand, 2);
		if (twoPair1 != null) {
			hand.removeAll(twoPair1);
			List<ICard> twoPair2 = checkPair(hand, 2);
			if (twoPair2 != null) {
				twoPair1.addAll(twoPair2);
				return twoPair1;
			}
		}
		return null;
	}

	public static List<ICard> getOnePair(List<ICard> hand) {
		//List<ICard> mergedList = getMergedCardList(player, tableCards);
		return checkPair(hand, 2);
	}

	public static ICard getHighCard(List<ICard> hand) {
		ICard highCard = hand.get(0);
		for (ICard card : hand) {
			if (card.getRankToInt() > highCard.getRankToInt()) {
				highCard = card;
			}
		}
		return highCard;
	}

	private static List<ICard> getSequence(List<ICard> hand, Integer sequenceSize, Boolean compareSuit) {
		List<ICard> orderedList = getOrderedCardList(hand);
		List<ICard> sequenceList = new ArrayList<ICard>();

		ICard previousCard = null;
		for (ICard card : orderedList) {
			if (previousCard != null) {
				if ((card.getRankToInt() - previousCard.getRankToInt()) == 1) {
					if (!compareSuit
							|| previousCard.getSuit().equals(card.getSuit())) {
						if (sequenceList.size() == 0) {
							sequenceList.add(previousCard);
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
			previousCard = card;
		}

		return (sequenceList.size() == sequenceSize) ? sequenceList : null;
	}

	@Deprecated
	private static List<ICard> getMergedCardList(IPlayer player,
			List<ICard> tableCards) {
		List<ICard> merged = new ArrayList<ICard>();
		merged.addAll(tableCards);
		merged.add(player.getCards()[0]);
		merged.add(player.getCards()[1]);
		return merged;
	}

	private static List<ICard> getOrderedCardList(List<ICard> hand) {
		Collections.sort(hand, new Comparator<ICard>() {

			public int compare(ICard c1, ICard c2) {
				return c1.getRankToInt() < c2.getRankToInt() ? -1 : 1;
			}

		});
		return hand;
	}

	private static List<ICard> checkPair(List<ICard> hand, Integer pairSize) {
		List<ICard> checkedPair = new ArrayList<ICard>();
		for (ICard card1 : hand) {
			checkedPair.add(card1);
			for (ICard card2 : hand) {
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

	@Deprecated
	private static Boolean isSameSuit(List<ICard> hand) {
		CardSuitEnum suit = hand.get(0).getSuit();

		for (ICard card : hand) {
			if (!card.getSuit().equals(suit)) {
				return false;
			}
		}

		return true;
	}

	@Deprecated
	private static List<CardRankEnum> toRankEnumList(IPlayer player,
			List<ICard> tableCards) {
		List<CardRankEnum> rankEnumList = new ArrayList<CardRankEnum>();

		for (ICard card : tableCards) {
			rankEnumList.add(card.getRank());
		}

		rankEnumList.add(player.getCards()[0].getRank());
		rankEnumList.add(player.getCards()[1].getRank());

		return rankEnumList;
	}

	@Deprecated
	private static void setRankingEnumAndList(IPlayer player,
			RankingEnum rankingEnum, List<ICard> rankingList) {
		player.setRankingEnum(rankingEnum);
		player.setRankingList(rankingList);
	}
	
}
