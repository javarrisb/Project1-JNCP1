package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Console;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {
 
//    List<Console> findByManufacturer(String manufacturer);
//
//
    List<Console> findAllConsolesByManufacturer(String manufacturer);
//
//      Optional<Console> findById(Integer consoleId);
 
}
