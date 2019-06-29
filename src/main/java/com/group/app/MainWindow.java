package com.group.app;

import javafx.scene.Scene;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.event.*;

public class MainWindow {
	private Stage stage = new Stage();
	Button addEntryButton = new Button("Add Мovie");
	ListView<String> list = new ListView<String>();

	public void setAddMovieButtonHandler(EventHandler<ActionEvent> handler){
		this.addEntryButton.setOnAction(handler);
	}

	private HBox createTopMenu() {
		HBox topMenu = new HBox();
		TextField searchField = new TextField();
		Button searchButton = new Button("Search");
		Label orderLabel = new Label("Order:");
		ComboBox orderOptions = new ComboBox(FXCollections.observableArrayList("A->Z", "Z->A"));
		orderOptions.getSelectionModel().selectFirst();

		topMenu.getChildren().addAll(this.addEntryButton, searchField, searchButton, orderLabel, orderOptions);
		topMenu.setSpacing(10);

		return topMenu;
	}

	public void updateMoviesList(ListView<String> l) {
		this.list.setItems(l.getItems());
	}
	
	public MainWindow() {
		this.stage.setTitle("Film Library");

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.list);
		// borderPane.setCenter(); // Add here full movie information widget

		Scene scene = new Scene(borderPane, 1000, 800);
		this.stage.setScene(scene);
	}

	public void show(){
		this.stage.show();
	}
}