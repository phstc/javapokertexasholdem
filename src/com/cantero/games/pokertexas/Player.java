package com.cantero.games.pokertexas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements IPlayer, Serializable {

	private static final long serialVersionUID = 4664480702994610549L;

	private ICard[] cards = new ICard[2];
	
	private List<ICard> hand = new ArrayList<ICard>();

	//TODO its usage need to be refactored, deprecated now
	@Deprecated
	private RankingEnum rankingEnum = null;

	//TODO its usage need to be refactored, deprecated now
	@Deprecated
	private List<ICard> rankingList = null;

	private ICard highCard = null;

	public ICard getHighCard() {
		return highCard;
	}
	
	public void setHighCard(ICard highCard) {
		this.highCard = highCard;		
	}

	public RankingEnum getRankingEnum() {
		return rankingEnum;
	}

	public void setRankingEnum(RankingEnum rankingEnum) {
		this.rankingEnum = rankingEnum;
	}

	public List<ICard> getRankingList() {
		return rankingList;
	}

	public void setRankingList(List<ICard> rankingList) {
		this.rankingList = rankingList;
	}

	public ICard[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	/**
	 * Set the hand of the player
	 * @param tableCards a view of the table cards
	 */
	public void setHand(List<ICard> tableCards) {
		this.hand = new ArrayList<ICard>();
		Collections.addAll(this.hand, cards);
		this.hand.addAll(tableCards);
		setHighCard();
	}
	
	/**
	 * Set the hand of the player
	 * @param playerCards a view of the player cards
	 * @param tableCards a view of the table cards
	 */
	public void setHand(List<ICard> playerCards, List<ICard> tableCards) {
		this.hand = new ArrayList<ICard>();
		this.hand.addAll(playerCards);
		this.hand.addAll(tableCards);
		setHighCard();
	}
	
	private void setHighCard() {
		ICard highCard = hand.get(0);
		for (ICard card : hand)
			if (card.getRankToInt() > highCard.getRankToInt())
				highCard = card;
		
		this.highCard = highCard;
	}

	/**
	 * Get the hand of the player
	 * @return a view of the player cards
	 */
	public List<ICard> getHand() {
		return (List<ICard>) hand;
	}
}
