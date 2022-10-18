package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Games, Integer> {
    
    List<Games> findAllGamesByStudio(String studio);
    List<Games> findAllGamesByESRBrating(String esrb_rating);

    List<Games> findAllGamesByTitle(String title);

}
