package com.group.app;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Model{
	private List<Movie> movieList = new ArrayList<Movie>();

	public ListView<String> getTitlesList(){
		ListView<String> l = new ListView<String>();
		Iterator<Movie> moviesIterator = this.movieList.iterator();

		while(moviesIterator.hasNext()) {
			l.getItems().add(moviesIterator.next().MovieTitle); 
		}

		return l;
	}

	public List<Movie> getMovieList(){
		return this.movieList;
	}
}