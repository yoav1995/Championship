package Championship.controllers;



import javax.swing.JOptionPane;
import Championship.listeners.ChampionshipUIEventListener;
import Championship.listeners.GameAdminEventListener;
import Championship.listeners.GameUIEventListener;
import Championship.model.GameAdmin;
import Championship.model.Player;
import Championship.view.AbstractChampionshipView;
import Championship.view.AbstractGameView;

public class ChampionshipController implements ChampionshipUIEventListener, GameAdminEventListener {
	private GameAdmin admin;
	private AbstractChampionshipView mainView;
	private AbstractGameView gameView;

	public ChampionshipController (GameAdmin admin, AbstractChampionshipView mainView, AbstractGameView gameView) {
		this.admin=admin;
		this.mainView=mainView;
		this.gameView=gameView;

		admin.addListenerToModel(this);
		mainView.registerListener(this);
		gameView.registerListener(this);

	}

	@Override
	public void addPlayerToModel(String name) {
		mainView.addPlayer(name);
		if(admin.hasEightPlayers())
			mainView.isEightPlayers();
			
	}

	@Override
	public void removePlayerFromModel(String name) {
		mainView.removePlayer(name);

	}

	@Override
	public void addedPlayerToUI(String name) {
		try {
			admin.addPlayer(name);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public void removedPlayerFromUI(String name) {
		try {
			admin.removePlayer(name);
			mainView.removePlayer(name);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public void startChampionship(){
		mainView.startChampionship();
	}

	@Override
	public void setGameType(int type) {
		admin.setGameType(type);
	}

	@Override
	public void startMatchModel(Player one, Player two) {
		gameView.playGame(one, two);

	}

	@Override
	public void startMatchGameUI(String one, String two) {
		admin.startMatch(one, two);
		gameView.showGameWindow(admin.getGameTypeString(), one, two);
	}

	@Override
	public void endMatchGameUI(String one, String two) {
		Player playerOne= admin.getPlayerByName(one);
		Player playerTwo=admin.getPlayerByName(two);
		
		String winner=admin.getMatchWinner(playerOne, playerTwo);
		gameView.closeGameWindow();
		mainView.endMatch(winner, admin.getPlayerIndex(winner));

	}


}
