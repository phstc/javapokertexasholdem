package com.cantero.games.poker.texasholdem;

public class Assert {
	
	public static void assertTrue(Boolean condition, String message){
		if(!condition){
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void assertTrue(Boolean condition){
		assertTrue(condition, "The condition is not true");
	}

}
