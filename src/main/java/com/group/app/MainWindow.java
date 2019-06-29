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
    Button searchButton = new Button("Search");
    TextField searchField = new TextField();
	BorderPane borderPane;

	public void setAddMovieButtonHandler(EventHandler<ActionEvent> handler){
		this.addEntryButton.setOnAction(handler);
	}
    public void setSearchMovieButtonHandler(EventHandler<ActionEvent> handler){ this.searchButton.setOnAction(handler); }

	private HBox createTopMenu() {
		HBox topMenu = new HBox();
		Label orderLabel = new Label("Order:");
		ComboBox orderOptions = new ComboBox(FXCollections.observableArrayList("A->Z", "Z->A"));
		orderOptions.getSelectionModel().selectFirst();

		topMenu.getChildren().addAll(this.addEntryButton, searchField, searchButton, orderLabel, orderOptions);
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

		borderPane = new BorderPane();
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