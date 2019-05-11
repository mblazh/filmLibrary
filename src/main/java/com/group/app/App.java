package com.group.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private HBox createTopMenu() {
		HBox topMenu = new HBox();
		
		Button addEntryButton = new Button("Add Entry");
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

	private WebView createBrowser() {
		WebView browser = new WebView();
		// browser.getEngine().load("page.htm");

		return browser;
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Film Library");

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.createEntryList());
		borderPane.setCenter(this.createBrowser());

		Scene scene = new Scene(borderPane, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}