package Championship.main;

import Championship.controllers.ChampionshipController;
import Championship.model.GameAdmin;
import Championship.view.AbstractChampionshipView;
import Championship.view.AbstractGameView;
import Championship.view.GamePageFX;
import Championship.view.MainPageFX;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
		public void start(Stage theStage){
		AbstractChampionshipView mainView= new MainPageFX (theStage);
		AbstractGameView gameView=new GamePageFX(new Stage());
		GameAdmin admin=new GameAdmin();
		ChampionshipController control=new ChampionshipController(admin, mainView, gameView);
	}


}
