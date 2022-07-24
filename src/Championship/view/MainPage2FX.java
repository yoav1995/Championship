//package Championship.view;
//
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//
//import Championship.listeners.ChampionshipUIEventListener;
//import Championship.model.GameAdmin;
//import Championship.model.Player;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.OverrunStyle;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.effect.Effect;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.Border;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.BorderStroke;
//import javafx.scene.layout.BorderStrokeStyle;
//import javafx.scene.layout.BorderWidths;
//import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.TextAlignment;
//import javafx.stage.Stage;
//
//public class MainPage2FX implements AbstractChampionshipView {
//	private ArrayList<ChampionshipUIEventListener> listeners=new ArrayList<ChampionshipUIEventListener>();;
//	private ArrayList<TextField> names= new ArrayList<TextField>();
//
//	private BorderPane bpResults=new BorderPane();
//	private BorderPane bpMain = new BorderPane();
//
//
//
//	public MainPage2FX (Stage theStage) {
//		theStage.setTitle("");
//		/*
//		BorderPane bpBackground=new BorderPane();
//		bpBackground.setPadding(new Insets(5));
//		bpBackground.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
//		 */
//		bpMain.setPadding(new Insets(5));
//		bpMain.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
//
//		//adding another border pane for the results page.
//		bpResults.setPadding(new Insets(10));
//		bpResults.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
//		//bpBackground.getChildren().addAll(bpMain,bpResults);
//		bpResults.setVisible(false);
//		// creating a title.
//		Label lbTitle = new Label();
//		lbTitle.setText("Sports Championship");
//		lbTitle.setTextAlignment(TextAlignment.CENTER);
//		lbTitle.setTextFill(Color.BLUEVIOLET);
//		lbTitle.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
//
//
//		HBox hbTitle = new HBox();
//		hbTitle.setSpacing(10);
//		hbTitle.setPadding(new Insets(10));
//		hbTitle.setAlignment(Pos.CENTER);
//		hbTitle.getChildren().addAll(lbTitle);
//
//		// adding features
//		Label lbCenter = new Label();
//		lbCenter.setText("Participant name: ");
//		TextField tfCenter = new TextField("");
//
//		HBox hbCenterTop = new HBox();
//		hbCenterTop.setSpacing(50);
//		hbCenterTop.setAlignment(Pos.BOTTOM_CENTER);
//		hbCenterTop.getChildren().addAll(lbCenter, tfCenter);
//
//		// creating radio button option
//		ToggleGroup togSports = new ToggleGroup();
//		RadioButton tennisBtn = new RadioButton("Tennis");
//		RadioButton soccerBtn = new RadioButton("Soccer");
//		RadioButton basketBtn = new RadioButton("Basketball");
//		tennisBtn.setToggleGroup(togSports);
//		soccerBtn.setToggleGroup(togSports);
//		basketBtn.setToggleGroup(togSports);
//		// actions for each one
//
//		tennisBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.setGameType(2);
//				}
//
//			}
//		});
//
//		soccerBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.setGameType(1);
//				}
//
//			}
//		});
//
//		basketBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.setGameType(0);
//				}
//			}
//		});
//
//		VBox vbSports = new VBox();
//		vbSports.setSpacing(10);
//		vbSports.setPadding(new Insets(10));
//		vbSports.setAlignment(Pos.CENTER_LEFT);
//		vbSports.getChildren().addAll(tennisBtn, soccerBtn, basketBtn);
//
//		for (Node n : bpMain.getChildren()) {
//			((Label) n).setBorder(
//					new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
//		}
//
//
//		// creating text boxes for the participants
//		TextField player1txt = new TextField();
//		names.add(player1txt);
//		TextField player2txt = new TextField();
//		names.add(player2txt);
//		TextField player3txt = new TextField();
//		names.add(player3txt);
//		TextField player4txt = new TextField();
//		names.add(player4txt);
//		TextField player5txt = new TextField();
//		names.add(player5txt);
//		TextField player6txt = new TextField();
//		names.add(player6txt);
//		TextField player7txt = new TextField();
//		names.add(player7txt);
//		TextField player8txt = new TextField();
//		names.add(player8txt);
//
//		player1txt.setEditable(false);
//		player2txt.setEditable(false);
//		player3txt.setEditable(false);
//		player4txt.setEditable(false);
//		player5txt.setEditable(false);
//		player6txt.setEditable(false);
//		player7txt.setEditable(false);
//		player8txt.setEditable(false);
//
//		player1txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player1txt.getText());
//				}
//			}
//		});
//		player2txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player2txt.getText());
//				}
//			}
//		});
//		player3txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player3txt.getText());
//				}
//			}
//		});
//		player4txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player4txt.getText());
//				}
//			}
//		});
//		player5txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player5txt.getText());
//				}
//			}
//		});
//		player6txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player6txt.getText());
//				}
//			}
//		});
//		player7txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player7txt.getText());
//				}
//			}
//		});
//		player8txt.setOnMouseReleased(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.removedPlayerFromUI(player8txt.getText());
//				}
//			}
//		});
//
//
//
//		VBox vbPlayers = new VBox();
//		vbPlayers.setSpacing(20);
//		vbPlayers.setAlignment(Pos.CENTER);
//		vbPlayers.setPadding(new Insets(10));
//		vbPlayers.getChildren().addAll(player1txt, player2txt, player3txt, player4txt, player5txt, player6txt,
//				player7txt, player8txt);
//
//		//creating text fields for winners
//		TextField winner1txt = new TextField();
//		TextField winner2txt = new TextField();
//		TextField winner3txt = new TextField();
//		TextField winner4txt = new TextField();
//
//
//		VBox vbWinners1 = new VBox();
//		vbWinners1.setSpacing(65);
//		vbWinners1.setAlignment(Pos.CENTER);
//		vbWinners1.setPadding(new Insets(10));
//		vbWinners1.getChildren().addAll(winner1txt, winner2txt, winner3txt, winner4txt);
//
//		TextField finalPlayer1txt = new TextField();
//		TextField finalPlayer2txt = new TextField();
//		VBox vbLastMatch = new VBox();
//		vbLastMatch.setSpacing(20);
//		vbLastMatch.setAlignment(Pos.CENTER_RIGHT);
//		vbLastMatch.setPadding(new Insets(10));
//		vbLastMatch.getChildren().addAll( finalPlayer1txt, finalPlayer2txt);
//
//		HBox hbResults = new HBox();
//		hbResults.setSpacing(50);
//		hbResults.setAlignment(Pos.CENTER);
//		hbResults.getChildren().addAll(vbWinners1, vbLastMatch);
//
//
//
//		TextField finalWinnerTxt = new TextField();
//
//		VBox vbFinal = new VBox();
//		vbFinal.setSpacing(20);
//		vbFinal.setAlignment(Pos.CENTER);
//		vbFinal.setPadding(new Insets(10));
//		vbFinal.getChildren().addAll(finalWinnerTxt);
//		// our buttons
//
//		Button addP = new Button();
//		addP.setText("Add Participant");
//		addP.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					listen.addedPlayerToUI(tfCenter.getText());
//				}
//			}
//		});
//
//		bpResults.setLeft(vbPlayers);
//		bpResults.setCenter(hbResults);
//		bpResults.setRight(vbFinal);
//		bpResults.setTop(hbTitle);
//		
//		Button startChampionship = new Button();
//		startChampionship.setText("Start Championship");
//		startChampionship.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				for(ChampionshipUIEventListener listen: listeners) {
//					try {
//						listen.startChampionship();
//					} catch (Exception e) {
//						JOptionPane.showMessageDialog(null, e.getMessage());
//					}
//				}
//
//
//			}
//		});
//
//		HBox hbCenterDown = new HBox();
//		hbCenterDown.setSpacing(50);
//		hbCenterDown.setAlignment(Pos.CENTER);
//		hbCenterDown.getChildren().addAll(addP, startChampionship);
//
//		VBox vbCenter = new VBox();
//		vbCenter.setSpacing(30);
//		vbCenter.setPadding(new Insets(10));
//		vbCenter.setAlignment(Pos.CENTER);
//		vbCenter.getChildren().addAll(hbCenterTop, hbCenterDown);
//
//
//
//
//		// final stage
//		bpMain.setCenter(vbCenter);
//		bpMain.setTop(hbTitle);
//		bpMain.setRight(vbSports);
//		bpMain.setLeft(vbPlayers);
//
//		StackPane bothView=new StackPane();
//		bothView.getChildren().addAll(bpMain,bpResults);
//		//bothView.getChildren().get(0).setVisible(true);
//		theStage.setScene(new Scene(bothView, 1000, 600));
//		theStage.show();
//	}
//
//
//	@Override
//	public void registerListener(ChampionshipUIEventListener listener) {
//		listeners.add(listener);	
//	}
//
//	@Override
//	public void addPlayer(String name) {
//		for(int i=0;i<names.size();i++) {
//			if((names.get(i).getText().equals(""))) {
//				names.get(i).setText(name);
//				break;
//			}
//		}
//
//	}
//
//	@Override
//	public void removePlayer(String name) {
//		for(int i=0; i<names.size();i++) {
//			if(names.get(i).getText().equals(name)) {
//				for(int j=i+1;j<names.size();j++) {
//					names.get(i).setText(names.get(j).getText());
//					i++;
//				}
//				names.get(names.size()-1).setText("");
//			}
//		}
//
//	}
//
//	@Override
//	public void startChampionship() {
//
//		bpMain.setVisible(false);
//		bpResults.setVisible(true);
//
//	}
//
//
//
//	@Override
//	public void startMatch(Player one, Player two) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void endMatch(String name) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//
//}
