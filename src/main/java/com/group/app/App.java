package com.group.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;


public class App extends Application {

	List<Movie> listaFilmow = new ArrayList<Movie>();

	public static void main(String[] args) {
		launch(args);
	}

	private HBox createTopMenu() {
		HBox topMenu = new HBox();

		Button addEntryButton = new Button("Add Entry");

		addEntryButton.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(final ActionEvent e) {

						Movie a =  AddingMovie.display();
						listaFilmow.add(a);

						// a.show_details();

					}} );


		TextField searchField = new TextField();
		Button searchButton = new Button("Search");

		topMenu.getChildren().addAll(addEntryButton, searchField, searchButton);
		topMenu.setSpacing(10);

		return topMenu;
	}

	private VBox createEntryList() {
		VBox entryList = new VBox();

		entryList.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		entryList.setPrefWidth(250);

		return entryList;
	}


	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Film Library");

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.createEntryList());


		Scene scene = new Scene(borderPane, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
