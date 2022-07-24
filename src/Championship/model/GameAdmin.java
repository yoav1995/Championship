package Championship.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import Championship.listeners.GameAdminEventListener;

public class GameAdmin {
	private GameRoots gameType;
	private Contestents players;

	private ArrayList<GameAdminEventListener> listeners;

	public GameAdmin() {
		this.players=new Contestents();
		listeners=new ArrayList<GameAdminEventListener>();
	}

	public String getGameTypeString() {
		return gameType.getClass().getSimpleName();
	}
	public void setGameType(int num) {
		if(num==1)
			gameType=new Tennis();
		if(num==2)
			gameType=new Soccer();
		else if(num==3)
			gameType=new Basketball();
	}

	public void addPlayer(String name) throws Exception {
		players.addPlayer(name);
		fireAddPlayerToModel(name);
	}
	public void removePlayer(String name) throws Exception {
		players.removePlayer(name);
		fireRemovedPlayerFromModel(name);
	}

	public Player getPlayerByName(String name) {
		Player player=new Player(name);
		try {
			player=players.getPlayer(name);
		}catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage());
		}

		return player;
	}

	public int getPlayerIndex(String name) {
		for(int i=0;i<players.getPlayers().size();i++) {
			if(players.getPlayers().get(i).getName().equals(name))
				return i;
		}
		return -1;
	}

	public boolean hasEightPlayers() {
		if(players.getPlayers().size()!= Contestents.MAX_PLAYERS)
			return false;
		return true;
	}
	public boolean isGameTypeSet() {
		if(gameType instanceof Tennis)
			return true;
		else if(gameType instanceof Basketball)
			return true;
		else if(gameType instanceof Soccer)
			return true;

		return false;
	}


	public void startMatch(String one, String two) {
		Player playerOne=getPlayerByName(one);
		Player playerTwo=getPlayerByName(two);

		if(gameType instanceof Tennis)
			startTennisMatch(playerOne, playerTwo);
		else if(gameType instanceof Basketball)
			startBasketballMatch(playerOne, playerTwo);
		else
			startSoccerMatch(playerOne, playerTwo);
	}

	public void startTennisMatch(Player one, Player two) {
		one.resetScore();
		two.resetScore();

		while(Math.abs(one.getWins()-two.getWins()) < 3 ) {
			gameType.startSet(one, two);
		}
		fireMatch(one, two);
	}

	public void startBasketballMatch(Player one, Player two) {
		one.resetScore();
		two.resetScore();

		for(int i=0;i<4;i++) {
			gameType.startSet(one, two);
		}

		// in case of a tie
		if(one.getTotalScore()==two.getTotalScore()) {
			gameType.tieBreaker(one, two);

		}

		//check who is the winner
		if(one.getTotalScore()>two.getTotalScore())
			one.winMatch();
		else 
			two.winMatch();

		fireMatch(one, two);
	}

	public void startSoccerMatch(Player one, Player two) {
		one.resetScore();
		two.resetScore();

		for(int i=0;i<2;i++) {
			gameType.startSet(one, two);
		}

		// in case of a tie
		if(one.getTotalScore()==two.getTotalScore()) {
			gameType.startSet(one, two);
		}

		//in case there is still a tie; Penalty.
		if(one.getTotalScore()==two.getTotalScore()) {
			gameType.tieBreaker(one, two);
		}

		//check who is the winner
		if(one.getTotalScore()>two.getTotalScore())
			one.winMatch();
		else 
			two.winMatch();

		fireMatch(one, two);
	}



	public String getMatchWinner(Player playerOne,Player playerTwo) {
		if(playerOne.getWins()>playerTwo.getWins()) {
			return playerOne.getName();
		}

		else
			return playerTwo.getName();
	}

	public void addListenerToModel(GameAdminEventListener listener) {
		listeners.add(listener);
	}

	private void fireAddPlayerToModel(String name) {
		for(GameAdminEventListener listen : listeners)
			listen.addPlayerToModel(name);
	}

	private void fireRemovedPlayerFromModel(String name) {
		for(GameAdminEventListener listen : listeners)
			listen.removePlayerFromModel(name);
	}

	private void fireMatch(Player playerOne, Player playerTwo) {
		for(GameAdminEventListener listen : listeners)
			listen.startMatchModel(playerOne, playerTwo);
	}




}
