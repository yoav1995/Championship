package Championship.model;

import java.util.Random;

public class Soccer implements GameRoots{

	public void startSet(Player one, Player two) {
		Random rnd =new Random();
		
		int oneScore=rnd.nextInt(5);
		int twoScore=rnd.nextInt(5);
		one.setScores(oneScore); //sets a random score between 0-5 goals per half.
		two.setScores(twoScore);
		
		one.setTotalScore(oneScore); // sums the total goals
		two.setTotalScore(twoScore);
		
	}
	public void tieBreaker(Player one, Player two) {
		Random rnd =new Random();
		do {
			int oneScore=rnd.nextInt(1);
			int twoScore=rnd.nextInt(1);
			
			one.setScores(oneScore);
			two.setScores(twoScore);
			
			one.setTotalScore(oneScore); // sums the total goals
			two.setTotalScore(twoScore);
			
		}while(Math.abs(one.getTotalScore()-two.getTotalScore()) != 2 );
	}

	
	

}
