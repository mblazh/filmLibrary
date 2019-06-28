package com.group.app;

import javafx.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controller{
	private Model model;
	private View view;

	public class AddMovieButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			AddingMovie addingMovie = new AddingMovie();
			Movie movie = addingMovie.return_Movie();

			model.getMovieList().add(movie);
		}
	}

	public Controller(Model model, View view){
		this.model = model;
		this.view = view;

		this.view.getMainWindow().setAddMovieButtonHandler(new AddMovieButtonHandler());
	}
}