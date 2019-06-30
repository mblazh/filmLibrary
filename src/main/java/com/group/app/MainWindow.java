package com.group.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainWindow {
	private Stage stage = new Stage();
	Button addEntryButton = new Button("Add Мovie");
    Button searchButton = new Button("Search");
    TextField searchField = new TextField();
	BorderPane borderPane;
	ListView<String> list = new ListView<String>();
	Button removeEntryButton = new Button("Remove Мovie");
	ComboBox orderOptions = new ComboBox();

	public void setAddMovieButtonHandler(EventHandler<ActionEvent> handler){
		this.addEntryButton.setOnAction(handler);
	}
    public void setSearchMovieButtonHandler(EventHandler<ActionEvent> handler){ this.searchButton.setOnAction(handler); }

	public void setRemoveEntryButtonHandler(EventHandler<ActionEvent> handler){this.removeEntryButton.setOnAction(handler);}

	public void setOrderSelectorOtions(ObservableList<String> l){
		this.orderOptions.setItems(l);
		this.orderOptions.getSelectionModel().selectFirst();
	}

	public ComboBox getOrderSelector(){
		return this.orderOptions;
	}

	public void setOrderSelectorHandler(EventHandler<ActionEvent> handler){
		this.orderOptions.setOnAction(handler);
	}

	private HBox createTopMenu() {
		HBox topMenu = new HBox();
		Label orderLabel = new Label("Order:");

		topMenu.getChildren().addAll(this.addEntryButton,removeEntryButton, searchField, searchButton, orderLabel, this.orderOptions);
		topMenu.setSpacing(10);

		return topMenu;
	}

	public void updateMoviesList(ListView<String> l) {
		this.list.setItems(l.getItems());
	}

	public MainWindow() {
		this.stage.setTitle("Film Library");

		borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.list);

		Scene scene = new Scene(borderPane, 1000, 800);
		this.stage.setScene(scene);
	}

	public void show(){
		this.stage.show();
	}
}