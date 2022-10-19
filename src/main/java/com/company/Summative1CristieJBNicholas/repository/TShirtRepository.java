package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.TShirt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Integer> {
    List<TShirt> findByColor(String color);

    List<TShirt> findBySize(String size);

    List<TShirt> findAllTShirtByColor(String color);

    List<TShirt> findAllTShirtBySize(String size);
}
