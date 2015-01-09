# Java SE implemention for Texas Hold'em Poker

It's fully functional core engine implentation of Texas Hold'em Poker.

## Check out the following example

```java

	GameTexasHoldem game = new GameTexasHoldem();
	IPlayer homer = new Player();
	IPlayer flanders = new Player();
	IDeck deck = new Deck();
	// The Deck and Player used in the GameTexasHoldem are interfaces..
	// The newGame signature: public void newGame(IDeck deck, IPlayer player1, IPlayer... _players).
	// At least one player is mandatory to start the game, but you can add as many players as you want (Java Varargs).
	game.newGame(deck, homer, flanders);
	game.deal();
	game.callFlop();
	game.betRiver();
	game.betTurn();
	List<IPlayer> winnerList = game.getWinner();
	
        // Getting the result
	if(winnerList.size() > 1){
		// DRAW GAME
	} else if(winnerList.contains(homer)) {
		// HOMER WINNER
		// WINNER HAND: homer.getRankingEnum();
	} else if(winnerList.contains(flanders)) {
		// FLANDERS WINNER
		// WINNER HAND: flanders.getRankingEnum();
	}
	
	// The table cards
	game.getTableCards(); 
	
	// To get the player actual ranking
	homer.getRankingEnum();
	flanders.getRankingEnum();
	// IPlayer.getRankingEnum() can be changed in deal, call flop, bet river and bet turn.
```

The IPlayer.getRankingEnum() method returns RankingEnum which contains the actual ranking of the player.

```java
	public enum RankingEnum { {
		ROYAL_FLUSH, 
		STRAIGHT_FLUSH, 
		FOUR_OF_A_KIND, 
		FULL_HOUSE, 
		FLUSH, 
		STRAIGHT, 
		THREE_OF_A_KIND, 
		TWO_PAIR, 
		ONE_PAIR, 
		HIGH_CARD
	}
```

## Performance test

GameTexasHoldemRunner.main() executes the performance test and outputs it in two CSV report files.

### Results

* Macbook pro
* HD ATA de 320 GB (5.400 rpm)
* Memory 4GB 1066MHz DDR3 SDRAM - 2x2GB
* Processor 2.53GHz Intel Core 2 Duo
* O.S. Snow Leopard
* 100000 executions = 6 seconds
* 10000 executions = 1 seconds

### Generated reports 

Example for 10000 executions 

	executions: 10000, minutes: 0, seconds: 1
	getStatsSimple - OK - /Users/pablo/workspace/javapokertexasholdem/stats10000-simple.csv
	getStatsFull - OK - /Users/pablo/workspace/javapokertexasholdem/stats10000-full.csv
	
#### stats simple

Columns:
 
* STATS = RankingEnum winner
* COUNT = how many times the same RankingEnum winner occurs
* PERCENT = percentual of the COUNT compared with all executions

#### stats full

Columns: 

* DEALER DEAL = dealer RankingEnum in the deal step
* PLAYER DEAL = player RankingEnum in the deal step
* DEALER CALL FLOP = dealer RankingEnum in the call flop step
* PLAYER CALL FLOP = player RankingEnum in the call flop step
* DEALER BET TURN = dealer RankingEnum in the bet turn step
* PLAYER BET TURN = player RankingEnum in the bet turn step
* DEALER BET RIVER = dealer RankingEnum in the bet river step
* PLAYER BET RIVER = player RankingEnum in the bet river step
* WINNER = winner name (player or dealer)
* COUNT = how many times the same game occurs
* PERCENT = percentual of the COUNT compared with all executions
