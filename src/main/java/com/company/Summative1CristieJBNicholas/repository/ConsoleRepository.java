package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Console;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsoleRepository  {
    Console save(Console console);



    Optional<Console> findById(Integer console_id);

    Optional<Console> findByColor(String manufacturer);


    void deleteById(Integer console_id);

    List<Console> findAll();

}
