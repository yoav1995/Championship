package Championship.view;

import java.util.ArrayList;

import Championship.listeners.ChampionshipUIEventListener;
import Championship.listeners.GameUIEventListener;
import Championship.model.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GamePageFX implements AbstractGameView {

	private Stage gameStage=new Stage();
	private ArrayList<ChampionshipUIEventListener> listeners=new ArrayList<ChampionshipUIEventListener>();;
	private ArrayList<TextField> oneScores=new ArrayList<TextField>();
	private ArrayList<TextField> twoScores=new ArrayList<TextField>();

	private BorderPane bpGameLayout=new BorderPane();

	private Label lblOneName=new Label();
	private Label lblTwoName=new Label();
	private Label lbMatchTitle = new Label();

	private HBox hbOneScores=new HBox(10);
	private HBox hbTwoScores=new HBox(10);


	public GamePageFX (Stage theStage2) {
		gameStage=theStage2;
		gameStage.setTitle("");


		TextField oneScore1=new TextField();
		TextField oneScore2=new TextField();
		TextField oneScore3=new TextField();
		TextField oneScore4=new TextField();
		TextField oneScore5=new TextField();

		TextField twoScore1=new TextField();
		TextField twoScore2=new TextField();
		TextField twoScore3=new TextField();
		TextField twoScore4=new TextField();
		TextField twoScore5=new TextField();

		oneScores.add(oneScore1);
		oneScores.add(oneScore2);
		oneScores.add(oneScore3);
		oneScores.add(oneScore4);
		oneScores.add(oneScore5);

		twoScores.add(twoScore1);
		twoScores.add(twoScore2);
		twoScores.add(twoScore3);
		twoScores.add(twoScore4);
		twoScores.add(twoScore5);

		for(TextField score: oneScores) {
			score.setPrefWidth(50);
			score.setEditable(false);
		}

		for(TextField score: twoScores) {
			score.setPrefWidth(50);
			score.setEditable(false);
		}

		HBox hbMain = new HBox();
		hbMain.setSpacing(100);
		hbMain.setPadding(new Insets(10));
		hbMain.setAlignment(Pos.BOTTOM_RIGHT);
		hbMain.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		Button btnDone = new Button("Done");
		btnDone.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.endMatchGameUI(lblOneName.getText(), lblTwoName.getText());
				}
			}
		});
		btnDone.setAlignment(Pos.CENTER);
		HBox hbDone = new HBox();
		hbDone.setPadding(new Insets(10));
		hbDone.setAlignment(Pos.CENTER);
		hbDone.getChildren().addAll(btnDone);

		
		hbOneScores.getChildren().addAll(oneScores);
		hbTwoScores.getChildren().addAll(twoScores);

		VBox vbScores=new VBox(10);
		VBox vbNames=new VBox(10);

		vbScores.getChildren().addAll(hbOneScores, hbTwoScores);
		vbNames.getChildren().addAll(lblOneName,lblTwoName);


		hbMain.getChildren().addAll(vbNames,vbScores);

		bpGameLayout.setCenter(hbMain);
		bpGameLayout.setBottom(hbDone);

		gameStage.setScene(new Scene(bpGameLayout, 500, 300));

	}


	@Override
	public void registerListener(ChampionshipUIEventListener listener) {
		listeners.add(listener);

	}

	@Override
	public void showGameWindow(String gameType, String one, String two) {
		lbMatchTitle.setText(gameType);
		lbMatchTitle.setTextAlignment(TextAlignment.CENTER);
		lbMatchTitle.setTextFill(Color.BLUEVIOLET);
		lbMatchTitle.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
		
		HBox hbTitle = new HBox();
		hbTitle.setSpacing(10);
		hbTitle.setPadding(new Insets(10));
		hbTitle.setAlignment(Pos.CENTER);
		hbTitle.getChildren().addAll(lbMatchTitle);
		
		
		lblOneName.setText(one);
		lblOneName.setTextAlignment(TextAlignment.LEFT);
		lblTwoName.setText(two);
		lblTwoName.setTextAlignment(TextAlignment.LEFT);
		
	
		bpGameLayout.setTop(hbTitle);
		gameStage.show();

	}

	@Override
	public void closeGameWindow() {
		gameStage.close();

	}

	@Override
	public void playGame(Player playerOne, Player playerTwo) {
		for(int i=0; i<oneScores.size(); i++) {
			if(i<playerOne.getScores().size())
				oneScores.get(i).setText(playerOne.getScores().get(i).toString());
			if(oneScores.get(i).getText().equals("")) {
				oneScores.get(i).setVisible(false);
			}
		}

		for(int i=0; i<twoScores.size(); i++) {
			if(i<playerTwo.getScores().size())
				twoScores.get(i).setText(playerTwo.getScores().get(i).toString());
			if(twoScores.get(i).getText().equals("")) {
				twoScores.get(i).setVisible(false);
			}
		}
	}

}
