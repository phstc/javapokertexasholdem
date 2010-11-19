package com.cantero.games.pokertexas;

public interface ICard {

	public abstract CardSuitEnum getSuit();

	public abstract CardRankEnum getRank();

	public abstract Integer getRankToInt();

}