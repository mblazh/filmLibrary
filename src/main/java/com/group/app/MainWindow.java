package com.group.app;

import javafx.scene.Scene;
import javafx.collections.*;
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
		Label orderLabel = new Label("Order:");
		ComboBox orderOptions = new ComboBox(FXCollections.observableArrayList("A->Z", "Z->A"));
		orderOptions.getSelectionModel().selectFirst();

		topMenu.getChildren().addAll(addEntryButton, searchField, searchButton, orderLabel, orderOptions);
		topMenu.setSpacing(10);

		return topMenu;
	}

	private ListView createEntryList() {
		ListView<String> list = new ListView<String>();
		
		ObservableList<String> items = FXCollections.observableArrayList ("Lorem Ipsum", "Dolor Sit Amet", "Consectetur", "Adipiscing Elit");
		list.setItems(items);

		return list;
	}

	
	public MainWindow() {
		this.stage.setTitle("Film Library");

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.createEntryList());
		// borderPane.setCenter(); // Add here full movie information widget

		Scene scene = new Scene(borderPane, 1000, 800);
		this.stage.setScene(scene);
	}

	public void show(){
		this.stage.show();
	}
}