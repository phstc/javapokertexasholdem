package com.cantero.games.pokertexas;

import java.util.List;

public interface IPlayer {
	public ICard[] getCards();

	public List<ICard> getRankingList();

	public void setRankingList(List<ICard> rankingList);

	public RankingEnum getRankingEnum();

	public void setRankingEnum(RankingEnum rankingEnum);

	public ICard getHighCard();

	public void setHighCard(ICard highCard);
	
	public List<ICard> getHand();
	
	public void setHand(List<ICard> tableCards);
	
	public void setHand(List<ICard> palyerCards, List<ICard> tableCards);
}
