
package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

//     Optional<Invoice> findById( Integer invoice_id);
//
//    List<Invoice> findAllInvoices(String id);
}

