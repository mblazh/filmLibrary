package com.group.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
	}
}