package Championship.view;

import Championship.listeners.ChampionshipUIEventListener;
import Championship.listeners.GameUIEventListener;
import Championship.model.GameAdmin;
import Championship.model.Player;

public interface AbstractChampionshipView {
	void registerListener(ChampionshipUIEventListener listener);
	void addPlayer(String name);
	void removePlayer(String name);
	void startChampionship();
	void endMatch(String name, int plyerIndex);
	void isEightPlayers();

	
}
