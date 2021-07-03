package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value = "SELECT obj FROM Movie obj WHERE "
			+ "(:genreId = 0L OR :genreId IS NULL) OR (obj.genre.id = :genreId)"
			+ "ORDER BY obj.title")
	Page<List<MovieGenreDTO>> findGenreOrdered(Long genreId, Pageable pageable);

	@Query(value = "SELECT obj FROM Review obj INNER JOIN obj.movie mov "
			+ "WHERE mov.id = :id")
	List<ReviewDTO> findReviewByMovie(Long id);

}
