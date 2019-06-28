package com.group.app;

import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainWindow {
	private Stage stage = new Stage();

	private HBox createTopMenu() {
		HBox topMenu = new HBox();
		
		Button addEntryButton = new Button("Add Entry");
		TextField searchField = new TextField();
		Button searchButton = new Button("Search");

		topMenu.getChildren().addAll(addEntryButton, searchField, searchButton);
		topMenu.setSpacing(10);

		return topMenu;
	}

	private ListView createEntryList() {
		ListView<String> list = new ListView<String>();
		
		ObservableList<String> items = FXCollections.observableArrayList ("Lorem Ipsum", "Dolor Sit Amet", "Consectetur", "Adipiscing Elit");
		list.setItems(items);

		return list;
	}

	private WebView createBrowser() {
		WebView browser = new WebView();
		// browser.getEngine().load("page.htm");

		return browser;
	}
	
	public MainWindow() {
		this.stage.setTitle("Film Library");

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.createEntryList());
		borderPane.setCenter(this.createBrowser());

		Scene scene = new Scene(borderPane, 1000, 800);
		this.stage.setScene(scene);
	}

	public void show(){
		this.stage.show();
	}
}