package com.cantero.games.pokertexas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.cantero.games.pokertexas.GameTexasHoldem.GameEnum;

public class GameTexasHoldemRunner {

	public static void main(String[] args) throws IOException {

		//getMilliSecondsToExecute
		long milliSeconds = getMilliSecondsToExecute(100000);
		long seconds = milliSeconds / 1000;
		long minutes = seconds / 60;
		System.out.println("minutes: " + minutes + ", seconds: " + seconds);

		String currDir = System.getProperty("user.dir");
		
	    //getStatsSimple
	    String simpleFileName = currDir+"/stats - simple.csv";
	    getStatsSimple(simpleFileName, 100000);
	    System.out.println("getStatsSimple - OK - " + simpleFileName);

	    //getStatsFull
	    String fullFileName = currDir+"/stats - full.csv";
	    getStatsFull(fullFileName, 100000);
	    System.out.println("getStatsFull - OK - " + fullFileName);

	}

	private static void getStatsFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();

		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));

		bwFull
				.write("DEALER DEAL;PLAYER DEAL;DEALER CALL FLOP;PLAYER CALL FLOP;DEALER BET TURN;PLAYER BET TURN;DEALER BET RIVER;PLAYER BET RIVER;WINNER;COUNT;PERCENT\n");

		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			game.newGame();
			game.deal();
			String retLine = new String(game.getDealer().getRankingEnum()
					.toString()
					+ ";");
			retLine += game.getPlayer().getRankingEnum().toString() + ";";
			game.callFlop();
			retLine += game.getDealer().getRankingEnum().toString() + ";";
			retLine += game.getPlayer().getRankingEnum().toString() + ";";
			game.betTurn();
			retLine += game.getDealer().getRankingEnum().toString() + ";";
			retLine += game.getPlayer().getRankingEnum().toString() + ";";
			game.betRiver();
			retLine += game.getDealer().getRankingEnum().toString() + ";";
			retLine += game.getPlayer().getRankingEnum().toString() + ";";
			retLine += game.getWinner().toString();
			game.endGame();

			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}

		}
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
		Map<GameEnum, Long> statsSimple = new HashMap<GameEnum, Long>();

		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			game.newGame();
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			GameEnum stats = game.getWinner();
			game.endGame();

			Long count = statsSimple.get(stats);
			if (count != null) {
				statsSimple.put(stats, count + 1);
			} else {
				statsSimple.put(stats, 1L);
			}

		}
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));

		bwFull.write("STATS;COUNT;PERCENT\n");

		Iterator<GameEnum> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			GameEnum stat = it.next();
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
			game.newGame();
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			game.getWinner();
			game.endGame();
		}
		long timeToMillisFinal = System.currentTimeMillis();
		long milliSeconds = (timeToMillisFinal - timeToMillisInitial);
		return milliSeconds;
	}
}
