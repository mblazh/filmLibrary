package com.group.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.control.ListView;


public class Controller{
	private Model model;
	private View view;

	private String MovieTitleToRemove;

	public class AddMovieButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			AddingMovie addingMovie = new AddingMovie();
			Movie movie = addingMovie.return_Movie();

			model.getMovieList().add(movie);
			view.getMainWindow().updateMoviesList(model.getTitlesList());
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

	public class RemoveMovieButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			for (Movie movie: model.getMovieList()) {

				if(movie.MovieTitle.equals(MovieTitleToRemove)) {

					model.getMovieList().remove(movie);
					break;

				}
			}

			((ListView<String>)view.getMainWindow().borderPane.getLeft()).getItems().remove(MovieTitleToRemove);

		}
	}


	private void CheckTitleFromList(){


		((ListView<String>) view.getMainWindow().borderPane.getLeft()).getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String previous, String current) {

				MovieTitleToRemove = current;

			}
		});

	}


	public Controller(Model model, View view){
		this.model = model;
		this.view = view;

		this.view.getMainWindow().setAddMovieButtonHandler(new AddMovieButtonHandler());
		this.view.getMainWindow().setSearchMovieButtonHandler(new SearchMovieButtonHandler());
		this.view.getMainWindow().setRemoveEntryButtonHandler(new RemoveMovieButtonHandler());
		this.CheckTitleFromList();
	}
}