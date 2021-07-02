package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieGenreDTO {

	private Long id;
	private String name;
	
	MovieGenreDTO(Genre genre){
		
	}
	
	public MovieGenreDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MovieGenreDTO(Movie movie) {
		this.id = movie.getGenre().getId();
		this.name = movie.getGenre().getName();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
