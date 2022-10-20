package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Console;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {
//    List<Console> findByManufacturer(String manufacturer);

    List<Console> findByManufacturer(String manufacturer);

//    void findByManufacturer(String sony);
}
