package com.group.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javafx.scene.control.ListView;

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