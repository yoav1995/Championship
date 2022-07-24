package Championship.model;

import java.util.Random;

public class Tennis implements GameRoots{

	public void startSet(Player one, Player two) {
	Random rnd =new Random();
	
	/// a loop to prevent a tie.
	do {  
	one.setScore(rnd.nextInt(7));
	two.setScore(rnd.nextInt(7));
	} while(one.getScore()==two.getScore());
	
	if(one.getScore()> two.getScore())
		one.winMatch();
	else
		two.winMatch();	
}

	@Override
	public Player matchWinner(Player one, Player two) {
		// TODO Auto-generated method stub
		return null;
	}

}
