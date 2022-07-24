//package Championship.controllers;
//
//import Championship.listeners.GameAdminEventListener;
//import Championship.listeners.GameUIEventListener;
//import Championship.model.GameAdmin;
//import Championship.model.Player;
//import Championship.view.AbstractGameView;
//
//public class GameController implements GameAdminEventListener, GameUIEventListener {
//	private GameAdmin admin;
//	private AbstractGameView gameView;
//	
//	public GameController(GameAdmin admin, AbstractGameView gameView) {
//		this.admin=admin;
//		this.gameView=gameView;
//		
//		admin.addListenerToModel(this);
//		gameView.registerListener(this);
//		
//	}
//
//	@Override
//	public void startMatchUI(String one, String two) {
//
//		
//	}
//
//	@Override
//	public void endMatchUI(Player one, Player two) {
//		admin.endMatch(one,two);
//		
//	}
//
//
//
//	@Override
//	public void startMatchModel(Player one, Player two) {
//		gameView.playGame(one, two);
//		
//	}
//
//	@Override
//	public void playGame(String one, String two) {
//		gameView.showGameWindow();
//		startMatchUI(one, two);
//	}
//
//	@Override
//	public void endMatchModel(Player one, Player two) {
//		gameView.closeGameWindow();
//		gameView.endGame(admin.getMatchWinner(one, two));
//		
//	}
//	
//	@Override
//	public void addPlayerToModel(String name) {
//		// Cannot add a player while playing
//	}
//	@Override
//	public void removePlayerFromModel(String name) {
//		// Cannot remove a player while playing
//	}
//
//	@Override
//	public void startMatchGameUI(String one, String two) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void endMatchGameUI(Player one, Player two) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//}
