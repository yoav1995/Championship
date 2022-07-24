package Championship.listeners;

import Championship.model.Player;

public interface ChampionshipUIEventListener {
	void addedPlayerToUI(String name);
	void removedPlayerFromUI(String name);
	void startChampionship();
	void setGameType(int type);
	void startMatchGameUI(String one, String two);
	void endMatchGameUI(String one, String two);
	
}
