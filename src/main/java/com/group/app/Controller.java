package com.group.app;

import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.control.ListView;

import java.awt.*;
import java.io.File;
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
			((ListView<String>)view.getMainWindow().borderPane.getLeft()).getItems().add(movie.MovieTitle);
		}
	}

	public class SearchMovieButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String searchText = view.getMainWindow().searchField.getText();
			for (Movie movie: model.getMovieList()) {
				if(movie.MovieTitle.equalsIgnoreCase(searchText)) {
					 view.getMainWindow().borderPane.setCenter(new MovieDetails(movie));
				}
			}
		}
	}

	public Controller(Model model, View view){
		this.model = model;
		this.view = view;

		this.view.getMainWindow().setAddMovieButtonHandler(new AddMovieButtonHandler());
		this.view.getMainWindow().setSearchMovieButtonHandler(new SearchMovieButtonHandler());
	}
}