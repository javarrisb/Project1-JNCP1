package com.company.Summative1CristieJBNicholas.repository;
import com.company.Summative1CristieJBNicholas.models.TShirt;

import java.util.List;
import java.util.Optional;

public interface TShirtRepository {
    TShirt save(TShirt tShirt);

    Optional<TShirt> findById(Integer t_shirt_id);

    Optional<TShirt> findByColor(String color);

    Optional<TShirt> findBySize(String size);

    void deleteById(Integer id);

    List<TShirt> findAll();

}
