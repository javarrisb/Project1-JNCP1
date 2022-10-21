package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Double>{
    ProcessingFee findByProductType(String item_type);

//    findProcessingFee
}
