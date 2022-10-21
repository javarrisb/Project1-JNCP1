package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Games, Integer> {

    List<Games> findByStudio(String studio);
    List<Games> findByEsrbRating(String esrbRating, String rating);
    Optional<Games> findByTitle(String title);

//    List<Games> getAllGames(String title);
}
