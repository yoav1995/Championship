package Championship.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Championship.listeners.ChampionshipUIEventListener;
import Championship.model.GameAdmin;
import Championship.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainPageFX implements AbstractChampionshipView {

	private ArrayList<TextField> names = new ArrayList<TextField>();
	private ArrayList<TextField> semiFinals = new ArrayList<TextField>();
	private ArrayList<TextField> finals = new ArrayList<TextField>();
	private ArrayList<ChampionshipUIEventListener> listeners=new ArrayList<ChampionshipUIEventListener>();
	private boolean isSemiFinals=false, isFinals=false;
	private boolean isEightPlayers=false, isGameSet=false;

	private TextField finalWinnerTxt = new TextField();


	private BorderPane bpResults=new BorderPane();
	private BorderPane bpMain = new BorderPane();

	public MainPageFX(Stage theStage) {

		theStage.setTitle("");
		// pane for the main page
		bpMain.setPadding(new Insets(5));
		bpMain.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));

		// adding another border pane for the results page.
		bpResults.setPadding(new Insets(10));
		bpResults.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		bpResults.setVisible(false);
		// creating a title.
		Label lbTitle = new Label();
		lbTitle.setText("Sports Championship");
		lbTitle.setTextAlignment(TextAlignment.CENTER);
		lbTitle.setTextFill(Color.BLUEVIOLET);
		lbTitle.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);

		HBox hbTitle = new HBox();
		hbTitle.setSpacing(10);
		hbTitle.setPadding(new Insets(10));
		hbTitle.setAlignment(Pos.CENTER);
		hbTitle.getChildren().addAll(lbTitle);

		// adding features
		Label lbCenter = new Label();
		lbCenter.setText("Participant name: ");
		TextField tfCenter = new TextField("");


		HBox hbCenterTop = new HBox();
		hbCenterTop.setSpacing(50);
		hbCenterTop.setAlignment(Pos.BOTTOM_CENTER);
		hbCenterTop.getChildren().addAll(lbCenter, tfCenter);

		// creating radio button option
		ToggleGroup togSports = new ToggleGroup();
		RadioButton tennisBtn = new RadioButton("Tennis");
		RadioButton soccerBtn = new RadioButton("Soccer");
		RadioButton basketBtn = new RadioButton("Basketball");
		tennisBtn.setToggleGroup(togSports);
		soccerBtn.setToggleGroup(togSports);
		basketBtn.setToggleGroup(togSports);
		// actions for each one

		tennisBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.setGameType(1);
					isGameSet=true;

				}

			}
		});

		soccerBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.setGameType(2);
					isGameSet=true;
				}

			}
		});

		basketBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.setGameType(3);
					isGameSet=true;

				}
			}
		});

		VBox vbSports = new VBox();
		vbSports.setSpacing(10);
		vbSports.setPadding(new Insets(10));
		vbSports.setAlignment(Pos.CENTER_LEFT);
		vbSports.getChildren().addAll(tennisBtn, soccerBtn, basketBtn);

		for (Node n : bpMain.getChildren()) {
			((Label) n).setBorder(
					new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
		}

		// Results page

		// creating text boxes for the participants

		TextField player1txt = new TextField();
		TextField player2txt = new TextField();
		TextField player3txt = new TextField();
		TextField player4txt = new TextField();
		TextField player5txt = new TextField();
		TextField player6txt = new TextField();
		TextField player7txt = new TextField();
		TextField player8txt = new TextField();

		names.add(player1txt);
		names.add(player2txt);
		names.add(player3txt);
		names.add(player4txt);
		names.add(player5txt);
		names.add(player6txt);
		names.add(player7txt);
		names.add(player8txt);


		Button playGameOneTwo = new Button("Play Game");
		Button playGameThreeFour = new Button("Play Game");
		Button playGameFiveSix = new Button("Play Game");
		Button playGameSevenEight = new Button("Play Game");



		playGameOneTwo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.startMatchGameUI(player1txt.getText(), player2txt.getText());
				}
				playGameOneTwo.setDisable(true);
			}
		});

		playGameThreeFour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.startMatchGameUI(player3txt.getText(), player4txt.getText());
				}
				playGameThreeFour.setDisable(true);

			}
		});

		playGameFiveSix.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.startMatchGameUI(player5txt.getText(), player6txt.getText());
				}
				playGameFiveSix.setDisable(true);

			}
		});

		playGameSevenEight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(ChampionshipUIEventListener listen: listeners) {
					listen.startMatchGameUI(player7txt.getText(), player8txt.getText());
				}
				playGameSevenEight.setDisable(true);

			}
		});


		for(TextField player: names) {
			player.setEditable(false);
		}



		////clicking on the textField removes a player!
		for(TextField player: names) {
			player.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(!(player.getText().equals("")))
						for(ChampionshipUIEventListener listen: listeners) {
							listen.removedPlayerFromUI(player.getText());
						}
				}
			});	
		}

		VBox vbPlayers = new VBox();
		vbPlayers.setSpacing(30);
		//vbPlayers.setPadding(new Insets(20));
		vbPlayers.setAlignment(Pos.CENTER_LEFT);
		vbPlayers.getChildren().addAll(player1txt, player2txt, player3txt, player4txt, player5txt, player6txt,
				player7txt, player8txt);

		VBox vbButtons = new VBox();
		vbButtons.setSpacing(85);
		vbButtons.setPadding(new Insets(10));
		vbButtons.setAlignment(Pos.CENTER);
		vbButtons.getChildren().addAll(playGameOneTwo, playGameThreeFour, playGameFiveSix, playGameSevenEight);

		// creating text fields for winners
		TextField winner1txt = new TextField();
		TextField winner2txt = new TextField();
		TextField winner3txt = new TextField();
		TextField winner4txt = new TextField();

		winner1txt.setEditable(false);
		winner2txt.setEditable(false);
		winner3txt.setEditable(false);
		winner4txt.setEditable(false);

		semiFinals.add(winner1txt);
		semiFinals.add(winner2txt);
		semiFinals.add(winner3txt);
		semiFinals.add(winner4txt);

		Button playGameWinners1 = new Button("Play Game");
		Button playGameWinners2 = new Button("Play Game");

		playGameWinners1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!(isSemiFinals)){
					JOptionPane.showMessageDialog(null, "Connot play until all players have played!");
				}
				else {
					for(ChampionshipUIEventListener listen: listeners) {
						listen.startMatchGameUI(winner1txt.getText(), winner2txt.getText());
					}
					playGameWinners1.setDisable(true);
				}
			}
		});

		playGameWinners2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!(isSemiFinals)){
					JOptionPane.showMessageDialog(null, "Connot play until all players have played!");
				}
				else {
					for(ChampionshipUIEventListener listen: listeners) {
						listen.startMatchGameUI(winner3txt.getText(), winner4txt.getText());
					}
					playGameWinners2.setDisable(true);
				}
			}
		});

		VBox vbWinnersButtons = new VBox();
		vbWinnersButtons.setSpacing(137);
		vbWinnersButtons.setAlignment(Pos.CENTER);
		// vbWinnersButtons.setPadding(new Insets(20));
		vbWinnersButtons.getChildren().addAll(playGameWinners1, playGameWinners2);

		VBox vbWinners1 = new VBox();
		vbWinners1.setSpacing(65);
		vbWinners1.setAlignment(Pos.CENTER_RIGHT);
		// vbWinners1.setPadding(new Insets(10));
		vbWinners1.getChildren().addAll(winner1txt, winner2txt, winner3txt, winner4txt);

		// FINAL RESULTS
		TextField finalPlayer1txt = new TextField();
		TextField finalPlayer2txt = new TextField();

		finalPlayer1txt.setEditable(false);
		finalPlayer2txt.setEditable(false);

		finals.add(finalPlayer1txt);
		finals.add(finalPlayer2txt);

		VBox vbLastMatch = new VBox();
		vbLastMatch.setSpacing(20);
		vbLastMatch.setAlignment(Pos.CENTER_RIGHT);
		vbLastMatch.setPadding(new Insets(20));
		vbLastMatch.getChildren().addAll(finalPlayer1txt, finalPlayer2txt);

		HBox hbResults = new HBox();
		hbResults.setSpacing(50);
		hbResults.setAlignment(Pos.CENTER);
		hbResults.getChildren().addAll(vbButtons, vbWinners1, vbWinnersButtons, vbLastMatch);

		finalWinnerTxt.setEditable(false);

		Button playFinal = new Button("Play Game");
		playFinal.setAlignment(Pos.CENTER_RIGHT);
		playFinal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!(isFinals)){
					JOptionPane.showMessageDialog(null, "Connot play until all players have played!");
				}
				else {
					for(ChampionshipUIEventListener listen: listeners) {
						listen.startMatchGameUI(finalPlayer1txt.getText(), finalPlayer2txt.getText());
					}
					playFinal.setDisable(true);
				}

			}
		});

		VBox vbFinal = new VBox();
		vbFinal.setSpacing(20);
		vbFinal.setAlignment(Pos.CENTER_LEFT);
		vbFinal.getChildren().addAll(finalWinnerTxt);

		HBox hbFinal = new HBox();
		hbFinal.setSpacing(50);
		hbFinal.setAlignment(Pos.CENTER);
		hbFinal.getChildren().addAll(playFinal, vbFinal);

		// our buttons

		Button addP = new Button();
		addP.setText("Add Participant");
		addP.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (ChampionshipUIEventListener listen : listeners) {
					listen.addedPlayerToUI(tfCenter.getText());
				}
			}
		});


		Button startChampionship = new Button("Start Championship");
		startChampionship.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(!(isEightPlayers))
					JOptionPane.showMessageDialog(null, "Must have 8 players!");
				else if(!(isGameSet))
					JOptionPane.showMessageDialog(null, "Must check a game type first!");
				else {
					bpResults.setLeft(vbPlayers);
					bpResults.setCenter(hbResults);
					bpResults.setRight(hbFinal);
					bpResults.setTop(hbTitle);
					for(ChampionshipUIEventListener listen: listeners) {
						listen.startChampionship();
					}
					////make sure you cant remove a player after the championship starts!
					for(TextField player: names) {
						player.setOnMouseReleased(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								
							}
						});	
					}
				}


			}
		});

		HBox hbCenterDown = new HBox();
		hbCenterDown.setSpacing(50);
		hbCenterDown.setAlignment(Pos.CENTER);
		hbCenterDown.getChildren().addAll(addP, startChampionship);

		VBox vbCenter = new VBox();
		vbCenter.setSpacing(30);
		vbCenter.setPadding(new Insets(10));
		vbCenter.setAlignment(Pos.CENTER);
		vbCenter.getChildren().addAll(hbCenterTop, hbCenterDown);

		// final stage
		bpMain.setCenter(vbCenter);
		bpMain.setTop(hbTitle);
		bpMain.setRight(vbSports);
		bpMain.setLeft(vbPlayers);

		StackPane bothView = new StackPane();
		bothView.getChildren().addAll(bpMain, bpResults);
		// bothView.getChildren().get(0).setVisible(true);

		theStage.setScene(new Scene(bothView, 1400, 600));
		theStage.show();
	}


	@Override
	public void registerListener(ChampionshipUIEventListener listener) {
		listeners.add(listener);

	}

	@Override
	public void addPlayer(String name) {
		for(int i=0;i<names.size();i++) {
			if((names.get(i).getText().equals(""))) {
				names.get(i).setText(name);
				break;
			}
		}

	}

	@Override
	public void removePlayer(String name) {
		for(int i=0; i<names.size();i++) {
			if(names.get(i).getText().equals(name)) {
				for(int j=i+1;j<names.size();j++) {
					names.get(i).setText(names.get(j).getText());
					i++;
				}
				names.get(names.size()-1).setText("");
			}
		}
	}

	@Override
	public void startChampionship() {
		bpMain.setVisible(false);
		bpResults.setVisible(true);
	}


	@Override
	public void endMatch(String name, int index) {
		if(isSemiFinals==false) {
			if(index==0||index==1) {
				if(semiFinals.get(0).getText().equals(""))
					semiFinals.get(0).setText(name);
			}
			else if(index==2||index==3) {
				if(semiFinals.get(1).getText().equals(""))
					semiFinals.get(1).setText(name);
			}
			else if(index==4||index==5) {
				if(semiFinals.get(2).getText().equals(""))
					semiFinals.get(2).setText(name);
			}
			else if(index==6||index==7) {
				if(semiFinals.get(3).getText().equals(""))
					semiFinals.get(3).setText(name);
			}
		}
		if(isSemiFinals==false) {
			for(int i=0; i<semiFinals.size();i++) {
				if((semiFinals.get(i).getText().equals("")))
					return;
			}

			isSemiFinals=true;
			return;
		}

		if(isFinals==false) {
			if(index==0||index==1||index==2||index==3) {
				if(finals.get(0).getText().equals(""))
					finals.get(0).setText(name);
			}

			if(index==4||index==5||index==6||index==7) {
				if(finals.get(1).getText().equals(""))
					finals.get(1).setText(name);
			}
		}

		if(isFinals==false) {
			for(int i=0; i<finals.size();i++) {
				if((finals.get(i).getText().equals("")))
					return;
			}
			isFinals=true;
			return;
		}

		finalWinnerTxt.setText(name);


		JOptionPane.showMessageDialog(null, name+" IS THE CHAMPION!!!");
	}

	public void isEightPlayers() {
		isEightPlayers=true;
	}
}

