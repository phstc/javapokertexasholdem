package com.cantero.games.pokertexas;

import java.util.List;

import com.cantero.games.pokertexas.RankingUtil.RankingEnum;

public interface IPlayer {
	public Card[] getCards();

	public List<Card> getRankingList();

	public void setRankingList(List<Card> rankingList);

	public RankingEnum getRankingEnum();

	public void setRankingEnum(RankingEnum rankingEnum);

	public Card getHighCard();

	public void setHighCard(Card highCard);
}
