package Championship.listeners;

import Championship.model.Player;


public interface GameAdminEventListener {
	void addPlayerToModel(String name);
	void removePlayerFromModel(String name);
	void startMatchModel(Player one, Player two);
}
