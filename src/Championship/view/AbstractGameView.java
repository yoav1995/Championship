package Championship.view;

import Championship.listeners.ChampionshipUIEventListener;
import Championship.listeners.GameUIEventListener;
import Championship.model.GameAdmin;
import Championship.model.Player;

public interface AbstractGameView {
	void registerListener(ChampionshipUIEventListener listener);
	void showGameWindow(String gameType, String one, String two);
	void closeGameWindow();
	void playGame(Player playerOne,Player playerTwo);

}
