package com.cantero.games.poker.texasholdem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GameTexasHoldemRunner {

	public static void main(String[] args) throws IOException {
		Integer[] executionsList = new Integer[] { 10000, 100000 };
		for (Integer executions : executionsList) {
			//getMilliSecondsToExecute
			long milliSeconds = getMilliSecondsToExecute(executions);
			long seconds = milliSeconds / 1000;
			long minutes = seconds / 60;
			System.out.println("executions: " + executions + ", minutes: "
					+ minutes + ", seconds: " + seconds);
			String currDir = System.getProperty("user.dir");
			//getStatsSimple
			String simpleFileName = currDir + "/stats" + executions
					+ "-simple.csv";
			getStatsSimple(simpleFileName, executions);
			System.out.println("getStatsSimple - OK - " + simpleFileName);
			//getStatsFull
			String fullFileName = currDir + "/stats" + executions + "-full.csv";
			getStatsFull(fullFileName, executions);
			System.out.println("getStatsFull - OK - " + fullFileName);
		}
	}

	private static void getStatsFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		//Header
		bwFull
				.write("DEALER DEAL;PLAYER DEAL;DEALER CALL FLOP;PLAYER CALL FLOP;DEALER BET TURN;PLAYER BET TURN;DEALER BET RIVER;PLAYER BET RIVER;WINNER;COUNT;PERCENT\n");
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			String retLine = new String(dealer.getRankingEnum().toString()
					+ ";");
			retLine += player.getRankingEnum().toString() + ";";
			game.callFlop();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			game.betTurn();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			game.betRiver();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				retLine += (game.getWinner().equals(dealer)) ? "Dealer"
						: "Player";
			} else {
				retLine += "Draw Game";
			}
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}

	private static void getStatsSimple(String path, int executions)
			throws IOException {
		Map<RankingEnum, Long> statsSimple = new HashMap<RankingEnum, Long>();
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			IPlayer winner = game.getWinner().get(0);
			Long count = statsSimple.get(winner.getRankingEnum());
			if (count != null) {
				statsSimple.put(winner.getRankingEnum(), count + 1);
			} else {
				statsSimple.put(winner.getRankingEnum(), 1L);
			}
		}
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		bwFull.write("STATS;COUNT;PERCENT\n");
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<RankingEnum> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			RankingEnum stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat.toString() + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}

	/*
	 * Macbook pro
	 * HD ATA de 320 GB (5.400 rpm)
	 * Memory 4GB 1066MHz DDR3 SDRAM - 2x2GB
	 * Processor 2.53GHz Intel Core 2 Duo
	 * O.S. Snow Leopard
	 * 100000 executions = 10 seconds
	 * 10000 executions = 2 seconds
	 */
	private static long getMilliSecondsToExecute(int executions) {
		long timeToMillisInitial = System.currentTimeMillis();
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			game.getWinner();
		}
		long timeToMillisFinal = System.currentTimeMillis();
		return (timeToMillisFinal - timeToMillisInitial);
	}
}
